$(function(){
	$.ajax({
		url: '/dmis/sys/menu/getLeftMenus',
		type: 'post',
		dataType: 'json',
		async: false,
		success: function(res){
			
			var str = ""
			for(var i = 0 ; i < res.length ;i++){
				str += '<li> <a href="'+res[i].url+'"><i class="fa-desktop"></i> <span class="nav-label">'+res[i].menuName+' </span><span class="fa arrow"></span></a>';
				if(res[i].children.length != 0){
					str += '<ul class="nav nav-second-level">';
					for(var j = 0 ; j< res[i].children.length ; j++ ){
						str +=  '<li><a class="J_menuItem" href="'+res[i].children[j].url+'">'+res[i].children[j].menuName+'</a></li>';
					}
					str += '</ul></li>'
				} else {
					str += '</li>'
				}
			}
			$("#side-menu").append(str);
		}
	}).responseText;
});


