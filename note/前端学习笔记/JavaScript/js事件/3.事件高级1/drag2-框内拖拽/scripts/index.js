

window.onload = function() {

	var x = 0;
	var y = 0;
	var out = document.getElementById("out");
	var oDiv = document.getElementById("inner");
	//  点击oDiv时
	oDiv.onmousedown = function(ev) {
		var oEvent = ev || event;
		// 鼠标以小方块的左上角为原点的坐标
		x = oEvent.clientX-out.offsetLeft-oDiv.offsetLeft;
		y = oEvent.clientY-out.offsetTop-oDiv.offsetTop;

		if(oDiv.setCapture){
			// 点击并移动鼠标时计算oDiv位置
			document.onmousemove = mouseMove;
			// 鼠标松开取消行为
			oDiv.onmouseup = mouseUp;

			// 事件捕获
			oDiv.setCapture();
		} else {
			document.onmousemove = mouseMove;
			document.onmouseup = mouseUp;
		}

		function mouseMove(ev) {
			var oEvent = ev || event;
			var left = oEvent.clientX-out.offsetLeft-x;
			var top = oEvent.clientY-out.offsetTop-y;
			// 防止出框
			if(left<0) {
				left=0;
			}
			else if(left>out.offsetWidth-oDiv.offsetWidth) {
				left=out.offsetWidth-oDiv.offsetWidth;
			}
			if(top<0) {
				top=0;
			}
			else if(top>out.offsetHeight-oDiv.offsetHeight) {
				top=out.offsetHeight-oDiv.offsetHeight;
			}
			// 移动
			oDiv.style.left = left+"px";
			oDiv.style.top = top+"px";
		}

		function mouseUp() {
			this.onmousemove = null;
			this.onmouseup = null;

			if(oDiv.releaseCapture){
				oDiv.releaseCapture();
			}
		}

		// 阻止默认行为（兼容火狐bug， 和Chrome，FF，IE9的选中文字）
		return false; 
	};
};
