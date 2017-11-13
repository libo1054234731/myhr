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
 * 添加部门 控制器
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求编码
		request.setCharacterEncoding("utf-8");
		
		// 设置响应编码
		// 手动切换编码                                     
		// response.setCharacterEncoding("utf-8");
		// 设置响应的MIME类型和编码
		response.setContentType("text/html;charset=utf-8");

		// 响应输出流
		PrintWriter out = response.getWriter();

		// 获得请求参数
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");

		// 显示内容 (测试)
		// System.out.println("部门名:" + deptName);
		// System.out.println("部门地址：" + deptLoc);

		// 封装为pojo对象 创建Dept 实例
		Dept dept = new Dept(deptName, deptLoc);

		// 调用业务对象 创建DeptService 实例
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
