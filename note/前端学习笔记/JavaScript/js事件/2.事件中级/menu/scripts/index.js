
// 阻止菜单默认行为，显示自定义菜单
document.oncontextmenu = function(eve) {

	var oEvent = eve || event;

	var oDiv = document.getElementsByTagName("div")[0];


	oDiv.style.left = oEvent.clientX+"px";
	oDiv.style.top = oEvent.clientY+"px";
	oDiv.style.display = "block";

	return false;
}

// 隐藏自定义菜单
document.onclick = function() {
	var oDiv = document.getElementsByTagName("div")[0];
	oDiv.style.display = "none";
}