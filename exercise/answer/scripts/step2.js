var array = [{"name":"待接单","status":"WAIT_ACCEPT","isShadowed":true},{"name":"待发货","status":"WAIT_DELIVER","isShadowed":true,"isCurrentStatus":true},{"name":"验货入库","status":"STOCK_IN"},{"name":"已完成","status":"DELIVERED"}];
initState(array);

// 箭头组封装函数开始
// 箭头组主函数开始
function initState(array) {
	// 数组为空 返回
	if(array.length == 0) return;
	var step2 = document.getElementById('step2');
	var ul = document.createElement('ul');
	ul.setAttribute('class', 'state');
	// 当数组内有且仅有一个对象
	if(array.length == 1) {
		var stopped = document.createElement('li');
		stopped.innerHTML = '已中止';
		stopped.setAttribute('class', 'stopped');
		ul.appendChild(stopped);
	} 
	// 当数组内有不止一个对象
	else {
		ul.appendChild(createNode('start', array[0]));
		for(var i=1; i<array.length-1; i++) {
			ul.appendChild(createNode('undone', array[i]));
		}
		ul.appendChild(createNode('end', array[array.length-1]));
	}
	step2.appendChild(ul);
}
// 箭头组主函数结束
// 创建node函数开始
function createNode(type, obj) {
	var node = document.createElement('li');
	node.innerHTML = obj.name;
	if(obj.isShadowed == true) {
		node.setAttribute('class', 'shadowed');
	}
	if(obj.isCurrentStatus == true) {
		node.setAttribute('class', 'currentStatus');
	}
	node.className += ' '+type;
	if(type != 'start') {
		var oi = document.createElement('i');
		node.appendChild(oi);
	}
	return node;
}
// 创建node函数结束
// 箭头组封装函数结束