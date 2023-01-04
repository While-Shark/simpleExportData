package com.example.simpleexportdata.common.exportdata.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ColumnWidth(30)
public class DemoData {

	@ExcelProperty(value = "字符串")
	private String string;

	@ExcelProperty(value = "日期")
	private Date date;

	@ExcelProperty(value = "doubleData")
	private Double doubleData;
}