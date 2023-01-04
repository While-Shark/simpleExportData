package com.example.simpleexportdata.common.exportdata.entity;

import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

public class HttpContext {
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;

	public HttpContext( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
	}


	public HttpServletRequest getRequest() {
		return this.httpServletRequest;
	}

	public HttpServletResponse getResponse() {
		return this.httpServletResponse;
	}

	// 获取请求参数集合
	public Map<String,Object> getParamMap(){
		Map<String,Object> paramMap = Maps.newHashMap();
		Enumeration parameterNames = httpServletRequest.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterKey = (String) parameterNames.nextElement();
			String value = httpServletRequest.getParameter(parameterKey);
			paramMap.put(parameterKey,value);
		}
		return paramMap;
	}

}
