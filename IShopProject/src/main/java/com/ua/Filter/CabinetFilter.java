package com.ua.Filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.ua.Shared.FilterService;
import com.ua.Shared.UserRole;

@WebFilter("/cabinet.jsp")
public class CabinetFilter implements Filter {

	private FilterService filterService = FilterService.getFilterService();
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.ADMINISTRATOR, UserRole.USER));
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
