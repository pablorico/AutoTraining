function ping() {}

function autoCloseGraciasModal() {
	setTimeout(hideGraciasModal,2000);
}

function hideGraciasModal(){
    /*$('#gracias').modal('hide');*/    
    window.location.replace("/gracias");
} 

function shot(event) {
	var button = $(event.relatedTarget);
	var origin = button.data("whatever");
	$("#main").load(s);
}