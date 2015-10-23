/**
 * 
 */

function retrieveShots() {
	var url = '/shots';
	$("#shotsBlock").load(url);
}
function retrieveShotsBy1000() {
	var url = '/shotsBy1000';
	$("#shotsBy1000Block").load(url);
}
