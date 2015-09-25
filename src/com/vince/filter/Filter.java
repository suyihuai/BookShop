package com.vince.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Filter implements javax.servlet.Filter {

	private static String CODE = "UTF-8";
    public Filter() {

    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(CODE);
		response.setCharacterEncoding(CODE);
		System.out.println("doFilter...");
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
