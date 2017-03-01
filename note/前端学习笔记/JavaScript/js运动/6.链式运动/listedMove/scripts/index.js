
window.onload = function() {
	var content = document.getElementById("content");
	var div1 = getByClass(content, "div1")[0];
	var div2 = getByClass(content, "div2")[0];
	var div3 = getByClass(content, "div3")[0];
	var close = getByClass(div3, "close")[0];

	div1.onclick = function() {
		move(div2, "right", 0, function() {
			div3.style.display = "block";
			move(div3, "bottom", 0);
		});
	};

	close.onclick = function() {
		move(div3, "bottom", -250, function() {
			div3.style.display = "none";
			move(div2, "right", -100);
		});
	};

}