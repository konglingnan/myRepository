
// 获取event事件的x, y
function getPos(even) {
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	var scrollLeft = document.documentElement.scrollLeft || document.body.scrollLeft;
	return {x:even.clientX+scrollLeft, y:even.clientY+scrollTop};
}

// 鼠标移动，小点跟着动
document.onmousemove = function(ev) {
	// 兼容
	var oEvent = ev || event;

	// 让后一个小点的top和left跟前一个一样
	var divs = document.getElementsByTagName("div");
	for(var i=divs.length-1; i>0; i--) {
		divs[i].style.top = divs[i-1].offsetTop+"px";
		divs[i].style.left = divs[i-1].offsetLeft+"px";
	}
	
	// 获取x,y的json
	var pos = getPos(oEvent);
	
	// 第一个小点和鼠标移动的一样
	divs[0].style.top = pos.y+"px";
	divs[0].style.left = pos.x+"px";

}