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
	<div id="user_search" style="margin: 5px 0px">
		
		<button onclick="addClick()">新增</button>
		<button onclick="editClick('edit')">修改</button>
		<button onclick="delClick()">删除</button>
		<button onclick="editClick('view')">查看</button>

		<button onclick="searchBtn()">搜索</button>
	</div>
	<table id="user_table"></table>

</body>
<script type="text/javascript">
	//新增
	function addClick(){
		
		layer.open({
			type: 2,
			title: '新增',
			shadeClose: true,
			shade: 0.5,
			closeBtn: 1,
			//maxmin: true, //开启最大化最小化按钮
			area: ['600px', '400px'],
			content: '${contextPath}/sys/user/toUserForm'
		});
	}	
	
	
	//编辑
	function editClick(oper){
		
		var rows = $("#user_table").bootstrapTable("getSelections");
		
		if(rows.length == 1){
			
			layer.open({
				type: 2,
				title: '新增',
				shadeClose: true,
				shade: 0.5,
				closeBtn: 1,
				//maxmin: true, //开启最大化最小化按钮
				area: ['600px', '400px'],
				content: '${contextPath}/sys/user/toUserForm?oper='+ oper + "&id=" + rows[0].id
			});
		}else{
			
			layer.msg("请选择一条数据");
		}
		
	}
	
	
	//删除
	function delClick(){
		var selects = $("#user_table").bootstrapTable("getSelections");
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
					url: "${contextPath}/sys/user/delUser",
					type: "post",
					data: {oper:'del', ids:ids},
					success: function(res){
						if(res != 0){
							parent.layer.msg("删除成功");
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
		$("#user_table").bootstrapTable("refresh","${contextPath}/sys/user/getUsers");
	}
	
	
	//打开授权菜单
	function openUserMenu(uid){
		parent.layer.open({
			type: 2,
			title: '新增',
			shadeClose: true,
			shade: 0.4,
			closeBtn: 1,
			maxmin: true, //开启最大化最小化按钮
			area: ['400px', '500px'],
			content: '${contextPath}/sys/role/toUserRole?uid='+ uid
		});
	}
		
	$(function(){
			 
		$("#user_table").bootstrapTable({
				//sidePagination:  "/cems/quality/getAllQuality.action", //服务端处理分页
   			url: '${contextPath}/sys/user/getUsers',
   			queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                    // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber

   			clickToSelect: true,//点击行即可选中单选/复选框
 			striped: true,
			pagination: true,
			pageList: [10,20,50,100],
            pageSize:10,
            pageNumber:1,
            sidePagination:'server',//设置为服务器端分页
   			columns: [
   				{checkbox: true}, 
   				{field: 'id', title: 'id'}, 
       			{field: 'username', title: '用户名'}, 
    			{field: 'name', title: '姓名' },
    			{field: 'sex', title: '性别',formatter:function(value,row,index){
					return value==1 ? '<span class="label label-success">男</span>' : '<span class="label label-warning">女</span>';
				}},
    			{field: 'classId', title: '班级'}, 
    			{field: 'headIcon', title: '头像' },
    			{
	                title: '操作',
	                field: 'id',
	                align: 'center',
	                formatter:function(value,row,index){  
                   		var e = '<a onclick="openUserMenu(\''+ row.id +'\')">授权</a> ';  
                  	 	var d = '<a onclick="deletes(\''+ row.id +'\')">删除</a> ';  
                   		var d = '<a onclick="addCourse(\''+ row.id +'\')">添加</a> ';  
                        return e;  
                 	} 
            	}
    		]	
		});
			
	});

			
</script>
</html>