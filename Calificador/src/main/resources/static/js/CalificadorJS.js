function playButtonClickSound() {
	var audio = document.getElementsByTagName("audio")[0];
	audio.load();
	audio.play();
}