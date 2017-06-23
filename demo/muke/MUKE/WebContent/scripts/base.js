$(document).ready(function(){
	loginBtn();
	signinBtn();
	logoutBtn();
	login();
	register();
	setUserName();
	getCourseInfo();
});

// 登录start
function loginBtn() {
	$("#login #main").click(function(e) {
		window.event?window.event.cancelBubble=true : e.stopPropagation();
	});
	$(".loginBtn").click(function() {
		$("#login").fadeIn();
	});
	$("#login").click(function() {
		$("#login").fadeOut();
	});
}
// 登录end

// 注册start
function signinBtn() {
	$("#signin #main").click(function(e) {
		window.event?window.event.cancelBubble=true : e.stopPropagation();
	});
	$(".signinBtn").click(function() {
		$("#signin").fadeIn();
	});
	$("#signin").click(function() {
		$("#signin").fadeOut();
	});
}
// 注册end

// 注销start
function logoutBtn() {
	$(".logoutBtn").click(function() {
		sessionStorage.setItem("username", "null");

		$(".username").text("");
		$(".loginBtn").show();
		$(".signinBtn").show();
		$(".logoutBtn").hide();
	});
}
// 注销end

//登录验证start
function login() {
	$("#loginBtn").click(function() {
		var uname = $("#uname").val();
		var upwd = $("#upwd").val();

		$.post("login.action", {
			uname: uname,
			upwd: upwd
		},
		function(data, status){
			if(data=="") {
				alert("登录失败！");
			}else {
				sessionStorage.setItem("username", data);
				setUserName();
				$("#login").hide();
			}
		});
	});
}
//登录验证end

// 注册验证start
function register() {
	$("#register").click(function() {
		var rtel = $("#rtel").val();
		var rname = $("#rname").val();
		var rpwd = $("#rpwd").val();
		$.post("register.action", {
			rtel: rtel,
			rname: rname,
			rpwd: rpwd
		},
		function(data, status){
			if(data=="true"){
				alert("注册成功！");
				location.reload();
			}else {
				alert("该账户已被占用！");
			}
		});
	});
}
// 注册验证end

// 设置用户名start
function setUserName() {
	// 设置sessionStorage
	var username = sessionStorage.getItem("username");
	if(username!="" && username!="null" && username!=null) {
		$(".username").text(username);
		$(".loginBtn").hide();
		$(".signinBtn").hide();
		$(".logoutBtn").show();
	}else{
		$(".username").text("");
		$(".loginBtn").show();
		$(".signinBtn").show();
		$(".logoutBtn").hide();
	}
}
// 设置用户名end

// 获取课程数据start
function getCourseInfo() {
	$(".dir li").click(function() {
		var first = $(".first .current").find("a").text();
		var second = $(".second .current").find("a").text();
		var third = $(".third .current").find("a").text();
		$.post("queryCourse.action",
			{
				course_direction: first,
				course_classification: second,
				course_rank: third
			}, function(data){
				var str = "";
				$.each(JSON.parse(data), function(i, item){
					str += "<li>"+
						"<div>"+item.course_studyTime+" | "+ item.course_rank +"</div>"+
						"<a href='javascript:void(0);'><img src='imgs/courses/"+item.course_id+".jpg' />"+
							"<h3>"+item.course_name+"</h3>"+
							"<p>"+item.course_description+"</p>"+
							"<span>"+item.course_progress+"</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>"+item.course_studyNum+"人在学习</span>"+
						"</a>"+
					"</li>";
				});
				$(".courses ul").html(str);
			});
	});
}
// 获取课程数据end
