function ping() {
}

function autoCloseGraciasModal() {
	setTimeout(hideGraciasModal, 2000);
}

function hideGraciasModal() {
	/* $('#gracias').modal('hide'); */
	window.location.replace("/gracias");
}

function shot(event) {
	var button = $(event.relatedTarget);
	var origin = button.data("whatever");
	$("#main").load(s);
}

function bootstrapSoundLoad() {

	ion.sound({
		sounds : [ {
			name : "beer_can_opening"
		}, {
			name : "bell_ring"
		}, {
			name : "branch_break"
		}, {
			name : "button_click"
		} ],

		path : "sounds/",
		preload : true,
		multiplay : true,
		volume : 0.9
	});
}

function playButtonClickSound() {
	ion.sound.play("button_click");
}