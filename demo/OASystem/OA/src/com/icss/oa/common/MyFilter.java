package com.icss.oa.common;

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

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter implements Filter {
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		请求响应对象
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;	
		
//		统一设置编码
		req.setCharacterEncoding("utf-8");
		rep.setContentType("text/html;charset=utf-8");
		
//		设置允许跨域请求
		rep.setHeader("Access-Control-Allow-Origin", "*");
			
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}