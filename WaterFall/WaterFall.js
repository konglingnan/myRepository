window.onload = function() {
	imgLocation("container", "box");
}

function imgLocation(parentClass, contentClass) {
	var parent = $(parentClass);
	var boxs = getChilds(parent, contentClass);
	var boxWidth = boxs[0].offsetWidth;
	var screenWidth = document.documentElement.clientWidth || document.body.clientWidth;
	var cols = Math.floor(screenWidth/boxWidth);
	parent.style.cssText = "width: "+cols*boxWidth+"px; margin: 0 auto;";
}

function getChilds(parent, contentClass){
	var theChilds = [];
	var allChilds = parent.getElementsByTagName("div");
	for(var i=0; i<allChilds.length; i++){
		if(allChilds[i].className==contentClass){
			theChilds.push(allChilds[i]);
		}
	}
	return theChilds;
}

function $(id) {
	return document.getElementById(id);
}
