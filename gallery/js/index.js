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

// 在某个节点后插入新节点
function insertAfter(newNode, targetNode){
	var parent = targetNode.parentNode;
	if(parent.lastChild == targetNode){
		parent.appendChild(newNode);
	}else {
		parent.insertBefore(newNode, targetNode.nextSibling);
	}
}
// 通用函数结束

function showPic(node){
	// 获取节点信息并传给placehoder和description
	if(!document.getElementById("placehoder")) return false;
	var placehoder = $("placehoder");
	var href = node.getAttribute("href");
	placehoder.setAttribute("src", href);

	if(!document.getElementById("description")) return false;
	var description = $("description");

	if(node.getAttribute("title")) {
		var desc = node.getAttribute("title");
	}
	else {
		var desc = "";
	}

	if(description.firstChild.nodeType==3){
		description.firstChild.nodeValue = desc;
	}
	
	return false;
}

function prepareGralley(){
	if(!document.getElementsByTagName) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("gallery")) return false;

	var gallery = $("gallery");
	var links = gallery.getElementsByTagName("a");

	// 给元素onclick事件绑定函数
	for(var i=0; i<links.length; i++){
		links[i].onclick = function() {
			return showPic(this);
		};
	}
}

function prepareImage(){
	if(!document.createElement) return false;
	if(!document.createTextNode) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("gallery")) return false;

	// 创建大图节点和描述节点，并依次添加在缩略图后
	var gallery = $("gallery");
	var img = document.createElement("img");
	img.setAttribute("id", "placehoder");
	img.setAttribute("src", "images/0.png");
	img.setAttribute("alt", "Boxes");
	insertAfter(img, gallery);

	var text = document.createTextNode("Boxes[0]");
	var p = document.createElement("p");
	p.setAttribute("id", "description");
	p.appendChild(text);
	insertAfter(p, img);
}

addLoadEvent(prepareImage);
addLoadEvent(prepareGralley);
