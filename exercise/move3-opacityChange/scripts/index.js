
// 使全局变量alpha与css中的opacity同步
var alpha =100;
var flag = null;
function move(target) {
	clearInterval(flag);
	var oDiv = document.getElementById("iid");
	flag = setInterval(function() {
		var speed;
		if(target>alpha){
			speed = 10;
		}else {
			speed = -10;
		}
		if(alpha == target){
			clearInterval(flag);
		}else{
			alpha += speed;
			oDiv.style.opacity = alpha/100;
			oDiv.style.filter = "alpha(opacity:"+alpha+")";
		}
	}, 30);
}

window.onload = function() {
	document.getElementById("did").addEventListener("mouseout", function(){move(100)});
	document.getElementById("did").addEventListener("mouseover", function(){move(50)});
}
