

window.onload = function() {

	var x = 0;
	var y = 0;
	var oDiv = document.getElementsByTagName("div")[0];
	//  点击oDiv时
	oDiv.onmousedown = function(ev) {
		var oEvent = ev || event;
		x = oEvent.clientX-oDiv.offsetLeft;
		y = oEvent.clientY-oDiv.offsetTop;

		// 点击并移动鼠标时计算oDiv位置
		document.onmousemove = function(ev) {
			var oEvent = ev || event;
			var left = oEvent.clientX-x;
			var top = oEvent.clientY-y;
			// 防止出框
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

		// 鼠标松开取消行为
		document.onmouseup = function() {
			document.onmousemove = null;
			document.onmouseup = null;
		}

		// 阻止默认行为（兼容火狐bug， 和Chrome，FF，IE9的选中文字）
		return false; 
	};
};
