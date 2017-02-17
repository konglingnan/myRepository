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
// 通用函数结束

// 给当前页面所对应的连接添加高亮
function highlightPage() {
	if(!document.getElementsByTagName) return false;
	var here = window.location.href;
	var header = document.getElementsByTagName("header");
	if (header.length == 0) return false;
	var nav = header[0].getElementsByTagName("nav");
	if(nav.length == 0) return false;
	var links = nav[0].getElementsByTagName("a");
	for(var i=0; i<links.length; i++){
		var linkUrl = links[i].getAttribute("href");
		if(here.indexOf(linkUrl) != -1){
			addClass(links[i], "here");
			var linkName = links[i].firstChild.nodeValue.toLowerCase();
		}
		// 给当前页面设置独特的样式
		document.getElementsByTagName("body")[0].setAttribute("id", linkName);
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

// 绑定移动事件
function prepareGralley(){
	if(!document.getElementsByTagName) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("placehoder")) return false;

	var placehoder = $("placehoder");
	var links = document.getElementsByTagName("a");
	var here;

	if(links.length == 0) return false;

	// 给元素onclick事件绑定函数
	for(var i=0; i<links.length; i++) {
		links[i].onmouseover = function() {
			here = this.getAttribute("href");
			if(here.indexOf("home") != -1){
				move("placehoder", 0, 0, 5);
			}
			if(here.indexOf("about") != -1){
				move("placehoder", -300, 0, 5);
			}
			if(here.indexOf("photos") != -1){
				move("placehoder", -600, 0, 5);
			}
			if(here.indexOf("live") != -1){
				move("placehoder", -900, 0, 5);
			}
			if(here.indexOf("contact") != -1){
				move("placehoder", -1200, 0, 5);
			}
		}
	}
}

// 创建幻灯片区域
function prepareSlides(){
	if(!document.createElement) return false;
	if(!document.createTextNode) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("intro")) return false;

	// 创建大图节点，并添加在缩略图后
	var intro = $("intro");

	var div = document.createElement("div");
	div.setAttribute("id", "placehoderArea");
	insertAfter(div, intro);

	var img = document.createElement("img");
	img.setAttribute("id", "placehoder");
	img.setAttribute("src", "images/pet.png");
	img.setAttribute("alt", "Boxes");
	div.appendChild(img);
}

function prepareSection(){
	if(!document.getElementById) return false;
	if(!document.getElementsByTagName) return false;
	if(!document.getElementsByTagName("article")) return false;
	var articles = document.getElementsByTagName("article");
	if(articles.length==0) return false;
	var navs = articles[0].getElementsByTagName("nav");
	if(navs.length==0) return false;
	var links = navs[0].getElementsByTagName("a");
	for(var i=0; i<links.length; i++){
		var sectionId = links[i].getAttribute("href").split("#")[1];
		if(!document.getElementById(sectionId)) continue;
		document.getElementById(sectionId).style.display = "none";
		links[i].des = sectionId;
		links[i].onclick = function() {
			showSection(this.des);
			return false;
		}
	}
}

function showSection(id) {
	var sections = document.getElementsByTagName("section");
	for(var i=0; i<sections.length; i++){
		if(sections[i].getAttribute("id") != id){
			sections[i].style.display = "none";
		} else {
			sections[i].style.display = "block";
		}
	}
}


addLoadEvent(prepareSlides);
addLoadEvent(prepareGralley);
addLoadEvent(highlightPage);
addLoadEvent(prepareSection);
