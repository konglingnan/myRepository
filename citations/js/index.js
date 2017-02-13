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

function displayCite(){
	if(!document.getElementsByTagName) return false;
	if(!document.createElement) return false;
	if(!document.createTextNode) return false;

	// 获取引用元素数组
	var quotes = document.getElementsByTagName("blockquote");
	if(quotes.length<1) return false;
	// 遍历数组，并插入blockquote中
	for(var i=0; i<quotes.length; i++){
		// 如果当前blockquote无cite属性，则继续寻找下一个
		if(!quotes[i].getAttribute("cite")) continue;
		var cite = quotes[i].getAttribute("cite");

		// 获取当前blockquote的最后一个子节点（避免是换行符）
		var quoteChilds = quotes[i].getElementsByTagName("*");
		// 如果blockquote无子节点，则继续寻找下一个
		var quoteLastChild = quoteChilds[quoteChilds.length-1];

		// 创建元素
		var a = document.createElement("a");
		a.setAttribute("href", cite);
		var aText = document.createTextNode("source");
		a.appendChild(aText);
		var sup = document.createElement("sup");
		sup.appendChild(a);

		// 把链接添加到最后一个节点上
		quoteLastChild.appendChild(sup);
	}
}

addLoadEvent(displayCite);