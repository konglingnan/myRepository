

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

		// 点击并移动鼠标时计算oDiv位置
		document.onmousemove = function(ev) {
			var oEvent = ev || event;
			var left = oEvent.clientX-out.offsetLeft-x;
			var top = oEvent.clientY-out.offsetTop-y;
			// 防止出框
			if(left<100) {
				left=0;
			}
			else if(left>out.offsetWidth-oDiv.offsetWidth-100) {
				left=out.offsetWidth-oDiv.offsetWidth;
			}
			if(top<100) {
				top=0;
			}
			else if(top>out.offsetHeight-oDiv.offsetHeight-100) {
				top=out.offsetHeight-oDiv.offsetHeight;
			}
			// 移动
			oDiv.style.left = left+"px";
			oDiv.style.top = top+"px";
		}

		// 鼠标松开取消行为
		document.onmouseup = function() {
			document.onmousemove = null;
			document.onmouseup = null;
		}

		// 阻止默认行为（兼容火狐bug， 和Chrome，FF，IE9的选中文字）
		return false; 
	};
};
