
// 键盘控制
var timer;
var speed = 300;

document.onkeydown = function(ev) {

	// 兼容
	var oEvent = ev || event;

	// 暂停
	if(oEvent.keyCode == 32) {
		clearInterval(timer);
	}

	var divs = document.getElementsByTagName("div");

	// 判断是否撞到自己
	function boom(){
		for(var i=0; i<divs.length; i++) {
			for(var j=0; j<divs.length; j++) {
				if(divs[i].offsetTop==divs[j].offsetTop && divs[i].offsetLeft==divs[j].offsetLeft) {
					if(i!=j) {
						alert("game over!");
						// 计算得分

					}
				}
			}
		}
	}

	setTimeout(function(){
		setInterval(function(){
			boom();
		},1000);	
	}, speed);


	// .style.left返回的是"78px", divs[0].offsetLeft返回的是78
	// 第一个小点由上下左右键控制
	// 左
	if (oEvent.keyCode==37) {
		clearInterval(timer);
		timer = setInterval(function(){
			divs[0].style.left= divs[0].offsetLeft-10+"px";
			others();
		},speed);
	}
	// 上
	if (oEvent.keyCode==38) {
		clearInterval(timer);
		timer = setInterval(function(){
			divs[0].style.top = divs[0].offsetTop-10+"px";
			others();
		},speed);
	}
	// 右
	if (oEvent.keyCode==39) {
		clearInterval(timer);
		timer = setInterval(function(){
			divs[0].style.left = divs[0].offsetLeft+10+"px";
			others();
		},speed);
	}
	// 下
	if (oEvent.keyCode==40) {
		clearInterval(timer);
		timer = setInterval(function(){
			divs[0].style.top = divs[0].offsetTop+10+"px";
			others();
		},speed);
	}

	// 后面小点跟着前一个动
	function others() {
		for(var i=divs.length-1; i>0; i--) {
			divs[i].style.top = divs[i-1].offsetTop+"px";
			divs[i].style.left = divs[i-1].offsetLeft+"px";
		}
	}

		
};
