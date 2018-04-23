<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>

	<!-- page specific plugin styles -->
	<link rel="stylesheet" href="${contextPath}/static/jqgrid/ui.jqgrid-bootstrap.css" />
	<link rel="stylesheet" href="${contextPath}/static/css/bootstrap.min.css" />

	<script src='${contextPath}/static/js/jquery.min.js'></script>
	<script src='${contextPath}/static/js/bootstrap.min.js'></script>
	<script src='${contextPath}/static/jqgrid/jquery.jqGrid.min.js'></script>
	<script src="${contextPath}/static/jqgrid/grid.locale-cn.js"></script>
	
</head>
<body>
	<div >
		
		<table id="user_grid"></table>
		<div id="user_pager"></div>
	</div>
	
	
	<script type="text/javascript">
		
		$("#user_grid").jqGrid({
	        url: '${contextPath}/sys/user/getUserList',
	        datatype: "json",
	        colModel: [			
				{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
				{ label: '编码名称', name: 'codename', index: 'codeName', width: 80 }, 			
				{ label: '编号', name: 'codeno', index: 'codeNo', width: 80 }, 			
				/*{ label: '', name: 'codestr', index: 'codeStr', width: 80 },*/ 			
				{ label: '描述', name: 'summary', index: 'summary', width: 80 }, 			
				{ label: '标记', name: 'flag', index: 'flag', width: 80 }, 			
				{ label: '码段长度', name: 'codelength', index: 'codeLength', width: 80 }			
	        ],
			viewrecords: true,
	        height: "100%",
	        rowNum: 10,
			rowList : [10,30,50],
	        rownumbers: true, 
	        rownumWidth: 25, 
	        autowidth:true,
	        multiselect: true,
	        pager: "#user_pager",
	        jsonReader : {
	            root: "page.list",
	            page: "page.currPage",
	            total: "page.totalPage",
	            records: "page.totalCount"
	        },
	        prmNames : {
	            page:"page", 
	            rows:"limit", 
	            order: "order"
	        },
	        gridComplete:function(){
	        	//隐藏grid底部滚动条
	        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
	        }
	    });
	
	</script>
</body>
</html>