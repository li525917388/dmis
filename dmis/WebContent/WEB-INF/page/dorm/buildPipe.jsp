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
	
	
	<style type="text/css">
	#dataTable{
		border: 1px #aaa solid;
		width: 96%; 
		border-collapse:collapse;
		margin: 2%;;
	}
	
	#dataTable td{
		border: 1px #aaa solid;
		margin: 0px;
		
	}
	
	#dataTable td:nth-child(odd) {  
        background: #fafafa; 
        text-align: right; 
        padding: 3px;
    }  
    
	#dataTable input{
		width: 200px;
	}
	
	.input_div{
		width: 150px;
	}
</style>
</head>
<body>
	
	<input id="buildId" type="hidden" value="${building.id }">
	<table id="dataTable">
		
		<tr>
			<td>楼宇名称：</td>
			<td><div class="input_div">${building.name }</div></td>
			<td>类型：</td>
			<td><div class="input_div">${building.type }</div></td>
		</tr>
		
		
		
	</table>

	<div id="role_search" style="margin: 5px 0px">
		
		<button onclick="addClick()">新增</button>
		<button onclick="delClick()">删除</button>

		<button onclick="searchBtn()">刷新</button>
	</div>
	<table id="role_table"></table>


	<!-- 弹出框 -->
	<div id="buildPipeForm" style="display: none;">
		<table id="dataTable1">
		
		<tr>
			<td>用户id：</td>
			<td><input id="userId" /></td>
		</tr>
		
		
		
		</table>
	</div>
</body>
<script type="text/javascript">
	//新增
	function addClick(){
		$("#userId").val("");
		
		layer.open({
			type: 1,
			title: '新增',
			shadeClose: true,
			shade: 0.5,
			closeBtn: 1,
			btn: ["确定","取消"],
			yes: function(ind){
				var uid = $("#userId").val();
				var buildId = $("#buildId").val();
				
				$.ajax({
					url: "${contextPath}/dorm/building/addBuildPipe",
					type: "post",
					data: {uid: uid, buildId: buildId},
					success: function(res){
						if(res == 1){
							layer.msg("操作成功");
							
							searchBtn();
							
							layer.close(ind);
						}else{
							layer.msg("操作失败");
						}
					}
				});
			},
			area: ['300px', '150px'],
			content: $("#buildPipeForm")
		});
	}	
	
	
	
	
	//删除
	function delClick(){
		var selects = $("#role_table").bootstrapTable("getSelections");
		if(selects.length > 0){
			//询问框
			layer.confirm('是否删除数据？', {
				btn: ['确定','取消'] //按钮
			}, function(ind){
				var ids = "";
				for(var i in selects){
					ids += selects[i].id + ",";
				}
				
				//删除请求
				$.ajax({
					url: "${contextPath}/dorm/building/delBuildPipe",
					type: "post",
					data: {oper:'del', ids:ids},
					success: function(res){
						if(res != 0){
							layer.msg("删除成功");
							searchBtn();
							layer.close(ind);
						}else{
							layer.msg("删除失败");
						}
					}
				});
			}, function(){
				
			});
	
		}else{
			layer.msg("至少选择一条数据");
		}
	}
	
	//刷新
	function searchBtn(){
		$("#role_table").bootstrapTable("refresh","${contextPath}/dorm/building/getBuildPipes");
	}
	
	
	function queryParams(params) {  //bootstrapTable自带参数 
		
		var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的  
			pageSize: params.pageSize,   //页面大小  
			pageNumber: params.pageNumber,  //页码  
			buildId: $("#buildId").val(),
			sort: params.sort,  //排序列名  
			sortOrder: params.order//排位命令（desc，asc）  
		};  
		
		return temp;  
	}
	
		
	$(function(){
			 
		$("#role_table").bootstrapTable({
				//sidePagination:  "/cems/quality/getAllQuality.action", //服务端处理分页
   			url: '${contextPath}/dorm/building/getBuildPipes',
   			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                    // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: queryParams, //参数
   			clickToSelect: true,//点击行即可选中单选/复选框
 			striped: true,
			pagination: true,
			pageList: [10,20,50,100],
            pageSize:10,
            pageNumber:1,
            sidePagination:'server',//设置为服务器端分页
   			columns: [
   				{checkbox: true}, 
   				{field: 'id', title: '主键'}, 
       			{field: 'username', title: '用户名'}, 
    			{field: 'name', title: '姓名' },
    			{field: 'sex', title: '性别',formatter:function(value,row,index){
    				return value == 1 ? "男" : "女";
    			}},
    			
    		]	
		});
			
	});

			
</script>
</html>