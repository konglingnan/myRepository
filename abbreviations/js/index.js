// 通用函数开始

function $(id){
	return document.getElementById(id);
}

// 页面加载后执行
function addLoadEvent(func) {
	var oldload = window.onload;
	if((typeof window.onload) != "function"){
		window.onload = func;
	}else {
		window.onload = function() {
			oldload();
			func();
		}
	}
}
// 通用函数结束

function displayAbbr(){
	// 对象探测
	if(!document.getElementsByTagName) return false;
	if(!document.createElement) return false;
	if(!document.createTextNode) return false;

	// 取得所有缩略词
	var abbrs = document.getElementsByTagName("abbr");
	if(abbrs.length<1) return false;
	var Arr = [];

	// 遍历缩略词，存入键值数组
	for(var i=0; i<abbrs.length; i++){
		// 兼容IE6，IE6不支持abbr元素，所以IE6的子节点数会返回0
		if(abbrs[i].childNodes.length<1) continue; 
		var key = abbrs[i].firstChild.nodeValue;
		Arr[key] = abbrs[i].getAttribute("title");
	}

	// 遍历缩略词数组，存入定义列表
	var dl = document.createElement("dl");
	for(key in Arr){
		var dt = document.createElement("dt");
		var dtText = document.createTextNode(key);
		dt.appendChild(dtText);
		dl.appendChild(dt);

		var dd = document.createElement("dd");
		var ddText = document.createTextNode(Arr[key]);
		dd.appendChild(ddText);
		dl.appendChild(dd);
	}

	if(dl.childNodes.length<1) return false;
	// 将标题和定义列表添加到页面
	var h1 = document.createElement("h1");
	var h1Text = document.createTextNode("abbreviations");
	h1.appendChild(h1Text);
	var body = document.getElementsByTagName("body")[0];
	body.appendChild(h1);
	body.appendChild(dl);
}

addLoadEvent(displayAbbr);