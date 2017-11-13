package com.icss.hr.dept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * ɾ�����ŵĿ�����
 * 
 * @author �
 *
 */
@WebServlet("/DelDeptServlet")
public class DelDeptServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptId = request.getParameter("deptId");

		DeptService service = new DeptService();

		try {
			service.deleteDept(Integer.parseInt(deptId));
			
			//�ض��򵽲�ѯ
			
			response.sendRedirect("QueryDeptSer");
			
		} catch (NumberFormatException | SQLException e1) {
			e1.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
