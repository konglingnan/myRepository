

window.onload = function() {

	var x = 0;
	var y = 0;
	var oDiv = document.getElementsByTagName("div")[0];
	//  点击oDiv时
	oDiv.onmousedown = function(ev) {
		var oEvent = ev || event;

		// 鼠标距小方块左上角的位置
		x = oEvent.clientX-oDiv.offsetLeft;
		y = oEvent.clientY-oDiv.offsetTop;


		if(oDiv.setCapture){
			// IE
			document.onmousemove = mouseMove;

			// 鼠标松开取消行为
			oDiv.onmouseup = mouseUp;
			
			// （上锁）IE专有，事件捕获（整个网页所有的事件都会集中到oDiv上，被oDiv捕获）
			// 防止当鼠标移动过快，脱离方块时
			// 同时防止选中文字
			oDiv.setCapture();
		} else {
			// chrome，FF
			document.onmousemove = mouseMove;

			// 鼠标松开取消行为
			document.onmouseup = mouseUp;
		}
		
		function mouseMove(ev) {
				var oEvent = ev || event;

				// 点击并移动鼠标时计算oDiv位置
				var left = oEvent.clientX-x;
				var top = oEvent.clientY-y;

				// 防止移出屏
				if(left<0) {
					left=0;
				}
				else if(left>document.documentElement.clientWidth) {
					left=document.documentElement.clientWidth-oDiv.offsetWidth;
				}
				if(top<0) {
					top=0;
				}
				else if(top>document.documentElement.clientHeight) {
					top=document.documentElement.clientHeight-oDiv.offsetHeight;
				}
				// 移动
				oDiv.style.left = left+"px";
				oDiv.style.top = top+"px";
			}

			// 鼠标松开，解除事件行为
			function mouseUp() {
				this.onmousemove = null;
				this.onmouseup = null;

				// （开锁）释放事件捕获，防止其他元素无法正常进行事件处理
				if(oDiv.releaseCapture) {
					oDiv.releaseCapture();
				}
			}

		// 阻止默认行为（兼容火狐bug， 和Chrome，FF，IE9的选中文字）
		return false; 
	};
};
