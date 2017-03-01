
var flag = null;
function move(target) {
	clearInterval(flag);
	var oDiv = document.getElementById("did");
	flag = setInterval(function() {
		var speed;
		if(target>oDiv.offsetLeft){
			speed = 10;
		}else {
			speed = -10;
		}
		if(oDiv.offsetLeft == target){
			clearInterval(flag);
		}else{
			oDiv.style.left = oDiv.offsetLeft+speed+"px";
		}
	}, 30);
}

window.onload = function() {
	document.getElementById("did").addEventListener("mouseover", function(){move(0)});
	document.getElementById("did").addEventListener("mouseout", function(){move(-100)});
}
