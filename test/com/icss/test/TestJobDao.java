package com.icss.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务Dao测试类
 * @author 李波
 *
 */
public class TestJobDao {
	private JobDao dao = new JobDao();

	@Test
	public void testInsert() throws SQLException {

		Job job = new Job("JQ工程师", 5000,15000);
		dao.insert(job);
	}
	
	
	@Test
	public void testUpdate() {

		Job job = new Job(6,"JS工程师", 6000,18000);
		try {
			dao.update(job);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void textDelete() {
		try {
			dao.delete(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void textQueryById(){
		try {
			Job job = dao.queryById(3);
			System.out.println(job);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void textQuery(){
		
		try {
			List<Job> jobs = dao.query();
			for (Iterator iterator = jobs.iterator(); iterator.hasNext();) {
				Job job = (Job) iterator.next();
				System.out.println(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
