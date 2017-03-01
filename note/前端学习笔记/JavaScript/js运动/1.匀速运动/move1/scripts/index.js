
var flag = null;
function move(target) {
	// 防止重复开多个定时器
	clearInterval(flag);
	var oDiv = document.getElementById("did");
	flag = setInterval(function() {
		// 确定速度
		var speed = 7;
		// 速度不能使器刚好到达终点时，防止物体在终点左右来回抖动，贴近即关
		if(Math.abs(target-oDiv.offsetLeft)<7){
			clearInterval(flag);
			// 定位到终点
			oDiv.style.left = target+"px";
		}else{
			// 移动
			oDiv.style.left = oDiv.offsetLeft+speed+"px";
		}
	}, 30);
}

window.onload = function() {
	document.getElementById("move").addEventListener("click", function(){move(300)});
}
