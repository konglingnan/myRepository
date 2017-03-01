
function move(node ,target) {
	var flag = setInterval(function() {
		var speed = (target-node.offsetLeft)/7;
		if(speed>0){
			// 防止最后剩的位置小于1px而不能到达
			speed = Math.ceil(speed);
		} else {
			speed = Math.floor(speed);
		}
		if(node.offsetLeft == target){
			clearInterval(flag);
		}else{
			node.style.left = node.offsetLeft+speed+"px";
		}
	}, 30);
}

window.onload = function() {
	var oDiv = document.getElementById("did");
	var oDiv2 = document.getElementById("did2");
	document.getElementById("go").addEventListener("click", function(){move(oDiv, 500)});
	document.getElementById("go").addEventListener("click", function(){move(oDiv2, 500)});
}
