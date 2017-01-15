// cldropdown Menu
var cldropdown = document.querySelectorAll('.cldropdown');
var cldropdownArray = Array.prototype.slice.call(cldropdown,0);
cldropdownArray.forEach(function(el){
	var button = el.querySelector('a[data-toggle="cldropdown"]'),
			menu = el.querySelector('.cldropdown-menu'),
			arrow = button.querySelector('i.icon-arrow');

	button.onclick = function(event) {
		if(!menu.hasClass('show')) {
			menu.classList.add('show');
			menu.classList.remove('hide');
			arrow.classList.add('open');
			arrow.classList.remove('close');
			event.preventDefault();
		}
		else {
			menu.classList.remove('show');
			menu.classList.add('hide');
			arrow.classList.remove('open');
			arrow.classList.add('close');
			event.preventDefault();
		}
	};
})

Element.prototype.hasClass = function(className) {
    return this.className && new RegExp("(^|\\s)" + className + "(\\s|$)").test(this.className);
};