package com.icss.hr.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DbUtil;
import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

/**
 * 员工Dao
 * 
 * @author 李波
 *
 */
public class EmpDao {

	public void insert(Emp emp) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "insert into emp values (emp_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpLoginName());
		pstmt.setString(3, emp.getEmpPwd());
		pstmt.setString(4, emp.getEmpEmail());
		pstmt.setString(5, emp.getEmpPhone());
		pstmt.setDouble(6, emp.getEmpSalary());
		pstmt.setDate(7, emp.getEmpHiredate());
		pstmt.setInt(8, emp.getDept().getDeptId());
		pstmt.setInt(9, emp.getJob().getJobId());
		pstmt.setString(10, emp.getEmpPic());
		pstmt.setString(11, emp.getEmpInfo());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 修改数据
	 * 
	 * @param emp
	 * @throws SQLException
	 */
	public void update(Emp emp) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "update emp set emp_name=?,emp_phone=?,emp_salary=?,emp_dept_id=?,emp_job_id=?,emp_info=? where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpPhone());
		pstmt.setDouble(3, emp.getEmpSalary());
		pstmt.setInt(4, emp.getDept().getDeptId());
		pstmt.setInt(5, emp.getJob().getJobId());
		pstmt.setString(6, emp.getEmpInfo());
		pstmt.setInt(7, emp.getEmpId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 删除数据
	 * 
	 * @param empId
	 * @throws SQLException
	 */
	public void delete(int empId) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "delete from emp where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 根据id查询Emp数据,单表查询(不需要查询部门名称和职务,只需要查部门id存储到Emp对象中)
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Emp queryById(int empId) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT * from emp where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet resultSet = pstmt.executeQuery();
		Emp emp = null;
		while (resultSet.next()) {
			emp = new Emp();
			emp.setEmpId(resultSet.getInt("emp_id"));
			emp.setEmpName(resultSet.getString("emp_name"));
			emp.setEmpLoginName(resultSet.getString("emp_login_name"));
			emp.setEmpPwd(resultSet.getString("emp_pwd"));

			emp.setEmpEmail(resultSet.getString("emp_email"));
			emp.setEmpPhone(resultSet.getString("emp_phone"));
			emp.setEmpSalary(resultSet.getDouble("emp_salary"));
			emp.setEmpHiredate(resultSet.getDate("emp_hiredate"));
			Dept dept = new Dept();
			dept.setDeptId(resultSet.getInt("emp_dept_id"));
			emp.setDept(dept);
			Job job = new Job();
			job.setJobId(resultSet.getInt("emp_job_id"));
			emp.setJob(job);
			emp.setEmpPic(resultSet.getString("emp_pic"));
			emp.setEmpInfo(resultSet.getString("emp_info"));

		}
		resultSet.close();
		pstmt.close();
		conn.close();
		return emp;
	}

	/**
	 * 传入登录名,根据登录名称查询满足条件的员工数据返回(员工编号,登录名,密码,头像) 登录名不存在,返回null
	 * 
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	public Emp queryByLoginName(String empLoginName) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT emp_id,emp_login_name,emp_pwd,emp_name,emp_pic from emp where emp_login_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, empLoginName);
		ResultSet resultSet = pstmt.executeQuery();
		Emp emp = null;
		while (resultSet.next()) {
			emp = new Emp();
			emp.setEmpId(resultSet.getInt("emp_id"));
			emp.setEmpLoginName(resultSet.getString("emp_login_name"));
			emp.setEmpPwd(resultSet.getString("emp_pwd"));
			emp.setEmpName(resultSet.getString("emp_name"));
			emp.setEmpPic(resultSet.getString("emp_pic"));
		}
		resultSet.close();
		pstmt.close();
		conn.close();
		return emp;
	}

	/**
	 * 返回表的总记录数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "SELECT count(*) from emp";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();
		int count = resultSet.getInt(1);
		resultSet.close();
		pstmt.close();
		conn.close();
		return count;
	}

	public List<Emp> queryByPage(Pager pager) throws SQLException {
		Connection conn = DbUtil.getConnection();

		StringBuffer sBuffer = new StringBuffer();

		sBuffer.append("SELECT *");
		sBuffer.append("FROM   (SELECT rownum rnum,");
		sBuffer.append("               e.emp_id,");
		sBuffer.append("               e.emp_name,");
		sBuffer.append("               e.emp_login_name,");
		sBuffer.append("               e.emp_pwd,");
		sBuffer.append("               e.emp_email,");
		sBuffer.append("               e.emp_phone,");
		sBuffer.append("               e.emp_salary,");
		sBuffer.append("               e.emp_hiredate,");
		sBuffer.append("               d.dept_name,");
		sBuffer.append("               j.job_name,");
		sBuffer.append("               e.emp_info ");
		sBuffer.append("        FROM   emp e ");
		sBuffer.append("        LEFT   OUTER JOIN dept d ON e.emp_dept_id = d.dept_id ");
		sBuffer.append("        LEFT   OUTER JOIN job j ON e.emp_job_id = j.job_id) ");
		sBuffer.append("WHERE  rnum BETWEEN ? AND ?");
		PreparedStatement pstmt = conn.prepareStatement(sBuffer.toString());

		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getPageSize() * pager.getPageNum());

		ResultSet resultSet = pstmt.executeQuery();
		ArrayList<Emp> list = new ArrayList<>();

		while (resultSet.next()) {
			Dept dept = new Dept();
			Job job = new Job();
			Emp emp = new Emp();
			emp = new Emp();
			emp.setEmpId(resultSet.getInt("emp_id"));
			emp.setEmpName(resultSet.getString("emp_name"));
			emp.setEmpLoginName(resultSet.getString("emp_login_name"));
			emp.setEmpPwd(resultSet.getString("emp_pwd"));
			emp.setEmpEmail(resultSet.getString("emp_email"));
			emp.setEmpPhone(resultSet.getString("emp_phone"));
			emp.setEmpSalary(resultSet.getDouble("emp_salary"));
			emp.setEmpHiredate(resultSet.getDate("emp_hiredate"));

			dept.setDeptName(resultSet.getString("dept_name"));
			emp.setDept(dept);
			job.setJobName(resultSet.getString("job_name"));
			emp.setJob(job);
			emp.setEmpPic(null);
			emp.setEmpInfo(resultSet.getString("emp_info"));
			list.add(emp);
		}

		return list;

	}

	/**
	 * 根据登录名修改密码
	 * @throws SQLException 
	 */
	public void updatePwd(Emp emp) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "update emp set emp_pwd=? where emp_login_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpPwd());
		pstmt.setString(2, emp.getEmpLoginName());
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	
	/**
	 * 根据登录名更新头像
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "update emp set emp_pic=? where emp_login_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, empPic);
		pstmt.setString(2, empLoginName);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
}
