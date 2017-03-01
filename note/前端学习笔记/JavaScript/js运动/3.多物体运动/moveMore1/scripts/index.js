function move(node ,target) {
	clearInterval(node.flag);
	node.flag = setInterval(function() {
		var speed = (target-node.offsetWidth)/10;
		if(speed>0){
			speed = Math.ceil(speed);
		} else {
			speed = Math.floor(speed);
		}
		if(node.offsetWidth == target){
			clearInterval(node.flag);
		}else{
			node.style.width = node.offsetWidth+speed+"px";
		}
	}, 30);
}

window.onload = function() {
	var divs = document.getElementsByTagName("div");
	for(var i=0; i<divs.length; i++){
		divs[i].onmouseover = function() {
			move(this, 300);
		}
		divs[i].onmouseout = function() {
			move(this, 100);
		}
	}
};
