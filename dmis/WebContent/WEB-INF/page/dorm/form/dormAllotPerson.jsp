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
	<%-- <link rel="stylesheet" href="${contextPath}/static/js/bootstrap-dialog.min.css"> --%>
	<link rel="stylesheet" href="${contextPath}/static/hplus/js/table/bootstrap-table.css">
	
	
	<script src="${contextPath}/static/hplus/js/table/jquery-3.1.1.min.js"></script>
	<script src="${contextPath}/static/layer/layer.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap.min.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table-zh-CN.js"></script>
</head>
<body>
	<input id="dormId" type="hidden" value="${dormId }">
	<table id="dormPerson_table"></table>
	
	<!-- 加人弹出框 -->
	<div id="addPersonDiv" style="display: none;">
		<input id="person_id" type="text">
	</div>
</body>

<script type="text/javascript">

//表格参数
function queryParams(params) {  //bootstrapTable自带参数 
	
	var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的  
		pageSize: params.pageSize,   //页面大小  
		pageNumber: params.pageNumber,  //页码  
		dormId: $("#dormId").val(),
		sort: params.sort,  //排序列名  
		sortOrder: params.order//排位命令（desc，asc）  
	};  
	
	return temp;  
}

//加人
function addPerson(bedId){
	$("#person_id").val("");
	
	layer.open({
		type: 1,
		title: "添加学生",
		btn: ["添加","取消"],
		closeBtn: 1,
		area: ['400px', '300px'],
		content: $("#addPersonDiv"),
		yes: function(ind){
			var uid = $("#person_id").val();
			var dormId = $("#dormId").val();
			
			$.ajax({
				url: "${contextPath}/dorm/dormitory/dormAddPerson",
				type: "post",
				data: {stuId:uid, bedId:bedId, dormId:dormId},
				success: function(res){
					
					if(res == 1){
						layer.msg("添加成功");
						dormPersonRefresh();
						layer.close(ind);
					}else{
						layer.msg("添加失败");
					}
				}
			});
		}
	});
}

//删人
function removePerson(id){
	$.ajax({
		url: "${contextPath}/dorm/dormitory/dormRemovePerson",
		type: "post",
		data: {id:id},
		success: function(res){
			
			if(res == 1){
				layer.msg("成功移除");
				dormPersonRefresh();
				layer.close(ind);
			}else{
				layer.msg("操作失败");
			}
		}
	});
}

//刷新
function dormPersonRefresh(){
	
	$("#dormPerson_table").bootstrapTable("refresh","${contextPath}/dorm/dormitory/getDormPersonList");
}

//加载表格
$("#dormPerson_table").bootstrapTable({
	//sidePagination:  "/cems/quality/getAllQuality.action", //服务端处理分页
	url: '${contextPath}/dorm/dormitory/getDormPersonList',
	queryParamsType:'', 
	search: false,
	clickToSelect: true,//点击行即可选中单选/复选框
	queryParams: queryParams, //参数 
	striped: true,	//使表格带有条纹 
	silent: false,  //刷新事件必须设置  
	pagination: true, //在表格底部显示分页工具栏 
	pageList: [10,20,50,100],
	pageSize:10,
	showColumns: false, //显示隐藏列    
	showRefresh: false,  //显示刷新按钮  
	pageNumber:1,
	idField: "id",  //标识哪个字段为id主键
	sidePagination:'server',//设置为服务器端分页
	columns: [
		{checkbox: true}, 
		{field: 'id', title: 'id'}, 
		{field: 'stuId', title: '状态',searchable:true,formatter:function(value,row,index){
			return value == 0 ? "<span class='label label-error'>空床位</span>" : "<span class='label label-success'>已入住</span>";
		}}, 
		{field: 'stuName', title: '学生姓名'},
		{field: 'stuNo', title: '学号'},
		{field: 'bedId', title: '床位' ,searchable:true},
		{field: 'bedNo', title: '床位编号'},
		{field: 'bedType', title: '床位类型'},
		{title: '操作',field: 'id',align: 'center',
			formatter:function(value,row,index){  
				
				var e = '';  
				
				if(row.stuId == 0){
					e += '<a onclick="addPerson(\''+ row.bedId +'\')">加人</a>';
				}else{
					e += '<a onclick="removePerson(\''+ row.id +'\')">移除</a>';
				}
				return e;  
			} 
		}
	]	
});
</script>
</html>