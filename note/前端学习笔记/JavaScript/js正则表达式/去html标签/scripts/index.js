
window.onload = function() {
	var text1 = document.getElementById('text1');
	var text2 = document.getElementById('text2');
	var btn = document.getElementsByTagName('button')[0];

	btn.onclick = function() {
		
		var reg = /<[^>]+>/g;

		text2.value=text1.value.replace(reg, "");

	}
}