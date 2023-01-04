package com.example.simpleexportdata.controller;

import com.example.simpleexportdata.common.exportdata.demo.DemoDataExportClass;
import com.example.simpleexportdata.common.exportdata.entity.CommonExportDataEntity;
import com.example.simpleexportdata.common.exportdata.entity.HttpContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/demo")
public class DemoController {


	@RequestMapping("/exportData")
	public void exportDemoData(HttpServletRequest request, HttpServletResponse response) {
		HttpContext httpContext = new HttpContext(request, response);
		CommonExportDataEntity commonExportDataEntity =
				new CommonExportDataEntity("simple导出示例", httpContext);
		DemoDataExportClass demoDataExportClass = new DemoDataExportClass(commonExportDataEntity);
		demoDataExportClass.export(demoDataExportClass.getCommonExportDataEntity());
	}

}
