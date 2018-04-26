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
	
	<input id="id" type="hidden" value="${accessPerson.id }"/>
	<input id="oper" type="hidden" value="${oper }"/>
	<table id="accessPersonTable">
		
		<tr>
			<th colspan="4" style="font-size: 20px;height: 35px;">来访人员登记表</th>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input id="personName" value="${accessPerson.personName }"></td>
			<td>电话：</td>
			<td><input id="phone" value="${accessPerson.phone }"></td>
		</tr>
		
		<tr>
			<td>来访目的：</td>
			<td colspan="3"><input id="objective" style="width: 450px;" value="${accessPerson.objective }"></td>
		</tr>
		
		<tr>
			<td>人数：</td>
			<td><input id="personSum" value="${accessPerson.personSum }"></td>
			<td>来访时间：</td>
			<td><input id="accessTime" value="${accessPerson.accessTimeCn }"></td>
		</tr>
		
		<tr>
			<td>离开时间：</td>
			<td><input id="leaveTime" value="${accessPerson.leaveTimeCn }"></td>
			<td></td>
			<td></td>
		</tr>
		
		<c:if test="${oper != 'view' }">
		<tr>
			<td></td>
			<td colspan="3"><button onclick="saveAccessPerson()">保存</button></td>
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
function saveAccessPerson(){
	
	$.ajax({
		url: "${contextPath}/other/access/saveAccessPerson",
		type: "post",
		data: {
			id: $("#id").val(),
			personName: $("#personName").val(),
			phone: $("#phone").val(),
			objective: $("#objective").val(),
			personSum: $("#personSum").val(),
			accessTimeCn: $("#accessTime").val(),
			leaveTimeCn: $("#leaveTime").val()
		},
		success: function(res){
			
			if(res == 1){
				layer.msg("操作成功");
				window.parent.dormitorySearchBtn();
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