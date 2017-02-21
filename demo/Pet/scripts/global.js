// 通用函数开始
function $(id) {
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
function insertAfter(newNode, targetNode) {
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

// 公共区域开始
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
// 公共区域结束

// home幻灯片开始
function prepareSlides() {
	if(!document.createElement) return false;
	if(!document.createTextNode) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("intro")) return false;

	// 创建大图节点，并添加在缩略图后
	var intro = $("intro");

	var div = document.createElement("div");
	div.setAttribute("id", "placeholderArea");
	insertAfter(div, intro);

	var img = document.createElement("img");
	img.setAttribute("id", "placeholder");
	img.setAttribute("src", "images/pet.png");
	img.setAttribute("alt", "Boxes");
	div.appendChild(img);
}

// 把一个id为nodeId的元素，移动到(toX, toY)的位置去，每interval毫秒移动余下距离的1/10
function move(nodeId, toX, toY, interval) {
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
function prepareMove() {
	if(!document.getElementsByTagName) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("placeholder")) return false;

	var placeholder = $("placeholder");
	var links = document.getElementsByTagName("a");
	var here;

	if(links.length == 0) return false;

	// 给元素onclick事件绑定函数
	for(var i=0; i<links.length; i++) {
		links[i].onmouseover = function() {
			here = this.getAttribute("href");
			if(here.indexOf("home") != -1){
				move("placeholder", 0, 0, 5);
			}
			if(here.indexOf("about") != -1){
				move("placeholder", -300, 0, 5);
			}
			if(here.indexOf("photos") != -1){
				move("placeholder", -600, 0, 5);
			}
			if(here.indexOf("live") != -1){
				move("placeholder", -900, 0, 5);
			}
			if(here.indexOf("contact") != -1){
				move("placeholder", -1200, 0, 5);
			}
		}
	}
}
// home幻灯片结束

// about介绍开始
function prepareSection() {
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
// about介绍结束

// photos图片库开始
function prepareGralley() {
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

function prepareImage() {
	if(!document.createElement) return false;
	if(!document.createTextNode) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("gallery")) return false;

	// 创建大图节点和描述节点，并依次添加在缩略图后
	var gallery = $("gallery");
	var img = document.createElement("img");
	img.setAttribute("id", "imgPlaceholder");
	img.setAttribute("src", "images/photos/0.jpg");
	img.setAttribute("alt", "Pet");
	insertAfter(img, gallery);

	var text = document.createTextNode("Cat");
	var p = document.createElement("p");
	p.setAttribute("id", "description");
	p.appendChild(text);
	img.parentNode.insertBefore(p, img);
}

function showPic(node) {
	// 获取节点信息并传给imgPlaceholder和description
	if(!document.getElementById("imgPlaceholder")) return false;
	var imgPlaceholder = $("imgPlaceholder");
	var href = node.getAttribute("href");
	imgPlaceholder.setAttribute("src", href);

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
// photos图片库结束

// live表格开始
// 动态添加隔行样式
function stripeTables() {
	if(!document.getElementsByTagName) return false;

	var tables = document.getElementsByTagName("table");
	var odd;
	var rows = [];
	for(var i=0; i<tables.length; i++){
		odd = false;
		rows = tables[i].getElementsByTagName("tr");
		//改一个变一次odd值
		for(var j=0; j<rows.length; j++){
			if(odd == true){
				addClass(rows[j], "odd");
				odd = false;
			}else {
				addClass(rows[j], "eve");
				odd = true;
			}
		}
	}
}
function prepareHighlight() {
	if(!document.getElementsByTagName) return false;
	var rows = document.getElementsByTagName("tr");
	for(var i=0; i<rows.length; i++){
		rows[i].oldClass = rows[i].className;
		rows[i].onmouseover = function() {
			addClass(this, "highlight");
		}
		rows[i].onmouseout = function() {
			this.className = this.oldClass;
		}
	}
}
function prepareAbbr() {
	var article = document.getElementsByTagName("article")[0];
	displayAbbr(article);
}
function displayAbbr(node) {
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
	node.appendChild(h1);
	node.appendChild(dl);
}
// live表格结束

// contact表单开始
function focusLabels() {
	if(!document.getElementsByTagName) return false;
	if(!document.getElementById) return false;
	var labels = document.getElementsByTagName("label");
	for(var i=0; i<labels.length; i++){
		if(!labels[i].getAttribute("for")) continue;
		labels[i].onclick = function() {
			var labelFor = this.getAttribute("for");
			if(!document.getElementById(labelFor)) return false;
			var elem = document.getElementById(labelFor);
			elem.focus();
		}
	}
}
// 兼容input的placeholder
function resetFields(form) {
	if(Modernizr.input.placeholder) return;
	if(!document.getElementsByTagName) return false;
	var elems = form.elements;
	for(var i=0; i<elems.length; i++){
		var elem = elems[i];
		if(elem.type == "submit" || elem.type == "reset") continue;
		var check = elem.placeholder || elem.getAttribute("placeholder");
		if(!check) continue;
		elem.onfocus = function() {
			var text = elem.placeholder || elem.getAttribute("placeholder");
			if(this.value == text){
				this.value = "";
				this.className = "";
			}
		}
		elem.onblur = function() {
			if(this.value == ""){
				this.value = this.placeholder || this.getAttribute("placeholder");
				addClass(this, "holder");
			}
		}
	}
}
// 表单验证
function isText(elem) {
	if(elem.value.replace(" ", "").length == 0) return false;
	var holder = elem.placeholder || elem.getAttribute("placeholder");
	return (elem.value != holder);
}
function isEmail(elem) {
	var check = (elem.value.indexOf("@") != -1) && (elem.value.indexOf(".") != -1);
	return check;
}
function validateForm(form) {
	var elems = form.elements;
	for(var i=0; i<elems.length; i++){
		var elem = elems[i];
		if(elem.required == "required") {
			if(!isText(elem)){
				alert("Please fill in the "+elem.name+"field.");
				return false;
			}
		}
		if(elem.type == "email") {
			if(!isEmail(elem)){
				alert("The "+elem.name+"field must be a valid email address.");
				return false;
			}
		}
	}
	return true;
}
// ajax刷新提交结果
function submitFormWithAjax(form, target) {
	if(window.XMLHttpRequest){
		var oAjax = new XMLHttpRequest();
	}else{
		var oAjax = new ActiveXObject("Microsoft.XMLHttp");
	}
	if(!oAjax) return false;
	displayLoading(target);
	var dataArr = [];
	var elem;
	for(var i=0; i<form.elements.length; i++){
		var elem = form.elements[i];
		dataArr[i] = elem.name+"="+encodeURIComponent(elem.value);
	}
	var data = dataArr.join("&");

	oAjax.open("POST", form.getAttribute("action"), true);

	// post请求必须有这个头信息
	oAjax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	oAjax.onreadystatechange = function() {
		if(oAjax.readyState==4){
			if(oAjax.status==200 || oAjax.status==0){
				// 匹配<article>与</article>之间的字段，()内为捕获组，返回一个数组，matches[0]是包括<article>标签在内的部分，而matches[1]表示捕获组中模式匹配的部分
				var matches = oAjax.responseText.match(/<article>([\s\S]+)<\/article>/);
				if(matches.length>0) {
					target.innerHTML = matches[1];
				}else{
					target.innerHTML = "<p>error!</p>"
				}
			}else{
				target.innerHTML = "<p>"+oAjax.statusText+"</p>";
			}
		}
	};
	oAjax.send(data);
	return true;
}
function displayLoading(elem) {
	while(elem.hasChildNodes()) {
		elem.removeChild(elem.lastChild);
	}
	var content = document.createElement("img");
	content.setAttribute("src", "images/loading.gif");
	content.setAttribute("alt", "loading...");
	elem.appendChild(content);
}

function prepareForms() {
	var forms = document.getElementsByTagName("form");
	for(var i=0; i<forms.length; i++){
		var form = forms[i];
		resetFields(form);
		form.onsubmit = function() {
			if(!validateForm(form)) return false;
			var article = document.getElementsByTagName("article")[0];
			if(submitFormWithAjax(form, article)) return false;
			return true;
		}
	}
}
// contact表单结束


addLoadEvent(prepareImage);
addLoadEvent(prepareGralley);
addLoadEvent(prepareSlides);
addLoadEvent(prepareMove);
addLoadEvent(highlightPage);
addLoadEvent(prepareSection);
addLoadEvent(stripeTables);
addLoadEvent(prepareAbbr);
addLoadEvent(prepareHighlight);
addLoadEvent(focusLabels);
addLoadEvent(prepareForms);