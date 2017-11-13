package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.icss.hr.emp.service.EmpService;

/**
 * �û�����������Ӧ1 ���������Ӧ2 ��¼�ɹ���Ӧ3
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������Ӧ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// �����
		PrintWriter out = response.getWriter();

		// ����������
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");

		EmpService service =new EmpService();
		
		try {
			int i = service.checkLongin(empLoginName, empPwd);
			
			//�����䛳ɹ��� session�����惦����
			if (i == 3) {
				
				HttpSession session = request.getSession();
				session.setAttribute("empLoginName", empLoginName);
			}
			
			Gson gson = new Gson();
			out.write(gson.toJson(i));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
