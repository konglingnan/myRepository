

window.onload = function() {

	var x = 0;
	var y = 0;
	var out = document.getElementById("out");
	var oDiv = document.getElementById("inner");
	//  点击oDiv时
	oDiv.onmousedown = function(ev) {
		var oEvent = ev || event;

		// 创建虚线框
		var oBox = document.createElement("div");
		oBox.className = "box";
		// 计算宽高时要减去border
		oBox.style.width = oDiv.offsetWidth-2+"px";
		oBox.style.height = oDiv.offsetHeight-2+"px";
		oBox.style.top = oDiv.offsetTop+"px";
		oBox.style.left = oDiv.offsetLeft+"px";
		out.appendChild(oBox);

		// 鼠标以小方块的左上角为原点的坐标
		x = oEvent.clientX-out.offsetLeft-oDiv.offsetLeft;
		y = oEvent.clientY-out.offsetTop-oDiv.offsetTop;

		if(oBox.setCapture){ //IE
			// 点击并移动鼠标时计算oDiv位置
			document.onmousemove = mouseMove;
			// 鼠标松开取消行为
			oBox.onmouseup = mouseUp;
			// 虚线框进行事件捕获
			oBox.setCapture();
		} else {
			document.onmousemove = mouseMove;
			document.onmouseup = mouseUp;
		}

		// 鼠标移动
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
			// 移动虚线框
			oBox.style.left = left+"px";
			oBox.style.top = top+"px";
		}

		// 鼠标松开
		function mouseUp() {
			// 将虚线框的位置赋给oDiv
			oDiv.style.left = oBox.style.left;
			oDiv.style.top = oBox.style.top;

			// 删除虚线框
			out.removeChild(oBox);

			this.onmousemove = null;
			this.onmouseup = null;

			if(oBox.releaseCapture){		
				// 释放事件捕获
				oBox.releaseCapture();
			}
		}

		// 阻止默认行为（兼容火狐bug， 和Chrome，FF，IE9的选中文字）
		return false; 
	};
};
