package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * ��Ӳ��� ������
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����������
		request.setCharacterEncoding("utf-8");
		
		// ������Ӧ����
		// �ֶ��л�����                                     
		// response.setCharacterEncoding("utf-8");
		// ������Ӧ��MIME���ͺͱ���
		response.setContentType("text/html;charset=utf-8");

		// ��Ӧ�����
		PrintWriter out = response.getWriter();

		// ����������
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");

		// ��ʾ���� (����)
		// System.out.println("������:" + deptName);
		// System.out.println("���ŵ�ַ��" + deptLoc);

		// ��װΪpojo���� ����Dept ʵ��
		Dept dept = new Dept(deptName, deptLoc);

		// ����ҵ����� ����DeptService ʵ��
		DeptService d = new DeptService();

		try {
			d.addDept(dept);
			response.sendRedirect("QueryDeptSer");
		} catch (SQLException e) {
			e.printStackTrace();

			out.println(e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
