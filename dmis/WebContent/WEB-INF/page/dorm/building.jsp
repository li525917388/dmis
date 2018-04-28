<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${contextPath}/static/layer/mobile/need/layer.css">
	<link rel="stylesheet" href="${contextPath}/static/hplus/js/table/bootstrap.min.css">
	<link rel="stylesheet" href="${contextPath}/static/hplus/js/table/bootstrap-table.css">
	
	
	<script src="${contextPath}/static/hplus/js/table/jquery-3.1.1.min.js"></script>
	<script src="${contextPath}/static/layer/layer.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap.min.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table-zh-CN.js"></script>

</head>
<body>

	<table id="role_table"></table>

</body>
<script type="text/javascript">
	
	//查看楼管员
	function lookBuildPipe(bid){
		parent.layer.open({
			type: 2,
			title: '楼管员',
			shadeClose: true,
			shade: 0.5,
			closeBtn: 1,
			//maxmin: true, //开启最大化最小化按钮
			area: ['600px', '400px'],
			content: '${contextPath}/dorm/building/toBuildPipe?bid='+ bid
		});
	}
		
	
	$(function(){
			 
		$("#role_table").bootstrapTable({
				//sidePagination:  "/cems/quality/getAllQuality.action", //服务端处理分页
   			url: '${contextPath}/dorm/building/getBuildingList',
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
   				{field: 'id', title: 'id'}, 
       			{field: 'no', title: '编号'}, 
    			{field: 'type', title: '类型' },
    			{field: 'name', title: '名称'},
    			{
	                title: '操作',
	                field: 'id',
	                align: 'center',
	                formatter:function(value,row,index){  
                   		var e = '<a onclick="lookBuildPipe(\''+ row.id +'\')">管理员</a> ';  
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