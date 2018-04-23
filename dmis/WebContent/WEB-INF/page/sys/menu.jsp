<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>菜单管理</title>
	
	<link rel="stylesheet" href="${contextPath}/static/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${contextPath}/static/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${contextPath}/static/css/ace.min.css" />
	<link rel="stylesheet" href="${contextPath}/static/jqgrid/ui.jqgrid.css" />
	
	<script src='${contextPath}/static/js/jquery.min.js'></script>
	<script src='${contextPath}/static/js/bootstrap.min.js'></script>
	<script src="${contextPath}/static/jqgrid/grid.locale-cn.js"></script>
	<script src='${contextPath}/static/jqgrid/jquery.jqGrid.min.js'></script>
	
</head>
<body>
	<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
		<table id="user_grid"></table>
		<div id="user_pager"></div>
	</div>
	</div></div>
	
	
	<script type="text/javascript">
		
		$("#user_grid").jqGrid({
	        url: '${contextPath}/sys/menu/getMenuList',
	        datatype: "json",
	        colModel: [			
				{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
				{ label: '菜单名称', name: 'menuName', index: 'menuName', width: 80 }, 			
				{ label: '菜单编号', name: 'menuNo', index: 'menuNo', width: 80 }, 			
				{ label: 'url', name: 'url', index: 'url', width: 80 },			
				{ label: '菜单类型', name: 'type', index: 'type', width: 80 }, 			
				{ label: '上级菜单编号', name: 'fno', index: 'fno', width: 80 }, 			
				{ label: '排序', name: 'menuOrder', index: 'menuOrder', width: 80 }			
	        ],
			viewrecords: true,
	        height: "100%",
	        rowNum: 10,
			rowList : [10,30,50],
	        rownumbers: false, 
	        rownumWidth: 25, 
	        autowidth:true,
	        multiselect: true,
	        pager: "#user_pager",

	        gridComplete:function(){
	        	//隐藏grid底部滚动条
	        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
	        }
	    });
	
	/* 	jQuery("#user_grid")
		.jqGrid(
				'navGrid',
				"#user_pager",
				{ // navbar options
					edit : true,
					editicon : 'ace-icon fa fa-pencil blue',
					add : true,
					addicon : '.glyphicon .glyphicon-plus-sign',
					del : true,
					delicon : 'ace-icon fa fa-trash-o red',
					search : true,
					searchicon : 'ace-icon fa fa-search orange',
					refresh : true,
					refreshicon : 'ace-icon fa fa-refresh blue',
					view : true,
					viewicon : 'ace-icon fa fa-search-plus grey'
				},
				{
					// edit record form
					// closeAfterEdit: true,
					// width: 700,
					recreateForm : true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form
								.closest(
										'.ui-jqdialog')
								.find(
										'.ui-jqdialog-titlebar')
								.wrapInner(
										'<div class="widget-header" />')
						style_edit_form(form);
					},
					errorTextFormat : function(
							response) {
						var result = eval('('
								+ response.responseText
								+ ')');
						return result.message;
					}
				},
				{
					// new record form
					// width: 700,
					closeAfterAdd : true,
					recreateForm : true,
					viewPagerButtons : false,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form
								.closest(
										'.ui-jqdialog')
								.find(
										'.ui-jqdialog-titlebar')
								.wrapInner(
										'<div class="widget-header" />')
						style_edit_form(form);
					},
					errorTextFormat : function(
							response) {
						var result = eval('('
								+ response.responseText
								+ ')');
						return result.message;
					}
				},
				{
					// delete record form
					recreateForm : true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						if (form.data('styled'))
							return false;
						form
								.closest(
										'.ui-jqdialog')
								.find(
										'.ui-jqdialog-titlebar')
								.wrapInner(
										'<div class="widget-header" />')
						style_delete_form(form);
						form.data('styled',
								true);
					},
					onClick : function(e) {
						// alert(1);
					}
				},
				{
					// search form
					recreateForm : true,
					afterShowSearch : function(
							e) {
						var form = $(e[0]);
						form
								.closest(
										'.ui-jqdialog')
								.find(
										'.ui-jqdialog-title')
								.wrap(
										'<div class="widget-header" />')
						style_search_form(form);
					},
					afterRedraw : function() {
						style_search_filters($(this));
					},
					multipleSearch : true
				},
				{
					// view record form
					recreateForm : true,
					beforeShowForm : function(e) {
						var form = $(e[0]);
						form
								.closest(
										'.ui-jqdialog')
								.find(
										'.ui-jqdialog-title')
								.wrap(
										'<div class="widget-header" />')
					}
				})
		
		jQuery("#user_grid")
		.jqGrid(
				'navButtonAdd',
				"#user_pager",
				{
					caption : "",
					title : "导出Excel",
					buttonicon : "ace-icon fa fa-file-excel-o green",
					onClickButton : function() {
						
					}
				}); */
	</script>
</body>
</html>