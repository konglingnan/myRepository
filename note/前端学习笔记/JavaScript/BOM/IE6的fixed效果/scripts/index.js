
// 滚动时
// 改变浏览器窗口大小时
window.onscroll = window.onresize = function() {
	var oDiv = document.getElementById("div1");
	var inputs = document.getElementsByTagName("input");

	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	var clientHeight = document.documentElement.clientHeight;

	oDiv.style.top = scrollTop+clientHeight-oDiv.offsetHeight+"px";

};