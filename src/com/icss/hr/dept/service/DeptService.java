package com.icss.hr.dept.service;

import java.util.List;
import java.sql.SQLException;


import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 部门业务
 * @author 李波
 *
 */
public class DeptService {

	private DeptDao dao = new DeptDao();
	
	public void addDept(Dept dept) throws SQLException {
		dao.insert(dept);
	}
	public void updateDept(Dept dept) throws SQLException {
		dao.upDate(dept);
	}
	public void deleteDept(int deptId) throws SQLException {
		dao.delete(deptId);
	}
	public Dept queryDeptById(int deptId) throws SQLException {
		return dao.queryById(deptId);
	}
	public List<Dept> qureyDept() throws SQLException {
		return dao.query();
	}
}
