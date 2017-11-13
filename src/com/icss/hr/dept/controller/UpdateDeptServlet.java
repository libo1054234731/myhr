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
 * 修改部门控制器
 * 
 * @author 李波
 *
 */
@WebServlet("/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求编码
		request.setCharacterEncoding("utf-8");

		// 设置响应的MIME类型和编码
		response.setContentType("text/html;charset=utf-8");

		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");

		// 封装为pojo对象 创建Dept 实例
		Dept dept = new Dept(Integer.parseInt(deptId), deptName, deptLoc);

		// 调用业务对象 创建DeptService 实例
		DeptService d = new DeptService();

		try {
			d.updateDept(dept);
			response.sendRedirect("QueryDeptSer");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
