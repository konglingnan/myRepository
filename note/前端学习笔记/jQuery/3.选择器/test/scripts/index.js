// $(document).ready(function() { }); 的简写

$(function() {

	$('div').prevAll('p').nextAll('p').css("color", "red");

});




// jQuery中的常规选择器与css基本相同
$('p');
$('#pid');
$('.yang');
$('p, .yang');
$('ul li *');
$('ul li a');
$('.yang.lan');
$('p');




// 高级选择器(IE6, css不支持,jQuery支持)
// next()等方法不传参相当于传递*，如果所得结点多了，性能不好，如果刚好是想要的，可以用

// 子选择器
$('div > p');
// ==
$('div').find('p');
$('div').find();  //不传参相当于传递*


// 后代选择器
$('div  p');
// ==
$('div').children('p');

// 同级下一个p结点
$('div + p');
// ==
$('div').next('p');  //同级下一个p结点

// 同级后面所有结点
$('div ~ p');
// ==
$('div').nextAll();

// 前面的结点
$('div').prev();

// 前面的所有结点
$('div').prevAll();

// 同级所有结点
$('div').siblings();
// ==
$('div').prevAll();
$('div').nextAll();

// 这个不对，因为返回了div前面的所有元素，而没操作，直接获取了后面进行操作
// $('div').prevAll('p').nextAll('p').css("color", "red");


// div往前/往后到p之间的所有同级元素
$('div').prevUntil('p');
$('div').nextUntil('p');

