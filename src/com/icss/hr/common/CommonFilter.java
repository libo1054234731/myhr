package com.icss.hr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 公共过滤器
 */
@WebFilter("/*")
public class CommonFilter implements Filter {

	public CommonFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		// 转换类型
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 设置允许其他域名访问项目
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 设置请求编码
		request.setCharacterEncoding("utf-8");
		// 设置响应编码
		response.setContentType("text/html;charset=utf-8");
		// 输出请求uri
		String uri = request.getRequestURI().toString();
//		System.out.println(uri);
		// web应用的名称
		String app = request.getContextPath();

		// 判断用户登录状态
		//判断用户登录状态
		if ( !uri.equals(app + "/") 
				&& !uri.equals(app + "/login.html")
				&& !uri.equals(app + "/logout.jsp")
				&& !uri.equals(app + "/LoginServlet")
				&& !uri.startsWith(app + "/css")
				&& !uri.startsWith(app + "/js")
				&& !uri.startsWith(app + "/images")) {
			
			HttpSession session = request.getSession();
			String empLoginName = (String) session.getAttribute("empLoginName");
		
			if(empLoginName == null){
				//判断请求是否是ajax请求
				String ajaxHeader = request.getHeader("x-requested-with");
				
				if (ajaxHeader != null && ajaxHeader.equalsIgnoreCase("xmlhttprequest")) {
					//是ajax 请求,响应在前段判断
					response.setHeader("sessionStatus", "timeout");
				}else{
					response.sendRedirect(app + "/logout.jsp");
				}
				
				DbUtil.close();
				return;
			}
			
		}

		chain.doFilter(request, response);
		
		DbUtil.close();
		
		
		
		
		
		

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
