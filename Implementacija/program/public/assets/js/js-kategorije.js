$(document).ready(function () {
	$('.brisanje-kategorije').click(function () {
		var element = $(this);
		var kategorija = element.data().id;
		
		$.post("http://localhost:8080/kategorija/brisi", {id: kategorija}, function(result){
	        element.closest('tr').fadeOut(400).delay(400).remove();
	    });
	});

	$('#dodaj-novu-kategoriju').on('click', function () {

		$.post('http://localhost:8080/moderator/kategorije/dodaj', { 
			naziv_kategorije: $('#naziv-kategorije').val(), 
			potkategorije: $('#potkategorije').val(), 
			opis_kategorije: $('#opis-kategorije').val() })
		.done(function () {
			alert('Kategorija uspješno dodana!');
			location.reload();
		})
		.fail(function (xhr, textStatus, errorthrown) {
			if(xhr.status == 406)
				alert('Kategorija sa istim nazivom već postoji!');
			else
				alert('Došlo je do greške, statusni kod greške: ' + xhr.status);
		});
	});
});