
window.onload = function() {
	var text = document.getElementById("text");
	var btn = document.getElementById("btn");

	btn.onclick = function() {
		var newWin = window.open("about:blank", "_blank");
		newWin.document.write(text.value);
	}
}