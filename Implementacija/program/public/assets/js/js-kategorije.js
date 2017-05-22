$(document).ready(function () {
	$('.brisanje-kategorije').click(function () {
		var element = $(this);
		var kategorija = element.data().id;
		
		$.post("http://localhost:8080/kategorija/brisi", {id: kategorija}, function(result){
	        element.closest('tr').fadeOut(400).delay(400).remove();
	    });
	});

});