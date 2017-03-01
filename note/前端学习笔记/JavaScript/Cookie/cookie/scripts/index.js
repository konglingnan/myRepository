
// cookie操作函数start
// cookie: kong="123"; ling="456"; nan="321";

// 设置cookie
// setCookie(属性名, 属性值, 几天后过期)
function setCookie(name, value, Days) {

	var oDate = new Date();
	oDate.setDate(oDate.getDate()+Days);

	// 在cookie中‘=’代表追加，而不是赋值
	document.cookie = name+"="+value+";expires="+oDate; //过期时间：expires=date
}

// 获取cookie的value
function getCookie(name) {
	var cookieArr = document.cookie.split("; ");
	for(var i in cookieArr){
		arr = cookieArr[i].split("=");
		if(arr[0] == name){
			return arr[1];
		}
	}
	return "";
}

// 删除cookie
function removeCookie(name) {
	// 使其已经过期
	setCookie(name, 1, -1);
}
// cookie操作函数end


window.onload = function() {
	var form = document.getElementsByTagName('form')[0];
	var user = document.getElementsByName('user')[0];

	user.value = getCookie("user");

	form.onsubmit = function() {
		
		setCookie("user", user.value, 14);
	}
}