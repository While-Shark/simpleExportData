# simpleExportData
这是一款不考虑导出性能的单sheet页导出工具类

如果你使用过easyexcel，那么你一定很容易就接纳这款工具

导出效果如下：
![Dingtalk_20230104141357](https://user-images.githubusercontent.com/24545680/210494984-f76a1fcd-262d-4bcd-89e7-fe7ffc136a89.jpg)


# 使用步骤
## 1、定义要导出的实体类，本示例为DemoData

```
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
```
## 2、自定义实现类继承CommonExportDataClass，本示例为DemoDataExportClass
### 实现三个方法queryData()、customDataExecute()、getExportObjectClass()

### queryData()是查数据库、customDataExecute()是查完数据库后，可以对查询结果做自定义逻辑处理、getExportObjectClass()是返回要导出数据的class类型

## 3、最终导出
### 在controller代码中，new几个对象，调用export方法，本示例如下：
```
// 封装请求和响应
HttpContext httpContext = new HttpContext(request, response);
// new一个对象
CommonExportDataEntity commonExportDataEntity =new CommonExportDataEntity("simple导出示例", httpContext);
// new一个导出实现类
DemoDataExportClass demoDataExportClass = new DemoDataExportClass(commonExportDataEntity);
// 调用导出方法
demoDataExportClass.export(demoDataExportClass.getCommonExportDataEntity());
```
## 如此一来，就完成了导出工作。本示例启动项目后访问http://localhost:8080/demo/exportData 即可导出示例文件
