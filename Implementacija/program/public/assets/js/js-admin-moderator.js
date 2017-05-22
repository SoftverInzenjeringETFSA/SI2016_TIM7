$(document).ready(function () {
	$('.brisanje-moderatora').click(function () {
		var element = $(this);
		var moderator = element.data().id;
		
		$.post("http://localhost:8080/administracija/moderatori/brisi", {id: moderator}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});
});