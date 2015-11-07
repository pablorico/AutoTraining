/**
 * 
 */

function retrieveIglesias(s) {
	var url = '/'+s;
	$("#iglesias").load(url);
}
function retrieveNavBarRight(s) {
	var url = '/'+s;
	$("#navBarRight").load(url);
}
