<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="${contextPath}/static/css/bootstrap.min.css">
	<link rel="stylesheet" href="${contextPath}/static/layer/mobile/need/layer.css">
	
	<script src="${contextPath}/static/hplus/js/table/jquery-3.1.1.min.js"></script>
	<script src="/dmis/static/hplus/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${contextPath}/static/layer/layer.js"></script>
</head>
<body>
	<form id="dormitoryForm" class="form-horizontal" role="form">
		<input id="dormitoryId" type="hidden" value="${dormitory.id }">
		<input id="oper" type="hidden" value="${oper }">
		
		<div class="form-group">
		  	<label class="col-sm-3 control-label">楼宇</label>
		  	<div class="col-sm-8">
	    		<select id="buildId" class="form-control">
	        		
	      		</select>
	      		<input type="hidden" id="buildIdHid" value="${dormitory.buildId }">
	  		</div>
		</div>
		
		<div class="form-group">
			<label for="dormNo" class="col-sm-3 control-label">宿舍号</label>
		  	<div class="col-sm-8">
		    	<input class="form-control" id="dormNo" type="text" value="${dormitory.dormNo }" placeholder="如：620" >
		  	</div>
		</div>
		
		<div class="form-group">
		    <label for="maxNum" class="col-sm-3 control-label">宿舍类别</label>
		    <div class="col-sm-8">
		      	<select id="dormType" class="form-control">
	        		
	      		</select>
	      		<input type="hidden" id="dormTypeHid" value="${dormitory.dormType }">
		    </div>
		</div>
		<div class="form-group">
		    <label for="dormSex" class="col-sm-3 control-label">性别</label>
		    <div class="col-sm-8">
		      	<select id="dormSex" class="form-control">
		        	<option value="1">男宿</option>
		        	<option value="2">女宿</option>
		        
		      	</select>
		      	<input type="hidden" id="dormSexHid" value="${dormitory.dormSex }">
		    </div>
		</div>
		
		
		<div class="form-group has-error">
			<label class="col-sm-3 control-label" for="inputError"></label>
			<div class="col-sm-8">
				<c:if test="${oper != 'view' }">
					<button type="button" onclick="submitClick()" class="btn btn-success">提交</button>
				</c:if>
				<button type="button" onclick="closeClick()" class="btn btn-default">取消</button>
			</div>
		  
		</div>
		
		
	</form>
</body>

<script type="text/javascript">
$.ajax({
	url: "${contextPath}/dorm/building/getAllList",
	type: "get",
	dataType: "json",
	async: false,
	success: function(res){
		var html = "";
		
		for(var i in res){
			
			html += "<option value='"+ res[i].id +"'>" + res[i].name + "</option>";
		}
		
		$("#buildId").html(html);
	}
});

//加载宿舍类型
$.ajax({
	url: "${contextPath}/dorm/bed/getDormTypeList",
	type: "get",
	dataType: "json",
	async: false,
	success: function(res){
		var html = "<option value=''>全部</option>";
		
		for(var i in res){
			
			html += "<option value='"+ res[i].id +"'>" + res[i].dormTypeName + "</option>";
		}
		
		$("#dormType").html(html);
	}
});


//初始化
var oper = $("#oper").val();
if(oper == "view" || oper == "edit"){
	
	$("#buildId").val($("#buildIdHid").val());
	$("#dormSex").val($("#dormSexHid").val());
	$("#dormType").val($("#dormTypeHid").val());
	
	if(oper == "view"){
		$("input").attr("disabled","disabled");
		$("select").attr("disabled","disabled");
	}
}

//提交
function submitClick(){
	$.ajax({
		url: "${contextPath}/dorm/dormitory/saveDorm",
		type: "post",
		data: {
			buildId: $("#buildId").val(),
			dormNo: $("#dormNo").val(),
			dormType: $("#dormType").val(),
			dormSex: $("#dormSex").val(),
			id: $("#dormitoryId").val()
		},
		success: function(res){
			
			if(res != 0){
				
				layer.msg("操作成功");
				parent.$("#dormitory_table").bootstrapTable("refresh","${contextPath}/dorm/dormitory/getDormitoryList");
				setTimeout(function(){
					closeClick();
				},1200);
				
			}
		}
	});
}


function closeClick(){

	parent.layer.closeAll()
}
</script>
</html>