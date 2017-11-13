package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;

/**
 * �޸�Ա��������
 * 
 * @author �
 *
 */
@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����������Ӧ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//�����
		PrintWriter out = response.getWriter();
		
		// ����������
		String empId =request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empPhone = request.getParameter("empPhone");
		String empSalary = request.getParameter("empSalary");
		String deptId = request.getParameter("deptId");
		String jobId = request.getParameter("jobId");
		String empInfo = request.getParameter("empInfo");
		
		//��װΪpojo����
		Dept dept = new Dept();
		dept.setDeptId(Integer.parseInt(deptId));
		Job job = new Job();
		job.setJobId(Integer.parseInt(jobId));
		
		Emp emp = new Emp(Integer.parseInt(empId),empName,null,null,null,empPhone,Double.parseDouble(empSalary),null,dept,job,null,empInfo);
		
		//����ҵ�������
		EmpService empService = new EmpService();
		try {
			empService.updateEmp(emp);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
