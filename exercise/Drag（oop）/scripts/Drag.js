
function Drag(id) {

	var _this = this;

	this.x = 0;
	this.y = 0;
	this.oDiv = document.getElementById(id);
	//  点击oDiv时
	this.oDiv.onmousedown = function(ev) {
		_this.mouseDown(ev);
		// 阻止默认行为（兼容火狐bug， 和Chrome，FF，IE9的选中文字）
		return false;
	}
};

Drag.prototype.mouseDown = function(ev) {

	var _this = this;

	var oEvent = ev || event;

	// 鼠标距小方块左上角的位置
	this.x = oEvent.clientX-this.oDiv.offsetLeft;
	this.y = oEvent.clientY-this.oDiv.offsetTop;

	if(this.oDiv.setCapture){
		// IE
		document.onmousemove = function() {
			_this.mouseMove(ev);
		}

		// 鼠标松开取消行为
		this.oDiv.onmouseup = _this.mouseUp;
		
		// （上锁）IE专有，事件捕获（整个网页所有的事件都会集中到oDiv上，被oDiv捕获）
		// 防止当鼠标移动过快，脱离方块时
		// 同时防止选中文字
		this.oDiv.setCapture();
	} else {
		// chrome，FF
		document.onmousemove = function(ev) {
			_this.mouseMove(ev);
		}
		document.onmouseup = _this.mouseUp;
	}
};


Drag.prototype.mouseMove = function(ev) {

	var oEvent = ev || event;

	// 点击并移动鼠标时计算oDiv位置
	var left = oEvent.clientX-this.x;
	var top = oEvent.clientY-this.y;

	// 移动
	this.oDiv.style.left = left+"px";
	this.oDiv.style.top = top+"px";
}


// 鼠标松开，解除事件行为
Drag.prototype.mouseUp = function() {
	this.onmousemove = null;
	this.onmouseup = null;

	// （开锁）释放事件捕获，防止其他元素无法正常进行事件处理
	if(this.oDiv.releaseCapture) {
		this.oDiv.releaseCapture();
	}
}
