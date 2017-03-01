var flag = null;
function move(node ,target) {
	// 防止重复开多个定时器
	clearInterval(flag);
	flag = setInterval(function() {
		// 确定速度及运动方向
		var speed = (target-node.offsetTop)/10;
		// 防止最后剩的位置小于1px而不能到达
		if(speed>0){
			speed = Math.ceil(speed);
		} else {
			speed = Math.floor(speed);
		}
		if(node.offsetTop == target){
			clearInterval(flag);
		}else{
			node.style.top = node.offsetTop+speed+"px";
		}
	}, 30);
}

window.onscroll = function() {
	var oDiv = document.getElementById("did");
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	// 谷歌只认识document.body
	var clientHeight = document.body.clientHeight || document.documentElement.clientHeight;
	// 居中算法：（可视高度-元素高度）/2 + 网页被卷去的高度
	var target = parseInt((clientHeight-oDiv.offsetHeight)/2+scrollTop);
	move(oDiv, target);
};
