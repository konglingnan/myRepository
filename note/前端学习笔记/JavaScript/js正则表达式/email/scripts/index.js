
window.onload = function() {
	var btn = document.getElementsByTagName('button')[0];
	var email = document.getElementsByTagName('input')[0];

	btn.onclick = function() {
		
		var reg = /^\w+@[a-z0-9]+\.[a-z]+$/i;

		if(reg.test(email.value)){
			alert("是正确的email格式！");
		}else{
			alert("不是正确的email格式！");
		}
	}
}