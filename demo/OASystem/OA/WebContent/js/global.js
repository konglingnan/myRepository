
var URL = "http://192.168.1.9:7777/demo"; 


function getParam(key) {


	var url = location.href;


	url = url.substring( url.indexOf('?') + 1 );
	

	var params = url.split('&');


	for (var i = 0;i < params.length;i ++) {			

		var str = params[i].split('=');
		
		if (str[0] == key) {
			return str[1];
		}
	}

}