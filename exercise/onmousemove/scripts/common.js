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

//追加className
function addClass(element, newClass) {
	if(!element.className){
		element.className = newClass;
	}else {
		element.className += " " + newClass;
	}
}

// 查找一个元素下的所有此类元素
function getByClass(parentNode, className) {
	var childs = parentNode.getElementsByTagName("*");
	var classArr = [];
	for(var i=0; i<childs.length; i++){
		if(childs[i].className.indexOf(className) != -1){
			classArr.push(childs[i]);
		}
	}
	return classArr;
}

// 得到elem的下一个元素节点
function getNextElement(elem){
	var elemNext = elem.nextSibling;
	if(elemNext.nodeType==1){
		return elemNext;
	}
	if(elemNext.nextSibling) {
		return getNextElement(elemNext);
	}
	return null;
}

// 获取元素的属性
function getStyle(obj, name) {
	if(obj.currentStyle){
		return obj.currentStyle[name];
	}else{
		return getComputedStyle(obj, false)[name];
	}
}

// 完美运动框架（var json={width:300, height:500};）
// 节点多个属性的缓冲运动（节点，json，回调函数）
function move(node, json, func) {
	clearInterval(node.timer);
	node.timer = setInterval(function() {
		var stop = true;
		for(var attr in json){
			var cur;
			if(attr=="opacity"){
				cur = Math.round(parseFloat(getStyle(node, attr))*100);
			}else {
				cur = parseInt(getStyle(node, attr));
			}
			var speed = (json[attr]-cur)/6;
			if(speed>0){
				speed = Math.ceil(speed);
			} else {
				speed = Math.floor(speed);
			}
			if(cur != json[attr]) {
				stop = false;
			}
			cur += speed;
			if(attr=="opacity"){
				node.style.opacity = cur/100;
				node.style.filter = "alpha(opacity:"+cur+")";
			}else{
				node.style[attr] = cur+"px";
			}
		}
		if(stop) {
			clearInterval(node.timer);
			if(func) func();
		}
	}, 30);
}


// 通用函数结束