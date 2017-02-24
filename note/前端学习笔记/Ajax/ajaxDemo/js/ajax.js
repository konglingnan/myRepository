function ajax(url, fnSucc, fnFaild) {  //使用回调函数（回调函数是一种以参数形式传递给另一个函数的函数。）
	// 1.创建Ajax对象
	//作为属性时没有：undefined，作为变量时没有：报错
	if(window.XMLHttpRequest){  //为了不报错，使用window.
		var oAjax = new XMLHttpRequest();
	}else{  //IE6
		var oAjax = new ActiveXObject("Microsoft.XMLHttp");
	}

	// 2.连接服务器
	// oAjax.open("方法", "文件名", 异步传输);
	oAjax.open("GET", url, true);

	// 3.发送请求
	oAjax.send();

	// 4.接收响应
	oAjax.onreadystatechange = function (){  //服务器和浏览器进行到哪一步了
		if(oAjax.readyState==4 && oAjax.status==200){  //读取完成&&读取成功
			fnSucc(oAjax.responseText);
		}else{
			if(fnFaild){
				fnFaild(oAjax.status);
			}
		}
	}; //匿名函数后最好加;
}