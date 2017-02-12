function $(id){
	return document.getElementById(id);
}

function addLoadEvent(func) {
	var oldload = window.onload;
	if(typeof window.onload != "function"){
		window.onload = func;
	}else {
		window.onload = function() {
			oldload();
			func();
		}
	}
}

function showPic(node){
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

	for(var i=0; i<links.length; i++){
		links[i].onclick = function() {
			return showPic(this);
		};
	}
}

addLoadEvent(prepareGralley);
