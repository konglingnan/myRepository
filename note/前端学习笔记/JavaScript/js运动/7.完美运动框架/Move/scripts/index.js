
window.onload = function() {
	var go = document.getElementById("go");
	var content = document.getElementById("content");
	var content2 = document.getElementById("content2");

	var json = {height:101, width:500, opacity:100};

	go.onclick = function() {
		move2(content, json);
		move2(content2, json, function(){
			alert("完成！");
		});
	};

}