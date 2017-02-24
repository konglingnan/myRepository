//类(原型对象)其实也是对象，它实际上是Function类的一个实例

function Person(name, age){
	
	this.name=name;//公有，可在外部调用
	var age=age;//私有,只能在类内使用，不可调用

	this.showGY=function(){//公有
		document.writeln(this.name+" "+this.age);
	}
	function showSY(){//私有
		document.writeln(this.name+" "+this.age);
	}
}
