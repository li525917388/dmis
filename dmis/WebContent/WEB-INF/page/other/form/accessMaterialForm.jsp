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
	#accessPersonTable{
		border: 1px #333 solid;
		width: 96%; 
		border-collapse:collapse;
		margin: 2%;;
	}
	
	#accessPersonTable td{
		border: 1px #333 solid;
		margin: 0px;
		
	}
	
	#accessPersonTable td:nth-child(odd) {  
        background: #eee; 
        text-align: right; 
        padding: 3px;
    }  
    
	#accessPersonTable input{
		border:0px;
		outline: none;
	}
</style>
</head>
<body>
	
	<input id="id" type="hidden" value="${accessMaterial.id }"/>
	<input id="oper" type="hidden" value="${oper }"/>
	<table id="accessPersonTable">
		
		<tr>
			<th colspan="4" style="font-size: 20px;height: 35px;">物品出入登记表</th>
		</tr>
		<tr>
			<td>物品名称：</td>
			<td><input id="matName" value="${accessMaterial.matName }"></td>
			<td>物品类型：</td>
			<td><input id="matType" value="${accessMaterial.matType }"></td>
		</tr>
		
		<tr>
			<td>数量：</td>
			<td><input id="matNum" value="${accessMaterial.matNum }"></td>
			
			<td>单位：</td>
			<td><input id="unit" value="${accessMaterial.unit }"></td>
		</tr>
		
		<tr>
			<td>进出：</td>
			<td><input id="accessType" value="${accessMaterial.accessType }"></td>
			
			<td>时间：</td>
			<td><input id="nowTimeCn" value="${accessMaterial.nowTimeCn }"></td>
		</tr>
		
		
		<c:if test="${oper != 'view' }">
		<tr>
			<td></td>
			<td colspan="3"><button onclick="saveAccessMaterial()">保存</button></td>
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
function saveAccessMaterial(){
	
	$.ajax({
		url: "${contextPath}/other/access/saveAccessMaterial",
		type: "post",
		data: {
			id: $("#id").val(),
			matName: $("#matName").val(),
			matType: $("#matType").val(),
			matNum: $("#matNum").val(),
			unit: $("#unit").val(),
			nowTimeCn: $("#nowTimeCn").val(),
			accessType: $("#accessType").val()
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