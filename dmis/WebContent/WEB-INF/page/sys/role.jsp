<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${contextPath}/static/hplus/js/table/bootstrap.min.css">
	<link rel="stylesheet" href="${contextPath}/static/js/bootstrap-dialog.min.css">
	<link rel="stylesheet" href="${contextPath}/static/hplus/js/table/bootstrap-table.css">
	<script src="${contextPath}/static/hplus/js/table/jquery-3.1.1.min.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap.min.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table-zh-CN.js"></script>
	<script src="${contextPath}/static/js/bootstrap-dialog.min.js"></script>

</head>
<body>

	<table id="role_table"></table>

</body>
<script type="text/javascript">
		
		
	$(function(){
			 
		$("#role_table").bootstrapTable({
				//sidePagination:  "/cems/quality/getAllQuality.action", //服务端处理分页
   			url: '${contextPath}/sys/menu/getMenuList',
   			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                    // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber

   			striped: true,
            pagination: true,
            pageList: [2,20,50,100],
            pageSize:2,
            pageNumber:1,
            sidePagination:'server',//设置为服务器端分页
   			columns: [
   				{checkbox: true}, 
   				{field: 'id', title: '编号'}, 
       			{field: 'menuName', title: '角色名称'}, 
    			{field: 'menuNo', title: '角色编码' },
    			{field: 'summary', title: '描述'},
    			{
	                title: '操作',
	                field: 'id',
	                align: 'center',
	                formatter:function(value,row,index){  
                   		var e = '<a onclick="edit(\''+ row.id +'\')">编辑</a> ';  
                  	 	var d = '<a onclick="deletes(\''+ row.id +'\')">删除</a> ';  
                   		var d = '<a onclick="addCourse(\''+ row.id +'\')">添加</a> ';  
                        return e+d;  
                 	} 
            	}
    		]	
		});
			
	});

			
</script>
</html>