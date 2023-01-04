package com.example.simpleexportdata.common.exportdata.entity;

public class CommonExportDataEntity {

	private String fileName;
	private HttpContext context;

	public CommonExportDataEntity(String fileName, HttpContext context) {
		this.fileName = fileName;
		this.context = context;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public HttpContext getContext() {
		return context;
	}

	public void setContext(HttpContext context) {
		this.context = context;
	}
}
