// $(document).ready(function() { }); 的简写
$(function() {

	$("#did").css("color", "red").css("backgroundColor","blue");

});




jQuery(function() {

	jQuery("#did").css("color", "red");

});

alert($ === jQuery);

		$(); 			//返回jQuery对象
		$().css(); 		//返回jQuery对象
		$().get(0);		//返回DOM对象
		$()[0];	//返回DOM对象
		$($().get(0));	//返回jQuery对象



// 多个库之间冲突的解决方法

	如果在两个库都以$作为起始基准符，$的所有权归后引用的库

	如果jQuery在前，无所有权，仍想使用jQuery的$,可以这样做:
	1.  $$ = jQuery; 然后使用$$();作为jQuery的$
	2.  或直接使用jQuery();

	如果jQuery在后，仍想使用其他库的$，可以这样：
	1.  jQuery.noConflict();  //自行了断，把自己的所有权剔除。
			然后 $$ = jQuery; 然后使用$$();作为jQuery的$