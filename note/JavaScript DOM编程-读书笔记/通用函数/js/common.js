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

// 把一个id为nodeId的元素，移动到(toX, toY)的位置去，每interval毫秒移动余下距离的1/10
function move(nodeId, toX, toY, interval){
	if(!document.getElementById) return false;
	if(!document.getElementById(nodeId)) return false;

	var node = $(nodeId);

	if(node.movement){
		clearTimeout(node.movement);
	}

	if(!node.style.left){
		node.style.left = "0px";
	}
	if(!node.style.top){
		node.style.top = "0px";
	}

	var theX = parseFloat(node.style.left);
	var theY = parseFloat(node.style.top);

	if((theX==toX) && (theY==toY)){
		return true;
	}

	var diffX = 0;
	var diffY = 0;

	diffX = (toX-theX)/10;
	theX += diffX;
	diffY = (toY-theY)/10;
	theY += diffY;


	node.style.left = theX + "px";
	node.style.top = theY + "px";

	var repeat = "move('"+nodeId+"',"+toX+","+toY+","+interval+")";
	node.movement = setTimeout(repeat, interval);
}

// 获取元素的属性
function getStyle(obj, name) {
	if(obj.currentStyle){
		return obj.currentStyle[name];
	}else{
		return getComputedStyle(obj, false)[name];
	}
}

// 节点任意属性的缓冲运动（节点，属性，目标值）
function move(node, attribute, target) {
	clearInterval(node.timer);
	node.timer = setInterval(function() {
		var cur;
		if(attribute=="opacity"){
			cur = Math.round(parseFloat(getStyle(node, attribute))*100);
		}else {
			cur = parseInt(getStyle(node, attribute));
		}
		var speed = (target-cur)/10;
		if(speed>0){
			speed = Math.ceil(speed);
		} else {
			speed = Math.floor(speed);
		}
		if(cur == target){
			clearInterval(node.timer);
		}else{
			cur += speed;
			if(attribute=="opacity"){
				node.style.opacity = cur/100;
				node.style.filter = "alpha(opacity:"+cur+")";
			}else{
				node.style[attribute] = cur+"px";
			}
		}
	}, 30);
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

// 通用函数结束
