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
	
	<script src="${contextPath}/static/hplus/js/table/jquery-3.1.1.min.js"></script>
	<script src="${contextPath}/static/layer/layer.js"></script>
	<script src="${contextPath}/static/hplus/js/table/bootstrap.min.js"></script>
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
</style>
</head>
<body>
	
	<input id="id" type="hidden" value="${menu.id }"/>
	<input id="oper" type="hidden" value="${oper }"/>
	<table id="dataTable">
		
		<tr>
			<td>菜单名称：</td>
			<td><input id="menuName" value="${menu.menuName }"></td>
			<td>菜单编码：</td>
			<td><input id="menuNo" value="${menu.menuNo }"></td>
		</tr>
		
		<tr>
			<td>菜单类型：</td>
			<td><input id="type" value="${menu.type }"></td>
			
			<td>菜单样式：</td>
			<td><input id="icon" value="${menu.icon }"></td>
		</tr>
		
		<tr>
			<td>url：</td>
			<td><input id="url" value="${menu.url }"></td>
			
			<td>上级菜单：</td>
			<td><input id="fno" value="${menu.fno }"></td>
		</tr>
		
		<tr>
			<td>顺序：</td>
			<td><input id="menuOrder" value="${menu.menuOrder }"></td>
			
			
		</tr>
		
		
		<c:if test="${oper != 'view' }">
		<tr>
			<td></td>
			<td colspan="3"><button onclick="saveClick()">保存</button></td>
		</tr>
		</c:if>
		
	</table>
</body>

<script type="text/javascript">
var oper = $("#oper").val();
if(oper == "view" || oper == "edit"){
	
	if(oper == "view"){
		$("input").attr("readonly","readonly");
		
	}
}


//保存
function saveClick(){
	
	$.ajax({
		url: "${contextPath}/sys/menu/saveMenu",
		type: "post",
		data: {
			id: $("#id").val(),
			menuName: $("#menuName").val(),
			menuNo: $("#menuNo").val(),
			url: $("#url").val(),
			icon: $("#icon").val(),
			fno: $("#fno").val(),
			type: $("#type").val(),
			menuOrder: $("#menuOrder").val()
		},
		success: function(res){
			
			if(res == 1){
				layer.msg("操作成功");
				window.parent.searchBtn();
				setTimeout(function(){
					closeClick();
				},1200);
			}else{
				layer.msg("操作失败");
			}
		}
	});
}

function closeClick(){

	parent.layer.closeAll()
}
</script>
</html>