package com.icss.test;

import java.sql.SQLException;

import org.junit.Test;

import com.icss.hr.emp.service.EmpService;

/**
 * Ա��ҵ�����
 * @author �
 *
 */
public class TestEmpService {

	private EmpService service = new EmpService();
	
	@Test
	public void testChecklogin() throws SQLException{
		
		int result = service.checkLongin("tom", "xxx");
		System.out.println(result);
	}
}
