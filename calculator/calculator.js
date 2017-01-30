
	function $(id){
		return document.getElementById(id);
	}

	var state = "off";
	var operator = "";
	var firstNumber = 0;
	var results = new Array();
	var i = 0;
	function clickNumber(number){
		if(state == "off"){
			$("showArea").value="";
		}
		var show = $("showArea");
		show.value = show.value+number;
		state = "on";
	}

	function clickBackspace(){
		var show = $("showArea");
		show.value = show.value.substr(0, (show.value.length-1));
		show.value=parseFloat(show.value);
		if (isNaN(show.value)) {
			show.value=0;
		}
	}

	function clickOpposite(){
		var show = $("showArea");
		show.value = 0-parseFloat(show.value);
		if (isNaN(show.value)) {
			show.value=0;
		}
	}

	function clickClear(){
		operator = "";
		firstNumber = 0;
		$("showArea").value=0;
		state = "off";
	}

	function calculate(oper){
		operator = oper;
		firstNumber = parseFloat($("showArea").value);
		state = "off";
	}

	function result(){
		var secondNumber = parseFloat($("showArea").value);
		var resultNumber = 0;
		if(operator == "+"){
			resultNumber = firstNumber + secondNumber;
		}
		else if(operator == "-"){
			resultNumber = firstNumber - secondNumber;
		}
		else if(operator == "*"){
			resultNumber = firstNumber * secondNumber;
		}
		else if(operator == "/"){
			resultNumber = firstNumber / secondNumber;
		}
		else{
			$("showArea").value = 0;
		}
		$("showArea").value = resultNumber;
		results[i++] = resultNumber;
		operator = "";
		firstNumber = resultNumber;
		state = "off";
	}

	function showResults(){
			if(results){
				$("showArea").value = "";
				for(i = 0; i<results.length; i++){
					$("showArea").value += results[i]+"\n\t"
				}
			}
		state = "off";
	}
