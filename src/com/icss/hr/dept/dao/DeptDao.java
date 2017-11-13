package com.icss.hr.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DbUtil;
import com.icss.hr.dept.pojo.Dept;

/***
 * ����dao
 * 
 * @author �
 *
 */
public class DeptDao {

	/**
	 * ��������
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public void insert(Dept dept) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "insert into dept values (dept_seq.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * �޸�����
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public void upDate(Dept dept) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "update dept set dept_name=?,dept_loc=? where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());
		pstmt.setInt(3, dept.getDeptId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * ɾ������
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public void delete(int deptId) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "delete from dept where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();

	}

	/**
	 * ����ID��ѯ���ص�������
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	public Dept queryById(int deptId) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * from dept where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet resultSet = pstmt.executeQuery();
		Dept dept=null;
		while (resultSet.next()) {
			dept = new Dept();
			dept.setDeptId(resultSet.getInt("dept_id"));
			dept.setDeptName(resultSet.getString("dept_name"));
			dept.setDeptLoc(resultSet.getString("dept_loc"));
		}
		resultSet.close();
		pstmt.close();
		conn.close();
		return dept;
	}

	/**
	 * ���ض�������
	 * 
	 * @param dept
	 * @throws SQLException 
	 */
	public List<Dept> query() throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * from dept";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet resultSet = pstmt.executeQuery();
		List<Dept> list = new ArrayList<>();
		while (resultSet.next()) {
			Dept dept = new Dept();
			dept.setDeptId(resultSet.getInt("dept_id"));
			dept.setDeptName(resultSet.getString("dept_name"));
			dept.setDeptLoc(resultSet.getString("dept_loc"));
			list.add(dept);
		}
		resultSet.close();
		pstmt.close();
		conn.close();
		return list;
	}

}
