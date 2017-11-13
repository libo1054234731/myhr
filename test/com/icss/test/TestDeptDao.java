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
 * ���Բ������ݷ��ʹ���
 * 
 * @author �
 *
 */
public class TestDeptDao {
	private DeptDao dao = new DeptDao();

	@Test
	public void testInsert() throws SQLException {

		Dept dept = new Dept("������", "����");
		dao.insert(dept);
	}

	@Test
	public void testUpdate() {

		Dept dept = new Dept(1, "������", "����");
		try {
			dao.upDate(dept);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	@Test
	public void textDelete() {
		try {
			dao.delete(4);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	@Test
	public void textQueryById(){
		try {
			Dept dept = dao.queryById(10);
			System.out.println(dept);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
