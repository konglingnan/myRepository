
window.onload = function() {
	var btn = document.getElementById("btn");

	alert("当前的window.location"+window.location);
	
	btn.onclick = function() {
		alert("window.location改变为:'http://www.baidu.com/'");
		window.location = "http://www.baidu.com/";
	}
}