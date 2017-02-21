
function $(id){
	return document.getElementById(id);
}

document.onkeydown=function(e){
  e=window.event||e;
  switch(e.keyCode){
    case 37: //左
    move(1);
      break;
    case 38: //上
    move(0);
      break;
    case 39: //右
    move(2);
      break;
    case 40: //下
    move(3);
      break;
    default:
      break;
  }
}

function Mario(id){
	this.move=function(direct){

		switch(direct){
			case 0://上
				var top = $(id).style.top;
				top = top.substr(0, top.length-2);
				top = parseInt(top);
				top -= 50;
				$(id).style.top=top+"px";
				break;
			case 1://左
				var left = $(id).style.left;
				left = left.substr(0, left.length-2);
				left = parseInt(left);
				left -= 50;
				$(id).style.left=left+"px";
				break;	
			case 2://右
				var left = $(id).style.left;
				left = left.substr(0, left.length-2);
				left = parseInt(left);
				left += 50;
				$(id).style.left=left+"px";
				break;
			case 3://下
				var top = $(id).style.top;
				top = top.substr(0, top.length-2);
				top = parseInt(top);
				top += 50;
				$(id).style.top=top+"px";
				break;
		}

// mario上下左右
		var object_mario = document.styleSheets[0];
		if (object_mario.cssRules){
		    mario_rule = object_mario.cssRules[5]; 
		} else {
		    mario_rule = object_mario.rules[5]; 
		}

		var mario_width = mario_rule.style.width;
		mario_width = mario_width.substr(0, mario_width.length-2);
		mario_width = parseInt(mario_width);

		var mario_height = mario_rule.style.height;
		mario_height = mario_height.substr(0, mario_height.length-2);
		mario_height = parseInt(mario_height);

		var mario_top = $(id).style.top;
		mario_top = mario_top.substr(0, mario_top.length-2);
		mario_top = parseInt(mario_top);

		var mario_left = $(id).style.left;
		mario_left = mario_left.substr(0, mario_left.length-2);
		mario_left = parseInt(mario_left);

		var mario_right = mario_left+mario_width;

		var mario_bottom = mario_top+mario_height;

// mashroom 上下左右
		var mashroom_top = $("mashroom").style.top;
		mashroom_top = mashroom_top.substr(0, mashroom_top.length-2);
		mashroom_top = parseInt(mashroom_top);

		var mashroom_left = $("mashroom").style.left;
		mashroom_left = mashroom_left.substr(0, mashroom_left.length-2);
		mashroom_left = parseInt(mashroom_left);

		var mashroom_right = mashroom_left+50;

		var mashroom_bottom = mashroom_top+50;

//是否胜利
		if(mario_height>=400){
			alert('bingo!');
			mario_rule.style.height = 80+"px";
			mario_rule.style.width = 80+"px";
		}

//是否出界
		 if(mario_top<50 || mario_left<50 || mario_right>950 || mario_bottom>650){
		 	alert("超出边界！惩罚mario变回原样！");
			mario_rule.style.height = 80+"px";
			mario_rule.style.width = 80+"px";
		 }

//检测马里奥是否吃到蘑菇
		if(!(mario_bottom<mashroom_top || mario_left>mashroom_right || mario_top>mashroom_bottom || mario_right<mashroom_left)){

			var m = $("mashroom");
			m.parentNode.removeChild(m);

			var object = document.styleSheets[0];
			if (object.cssRules){
			    rule = object.cssRules[5]; 
			} else {
			    rule = object.rules[5]; 
			} 

			var width = rule.style.width;
			width = width.substr(0, width.length-2);
			width = parseInt(width);
			width += 20;
			rule.style.width=width+"px";

			var height = rule.style.height;
			height = height.substr(0, height.length-2);
			height = parseInt(height);
			height += 20;
			rule.style.height=height+"px";

//长出新蘑菇
			var randomWidth = Math.random();
			randomWidth *= 850;
			var randomHeight = Math.random();
			randomHeight *= 550;

			var imgChild = document.createElement("img");
			imgChild.src = "images/1.png";
			imgChild.style.top = randomHeight+"px";
			imgChild.style.left = randomWidth+"px";
			imgChild.id = "mashroom";
			$("playZone").appendChild(imgChild);
		}
	}
}

var mario = new Mario("mario");

function move(direct){
	mario.move(direct);
}
