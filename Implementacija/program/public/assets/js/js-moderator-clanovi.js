$(document).ready(function () {
	$('.brisanje-clana').click(function () {
		var element = $(this);
		var clan = element.data().id;
		
		$.post("http://localhost:8080/moderator/clanovi/brisi", {id: clan}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});
});