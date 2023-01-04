package com.example.simpleexportdata.common.exportdata.demo;

import com.alibaba.excel.util.ListUtils;
import com.example.simpleexportdata.common.exportdata.CommonExportDataClass;
import com.example.simpleexportdata.common.exportdata.entity.CommonExportDataEntity;
import com.example.simpleexportdata.common.exportdata.entity.HttpContext;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 导出示例
 */
public class DemoDataExportClass extends CommonExportDataClass<DemoData> {

	// 这里注入dao或service

	public DemoDataExportClass(CommonExportDataEntity commonExportDataEntity) {
		super(commonExportDataEntity);
	}

	private List<DemoData> data() {
		List<DemoData> list = ListUtils.newArrayList();
		for (int i = 0; i < 10; i++) {
			DemoData data = new DemoData();
			data.setString("字符串" + i);
			data.setDate(new Date());
			data.setDoubleData(0.56);
			list.add(data);
		}
		return list;
	}

	/**
	 * 查数据库
	 * @param context
	 * @param paramMap
	 * @return
	 */
	@Override
	protected List<DemoData> queryData(HttpContext context, Map<String, Object> paramMap) {
		String pageNum = String.valueOf(paramMap.get("pageNum"));
		String pageSize = String.valueOf(paramMap.get("pageSize"));
		String name = String.valueOf(paramMap.get("name"));
		// 这里去查数据库,转成list集合

		return data();
	}

	/**
	 * 自定义逻辑处理
	 * @param listData
	 */
	@Override
	protected void customDataExecute(List<DemoData> listData) {
		listData.forEach(e -> {
			e.setString(e.getString() + "示例");
		});
	}

	@Override
	protected Class<DemoData> getExportObjectClass() {
		return DemoData.class;
	}
}
