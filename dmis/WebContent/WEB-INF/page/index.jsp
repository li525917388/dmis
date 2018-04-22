<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>CEMS - 登录</title>
    <script src="static/hplus/js/table/jquery-3.1.1.min.js"></script>
    <link href="static/hplus/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="static/hplus/css/animate.min.css" rel="stylesheet">
    <link href="static/hplus/css/style.min.css" rel="stylesheet">
    <link href="static/hplus/css/login.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ CEMS ]</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>学生成绩评价系统</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-5">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到  CEMS</p>
                    <input type="text" id="username"  class="form-control uname" placeholder="用户名" />
                    <input type="password" id="password" class="form-control pword m-b" placeholder="密码" />
                   	<label>
                    <input type="radio" checked="" value="1" id="role" name="role">学生</label>
                   	<label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" checked="" value="2" id="role" name="role">教工</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" checked="" value="4" id="role" name="role">班级管理</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" checked="" value="3" id="role" name="role">管理员</label>
                    <!-- <a href="#">忘记密码了？</a> -->
                    <button id="login_btn" class="btn btn-success btn-block">登录</button>
               
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2016 All Rights Reserved. CEMS
            </div>
        </div>
    </div>
     <script>
           $("#login_btn").click(function(){
           
           var username = $("#username").val() ;
           var password = $("#password").val() ;
           var role = $('input:radio:checked').val() ;
           		$.ajax({
           			url: "/cems/login/dologin.action",
           			type :'post',
           			//async: false,
           			data :{
           			username:username,
           			password:password,
           			role:role	
           			},
           			dataType: 'json',
           			success : function(res){
           				if(res != null){
           					top.location= "/cems/main/index.jsp"; 
           				}else {
							alert("用户名或密码有误");   
           				}}
           				})
           				});
      </script>
</body>
</html>