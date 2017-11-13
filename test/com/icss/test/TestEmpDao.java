package com.icss.test;

import java.util.Iterator;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;

/**
 * 员工Dao测试
 */
import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

public class TestEmpDao {
	private EmpDao dao = new EmpDao();

	@Test
	public void testInsert() throws SQLException {

		Dept dept = new Dept();
		dept.setDeptId(1);
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp("jack", "jack", "123456", "tom@163.com", "13012345678", 3600.0, Date.valueOf("1995-10-10"),
				dept, job, null, "精通JAVA,ORACLE");
		dao.insert(emp);
		System.out.println(emp);
	}

	@Test
	public void testUpdate() throws SQLException {

		Dept dept = new Dept();
		dept.setDeptId(2);
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp(2, "jack", "jack", "123456", "tom@163.com", "13012345678", 3600.0, Date.valueOf("1995-10-10"),
				dept, job, null, "精通JAVA,ORACLE");
		dao.update(emp);
	}

	@Test
	public void textDelete() throws SQLException {

		dao.delete(2);

	}

	@Test
	public void textQueryById() throws SQLException {
		Emp emp = dao.queryById(4);
		System.out.println(emp);

	}

	@Test
	public void testQueryByLoginName() throws SQLException {
		Emp emp = dao.queryByLoginName("jack1");
		System.out.println(emp);

	}

	@Test
	public void testInsertMany() throws SQLException {

		Dept dept = new Dept();
		dept.setDeptId(1);
		Job job = new Job();
		job.setJobId(1);

		for (int i = 1; i < 21; i++) {

			Emp emp = new Emp("jack" + i+20, "jack" + i+20, "123456", "jack@163.com", "13012345678", 4700.0,
					Date.valueOf("2000-10-1"), dept, job, null, "精通JAVA,ORACLE");
			dao.insert(emp);
			System.out.println(emp);

		}
	}
	
	@Test
	public void testGetCount() throws SQLException {
		
		int count = dao.getCount();
		System.out.println(count);
	}
	
	@Test
	public void queryByPage() throws SQLException {
		
		Pager pager = new Pager(dao.getCount(), 1);
		List<Emp> list = dao.queryByPage(pager);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Emp emp = (Emp) iterator.next();
			System.out.println(emp);
		}
		
	}
	
	@Test
	public void testUpdateEmpPic() throws SQLException{
		
		dao.updateEmpPic("jack1", "abcdefghigk");
		
	}
	

}
