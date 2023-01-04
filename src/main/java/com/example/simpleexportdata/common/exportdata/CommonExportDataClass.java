package com.example.simpleexportdata.common.exportdata;

import com.alibaba.excel.EasyExcel;
import com.example.simpleexportdata.common.exportdata.entity.CommonExportDataEntity;
import com.example.simpleexportdata.common.exportdata.entity.HttpContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 不考虑导出性能的公共导出基类
 * @param <T>
 */
public abstract class CommonExportDataClass<T> {
	private CommonExportDataEntity commonExportDataEntity;

	public CommonExportDataClass(CommonExportDataEntity commonExportDataEntity) {
		this.commonExportDataEntity = commonExportDataEntity;
	}

	// 单sheet导出
	public void export(CommonExportDataEntity commonExportDataEntity) {
		Class<T> exportObjectClass = getExportObjectClass();
		String fileName = commonExportDataEntity.getFileName();
		HttpContext context = commonExportDataEntity.getContext();
		HttpServletRequest request = context.getRequest();
		// 请求参数
		Map<String, Object> paramMap = context.getParamMap();
		HttpServletResponse response = context.getResponse();

		List<T> listData = queryData(context, paramMap);
		customDataExecute(listData);
		try {
			// 导出的文件名称默认为文件名+时间戳
			long currentTimeMillis = System.currentTimeMillis();
			fileName = URLEncoder.encode(fileName + currentTimeMillis, "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
			EasyExcel.write(response.getOutputStream(), exportObjectClass).sheet("sheet1").doWrite(listData);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	// 查数据库
	protected abstract List<T> queryData(HttpContext context, Map<String, Object> paramMap);

	// 要导出的数据，自定义处理逻辑
	protected abstract void customDataExecute(List<T> listData);

	// 获取导出类的class
	protected abstract Class<T> getExportObjectClass();


	public CommonExportDataEntity getCommonExportDataEntity() {
		return commonExportDataEntity;
	}

	public void setCommonExportDataEntity(CommonExportDataEntity commonExportDataEntity) {
		this.commonExportDataEntity = commonExportDataEntity;
	}

}
