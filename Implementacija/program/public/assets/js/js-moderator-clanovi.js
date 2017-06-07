$(document).ready(function () {
	$('.brisanje-clana').click(function () {
		var element = $(this);
		var clan = element.data().id;
		
		$.post("http://localhost:8080/moderator/clanovi/brisi", {id: clan}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});

	$('#dodaj-novog-clana').on('click', function () {

		$.post('http://localhost:8080/administracija/clanovi/dodaj', { 
			broj_clanske_karte: $('#broj_clanske_karte').val(), 
			datum_rodjenja: $('#datum_rodjenja').val(), 
			adresa: $('#adresa').val(),
			mjesto_stanovanja: $('#mjesto_stanovanja').val(), 
			broj_telefona: $('#broj_telefona').val(), 
			ustanova: $('#ustanova').val(), 
			email: $('#email').val(), 
			korisnicko_ime: $('#korisnicko-ime').val() })
		.done(function () {
			alert('Novi član uspješno dodan!');
			location.reload();
		})
		.fail(function (xhr, textStatus, errorthrown) {
			if(xhr.status == 406)
				alert('Osoba sa tim korisničkim imenom je već član biblioteke!');
			else
				alert('Došlo je do greške, statusni kod greške: ' + xhr.status);
		});
	});
});