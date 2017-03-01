
function Tap(id) {


	var _this = this;

	var tap = document.getElementById(id);
	this.btns = tap.getElementsByTagName("button");
	this.divs = tap.getElementsByTagName("div");

	for(var i=0; i<this.btns.length; i++) {
		this.btns[i].idex = i;
		this.btns[i].onclick = function() {
			
			// 这个_this是Tap的this，如果直接用this就是btn的this
			// 这样函数内的this就还是Tap对象，而不是btn

			// _this是Tap对象，this是按钮
			_this.btnClick(this);
		}
	}
};

Tap.prototype.btnClick = function(oBtn) {
	// 这里的this是Tap对象
	for(var i=0; i<this.btns.length; i++){
		this.btns[i].className = "";
		this.divs[i].style.display = "none";
	}
	oBtn.className = "active";
	this.divs[oBtn.idex].style.display = "block";
}

window.onload = function() {
	new Tap("tap");
}