
window.onload = function() {

	var input = document.getElementsByTagName("input")[0];

	// 禁止输入中文
	input.onkeyup = function() {
		this.value = this.value.replace(/[^0-9]+/g,'')
	}

	// 阻止除数字以外按键的默认行为
	input.onkeydown = function(ev) {
		var oEvent = ev ||event;

		// 如果不是数字 && 不是退格 && 不是左移 && 不是右移，则阻止默认行为
		if((oEvent.keyCode<48 || oEvent.keyCode>57) && oEvent.keyCode!=8 && oEvent.keyCode!=37 && oEvent.keyCode!=39) {
			return false;
		}
	};
};
