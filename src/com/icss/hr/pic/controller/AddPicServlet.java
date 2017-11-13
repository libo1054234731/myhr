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
 * �ϴ�ͼƬ�����ݿ�
 * 
 * @author �
 *
 */
@WebServlet("/AddPicServlet")
public class AddPicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// ���Servlet�����Ķ���
		ServletContext context = this.getServletContext();

		// �����ļ��б�������
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// �����ڴ������С4KB
		factory.setSizeThreshold(4 * 1024);
		
		// �����ݴ�������ʱĿ¼�����ϴ��ļ��������õ��ڴ���Сʱ�����ݴ���������ת���ǳ���Ҫ��
		File tempFile = new File(context.getRealPath("/temp"));
		
		//����������Զ�����
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		// Servlet�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		// ����ϴ��б�
		try {
			// ��������ϴ��ļ���СΪ1000M��������С�ᷢ���쳣
			upload.setSizeMax(1024 * 1024 * 1);

			// ��������ϴ��ļ����󼯺�
			List<FileItem> list = upload.parseRequest(request);

			// ��õ�һ���ļ�����
			FileItem picData = list.get(0);
			String picInfo = list.get(1).getString();
			picInfo = new String(picInfo.getBytes("iso-8859-1"),"utf-8");

//			System.out.println("ͼƬ����:"+picData.getName());
//			System.out.println("ͼƬ����:"+picInfo);
			
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
