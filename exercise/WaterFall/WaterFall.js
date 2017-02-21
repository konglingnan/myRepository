window.onload = function() {
	imgLocation("container", "box");
	var imgData={"data": [{"src":"0.jpg"}, {"src":"1.jpg"}, {"src":"2.jpg"}, {"src":"3.jpg"}, {"src":"4.jpg"}, {"src":"5.jpg"}, {"src":"6.jpg"}, {"src":"7.jpg"}, {"src":"8.jpg"}, {"src":"9.jpg"}]}
	window.onscroll = function(){
		var parent = $("container");
		if(scrollFlag("container", "box")){
			for(var i=0; i<imgData.data.length; i++){
				var box = document.createElement("div");
				box.className="box";
				var img = document.createElement("img");
				img.src="images/"+imgData.data[i].src;
				box.appendChild(img);
				parent.appendChild(box);
			}
		}
		imgLocation("container", "box");
	} 
}

function scrollFlag(parentClass, contentClass){
	var flag;
	var parent = $(parentClass);
	var boxs = getChilds(parent, contentClass);
	var maxHeight = boxs[boxs.length-1].offsetTop;
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	var sawHeight = document.documentElement.clientHeight || document.body.clientHeight;
	if(maxHeight<scrollTop+sawHeight){
		flag = true;
	}else{
		flag = false;
	}
	return flag;
}

function imgLocation(parentClass, contentClass) {
	var parent = $(parentClass);
	var boxs = getChilds(parent, contentClass);
	var boxWidth = boxs[0].offsetWidth;
	var screenWidth = document.documentElement.clientWidth || document.body.clientWidth;
	var cols = Math.floor(screenWidth/boxWidth);
	parent.style.cssText = "width: "+cols*boxWidth+"px; margin: 0 auto;";

	var heightArr = [];
	for(var i=0; i<boxs.length; i++){
		if(i<cols){
			heightArr[i] = boxs[i].offsetHeight;
		}else{
			var minHeight = Math.min.apply(null, heightArr);
			var minIndex = getMinHeightLocation(heightArr, minHeight);
			boxs[i].style.position = "absolute";
			boxs[i].style.top = minHeight+"px";
			boxs[i].style.left = boxs[minIndex].offsetLeft+"px";
			heightArr[minIndex] = heightArr[minIndex]+boxs[i].offsetHeight;
		}
	}
}

function getMinHeightLocation(heightArr, minHeight){
	for(var i=0; i<heightArr.length; i++){
		if(heightArr[i]==minHeight){
			return i;
		}
	}
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
