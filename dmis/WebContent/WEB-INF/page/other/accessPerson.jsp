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
	<%-- <script src="${contextPath}/static/js/bootstrap-dialog.min.js"></script> --%>

	

</head>
<body>
	<div id="dormitory_search" style="margin: 5px 0px">
		
		<button onclick="addDormitoryClick()">新增</button>
		<button onclick="editDormitoryClick('edit')">修改</button>
		<button onclick="delDormitoryClick()">删除</button>
		<button onclick="editDormitoryClick('view')">查看</button>
		
		
		
		<button onclick="dormitorySearchBtn()">搜索</button>
	</div>
	<table id="accessPerson_table"></table>

</body>
<script type="text/javascript">
	
	
	
	//新增
	function addDormitoryClick(){
		
		layer.open({
			type: 2,
			title: '新增',
			shadeClose: true,
			shade: 0.5,
			closeBtn: 1,
			//maxmin: true, //开启最大化最小化按钮
			area: ['600px', '400px'],
			content: '${contextPath}/other/access/toAccessPersonForm'
		});
	}
	
	
	//编辑
	function editDormitoryClick(oper){
		
		var ids = $("#accessPerson_table").bootstrapTable("getSelections");
		
		var titleName = oper == "edit" ? "编辑" : "查看";
		
		if(ids.length == 1){
			
			layer.open({
				type: 2,
				title: titleName,
				shadeClose: true,
				shade: 0.5,
				closeBtn: 1,
				//maxmin: true, //开启最大化最小化按钮
				area: ['600px', '400px'],
				content: '${contextPath}/other/access/toAccessPersonForm?oper='+ oper +'&id='+ ids[0].id
			});
		}else{
			
			layer.msg("请选择一条数据");
		}
	}
	
	
	//删除
	function delDormitoryClick(){
		var selects = $("#accessPerson_table").bootstrapTable("getSelections");
		
		if(selects.length > 0){
			
			//询问框
			layer.confirm('是否删除数据？', {
				btn: ['确定','取消'] //按钮
			}, function(){
				var ids = "";
				
				for(var i in selects){
					
					ids += selects[i].id + ",";
				}
				
				//删除请求
				$.ajax({
					url: "${contextPath}/dorm/dormitory/delDorm",
					type: "post",
					data: {oper:'del', ids:ids},
					success: function(res){
						
						if(res != 0){
							
							layer.msg("删除成功");
							dormitorySearchBtn();
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
	function dormitorySearchBtn(){
		
		$("#accessPerson_table").bootstrapTable("refresh","${contextPath}/other/access/getAccessPersons");
	}
	
	

	function queryParams(params) {  //bootstrapTable自带参数 
		
		var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的  
			pageSize: params.pageSize,   //页面大小  
			pageNumber: params.pageNumber,  //页码  
			
			sort: params.sort,  //排序列名  
			sortOrder: params.order//排位命令（desc，asc）  
		};  
		
		return temp;  
	}  
	
	
	Date.prototype.Format = function (fmt) { //author: meizz
		  var o = {
		    "M+": this.getMonth() + 1, //月份
		    "d+": this.getDate(), //日
		    "h+": this.getHours(), //小时
		    "m+": this.getMinutes(), //分
		    "s+": this.getSeconds(), //秒
		    "q+": Math.floor((this.getMonth() + 3) / 3), 
		    "S": this.getMilliseconds() //毫秒 
		  };
		  if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		  for (var k in o)
		  if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		  return fmt;
	}
	
	//修改——转换日期格式(时间戳转换为datetime格式)  
	function dateFormat(value,row,index) {  
		
		if(value == null) return "";
		
		var year = (Number(value.year) + 1900);
		
		var month = (value.month + 1);
		
		var day = value.date; 
		
		var hours = value.hours;
		
		var minutes = value.minutes;
		
		var seconds = value.seconds;
			
		//return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
		return new Date(value.time).Format("yyyy-MM-dd hh:mm:ss");
	}
	
		 
	$("#accessPerson_table").bootstrapTable({
		//sidePagination:  "/cems/quality/getAllQuality.action", //服务端处理分页
		url: '${contextPath}/other/access/getAccessPersons',
		queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                   // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
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
			{field: 'personName', title: '来访人姓名',searchable:true}, 
			{field: 'phone', title: '电话' ,searchable:true},
			{field: 'objective', title: '目的'},
			{field: 'personSum', title: '人数'},
			{field: 'accessTime', title: '访问时间',formatter: dateFormat},
			{field: 'leaveTime', title: '离开时间',formatter: dateFormat},
			
		]	
	});
			


			
</script>
</html>