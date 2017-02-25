
window.onload = function() {
	var comment = document.getElementById("comment");

	var oUl = comment.getElementsByTagName("ul")[0];
	var oBtn = comment.getElementsByTagName("button")[0];
	var textArea = comment.getElementsByTagName("textarea")[0];

	oBtn.onclick = function() {
		// 获取文本
		var content = textArea.value;
		// 创建li节点
		var oLi = document.createElement("li");
		oLi.innerHTML = content;
		// 插入li节点
		if(oUl.childNodes.length>0){
			oUl.insertBefore(oLi, oUl.childNodes[0]);
		} else {
			oUl.appendChild(oLi);
		}

		// 存放li高度
		// offsetHeight获取的高度包括padding，后面设回的高度不包括padding，所以要减掉
		var height = oLi.offsetHeight-20;
		oLi.style.height = 0;

		// 显示
		move(oLi, {height: height}, function() {
			move(oLi, {opacity: 100});
		});

		textArea.value = "";
		textArea.focus();

	};

};