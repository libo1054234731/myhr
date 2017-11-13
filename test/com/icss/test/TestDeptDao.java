package com.icss.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 测试部门数据访问功能
 * 
 * @author 李波
 *
 */
public class TestDeptDao {
	private DeptDao dao = new DeptDao();

	@Test
	public void testInsert() throws SQLException {

		Dept dept = new Dept("开发部", "大连");
		dao.insert(dept);
	}

	@Test
	public void testUpdate() {

		Dept dept = new Dept(1, "开发部", "大连");
		try {
			dao.upDate(dept);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	@Test
	public void textDelete() {
		try {
			dao.delete(4);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Test
	public void textQueryById(){
		try {
			Dept dept = dao.queryById(10);
			System.out.println(dept);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Test
	public void textQuery(){
		
		try {
			List<Dept> depts = dao.query();
			for (Iterator iterator = depts.iterator(); iterator.hasNext();) {
				Dept dept = (Dept) iterator.next();
				System.out.println(dept);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
