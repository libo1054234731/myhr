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

import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * �����û�������base64����
 * 
 * @author �
 *
 */
@WebServlet("/GetEmpPicServlet")
public class GetEmpPicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���ͷ��base64����
		String empPic = request.getParameter("empPic");
		// �����
		PrintWriter out = response.getWriter();
		// ��õ�ǰ�û��ĵ�¼��
		HttpSession session = request.getSession();

		String empLoginName = (String) session.getAttribute("empLoginName");

		EmpService service = new EmpService();
		// ����ҵ�����
		try {
			Emp emp = service.queryByLoginName(empLoginName);
			if (emp == null) {
				out.print(emp);
			}else{
				out.print(emp.getEmpPic());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
