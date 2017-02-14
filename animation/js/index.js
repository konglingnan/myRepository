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

	// 设置成属性为了使其他move函数调用时能访问movement，使其他的移动时可以取消之前的移动。
	node.movement = setTimeout(repeat, interval);
}
// 通用函数结束

function prepareGralley(){
	if(!document.getElementsByTagName) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("gallery")) return false;
	if(!document.getElementById("placehoder")) return false;

	var gallery = $("gallery");
	var placehoder = $("placehoder");
	var links = gallery.getElementsByTagName("a");

	// 给元素onclick事件绑定函数
	links[0].onmouseover = function() {
		move("placehoder", 0, 0, 10);
	}
	links[1].onmouseover = function() {
		move("placehoder", -300, 0, 10);
	}
	links[2].onmouseover = function() {
		move("placehoder", -600, 0, 10);
	}
	links[3].onmouseover = function() {
		move("placehoder", -900, 0, 10);
	}
	links[4].onmouseover = function() {
		move("placehoder", -1200, 0, 10);
	}
}

function prepareSlides(){
	if(!document.createElement) return false;
	if(!document.createTextNode) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("gallery")) return false;

	// 创建大图节点，并添加在缩略图后
	var gallery = $("gallery");

	var div = document.createElement("div");
	div.setAttribute("id", "placehoderArea");
	insertAfter(div, gallery);

	var img = document.createElement("img");
	img.setAttribute("id", "placehoder");
	img.setAttribute("src", "images/pet.png");
	img.setAttribute("alt", "Boxes");
	div.appendChild(img);
}

addLoadEvent(prepareSlides);
addLoadEvent(prepareGralley);
