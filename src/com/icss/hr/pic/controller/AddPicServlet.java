package com.icss.hr.pic.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * 上传图片到数据库
 * 
 * @author 李波
 *
 */
@WebServlet("/AddPicServlet")
public class AddPicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 获得Servlet上下文对象
		ServletContext context = this.getServletContext();

		// 磁盘文件列表工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 设置内存区块大小4KB
		factory.setSizeThreshold(4 * 1024);
		
		// 设置暂存容器临时目录，当上传文件大于设置的内存块大小时，用暂存容器做中转（非常重要）
		File tempFile = new File(context.getRealPath("/temp"));
		
		//如果不存在自动创建
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		// Servlet文件上传对象
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 获得上传列表
		try {
			// 设置最大上传文件大小为1000M，超出大小会发生异常
			upload.setSizeMax(1024 * 1024 * 1);

			// 获得所有上传文件对象集合
			List<FileItem> list = upload.parseRequest(request);

			// 获得第一个文件对象
			FileItem picData = list.get(0);
			String picInfo = list.get(1).getString();
			picInfo = new String(picInfo.getBytes("iso-8859-1"),"utf-8");

//			System.out.println("图片名称:"+picData.getName());
//			System.out.println("图片描述:"+picInfo);
			
			HttpSession session = request.getSession();
			String empLoginName = (String) session.getAttribute("empLoginName");
			Pic pic = new Pic(picData.getName(), picInfo, picData.getSize(), empLoginName, picData.getInputStream(), new Date());
			
			PicService service = new PicService();
			
			service.addPic(pic);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
