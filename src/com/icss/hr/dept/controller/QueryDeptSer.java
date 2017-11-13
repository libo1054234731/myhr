package com.icss.hr.dept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * 查询部门控制器
 * 
 * @author 李波
 *
 */
@WebServlet("/QueryDeptSer")
public class QueryDeptSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService service = new DeptService();
		try {
			List<Dept> list = service.qureyDept();
			
			//把数据存储在request范围
			request.setAttribute("list", list);
			//请求转发到JSP视图
			request.getRequestDispatcher("/WEB-INF/QueryDept.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/error.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
