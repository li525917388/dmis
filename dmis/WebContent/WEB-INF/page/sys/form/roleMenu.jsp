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
	<link rel="stylesheet" href="${contextPath}/static/css/zTreeStyle/zTreeStyle.css">
	
	
	<script src="${contextPath}/static/hplus/js/table/jquery-3.1.1.min.js"></script>
	<script src="${contextPath}/static/layer/layer.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap.min.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap-table-zh-CN.js"></script>
	<script src="${contextPath}/static/js/jquery.ztree.core.js"></script>
	<script src="${contextPath}/static/js/jquery.ztree.excheck.js"></script>
</head>
<body>
	<input id="roleId" value="${roleId }" type="hidden" autocomplete="off">
	<div>
		<ul id="treeDemo" class="ztree" style=""></ul>
	</div>
	
	<button style="margin: 10px;" onclick="saveRoleMenu()">保存</button>
</body>

<script type="text/javascript">
$(function(){
	var setting = {
		check: {
			enable: true,
			chkDisabledInherit: true
		},
		data: {
			key: {
				name: "menuName",
				title:"id",
				url:"id"
			},
			simpleData: {
				enable: true,
				idKey: "menuNo",
				pIdKey: "fno"
				
			}
		}
	};
		
	$.ajax({
		url: "${contextPath}/sys/role/getMenuTree",
		type: "post",
		data: {rid:$("#roleId").val()},
		//dataType: "json",
		success: function(res){
			
			$(document).ready(function(){
				$.fn.zTree.init($("#treeDemo"), setting, eval(res));		
			});
				
		}
	});
});

function saveRoleMenu () {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	nodes = zTree.getCheckedNodes(true);
//	alert(nodes.length);
	var mids = "" ;
	for(var i in nodes){
		mids += nodes[i].id + "," ;
	}
	
	$.ajax({
		url: "${contextPath}/sys/role/saveRoleMenu",
		data: {mids : mids,rid : $("#roleId").val()},
		type: "post",
		success: function(res) {
			parent.layer.closeAll() ;

			parent.layer.msg("操作成功");
		}
	});
}
</script>
</html>