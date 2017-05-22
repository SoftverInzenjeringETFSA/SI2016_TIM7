$(document).ready(function () {
	$('.brisanje-admina').click(function () {
		var element = $(this);
		var admin = element.data().id;
		
		$.post("http://localhost:8080/administracija/administratori/brisi", {id: admin}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});
});