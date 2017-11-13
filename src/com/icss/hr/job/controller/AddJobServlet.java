package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * ����ְ�������
 * 
 * @author �
 *
 */
@WebServlet("/AddJobServlet")
public class AddJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����������Ӧ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// ��Ӧ�����
		PrintWriter out = response.getWriter();
		
		// ����������
		String jobName = request.getParameter("jobName");
		String jobMinSal = request.getParameter("jobMinSal");
		String jobMaxSal = request.getParameter("jobMaxSal");
		
		//��װΪpojo����
		Job job = new Job(jobName,Integer.parseInt(jobMinSal),Integer.parseInt(jobMaxSal));
		
		//����ҵ�������
		JobService jobService = new JobService();
		try {
			jobService.addJob(job);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
