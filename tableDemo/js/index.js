function addClass(element, newClass) {
	if(!element.className){
		element.className = newClass;
	}else {
		element.className += " " + newClass;
	}
}

// 动态添加隔行样式
function stripeTables(){
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
				odd = true;
			}
		}
	}
}

window.onload = function(){
	stripeTables();
}