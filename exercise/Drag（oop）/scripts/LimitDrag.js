
function LimitDrag(id) {
	Drag.call(this, id);
}

for(var i in Drag.prototype) {
	LimitDrag.prototype[i] = Drag.prototype[i];
}

// 重写
LimitDrag.prototype.mouseMove = function(ev) {

	var oEvent = ev || event;

	// 点击并移动鼠标时计算oDiv位置
	var left = oEvent.clientX-this.x;
	var top = oEvent.clientY-this.y;

	// 防止移出屏
	if(left<0) {
		left=0;
	}
	else if(left>document.documentElement.clientWidth) {
		left=document.documentElement.clientWidth-this.oDiv.offsetWidth;
	}
	if(top<0) {
		top=0;
	}
	else if(top>document.documentElement.clientHeight) {
		top=document.documentElement.clientHeight-this.oDiv.offsetHeight;
	}
	// 移动
	this.oDiv.style.left = left+"px";
	this.oDiv.style.top = top+"px";
}
