$(document).ready(function () {
	$('.brisanje-clana').click(function () {
		var element = $(this);
		var clan = element.data().id;
		
		$.post("http://localhost:8080/administracija/clanovi/brisi", {id: clan}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});

	$('#dodaj-novog-clana').on('click', function () {

		var email = $('#email').val();
		var adresa = $('#adresa').val();
		var broj_clanske_karte = $('#broj_clanske_karte').val().length;
		var datum_rodjenja = $('#datum_rodjenja').val().length; 
		var mjesto_stanovanja = $('#mjesto_stanovanja').val().length; 
		var broj_telefona = $('#broj_telefona').val();
		var ustanova = $('#ustanova').val().length; 

		var emailformat = email.match(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
		var format = broj_telefona.match(/\d+/g);

		if (adresa.length >= 2 && emailformat != null && broj_clanske_karte > 0 && datum_rodjenja > 0 
			&& mjesto_stanovanja > 0 && broj_telefona.length > 0 && ustanova > 0 && format!= null) {
			$("#eerror").css('display', 'none');
			$("#aerror").css('display', 'none');
			$("#inputerror").css('display', 'none');

			$.post('http://localhost:8080/administracija/clanovi/dodaj', { 
				korisnicko_ime: $('#korisnicko-ime').val(),
				broj_clanske_karte: $('#broj_clanske_karte').val(), 
				datum_rodjenja: $('#datum_rodjenja').val(), 
				adresa: $('#adresa').val(),
				mjesto_stanovanja: $('#mjesto_stanovanja').val(), 
				broj_telefona: $('#broj_telefona').val(), 
				ustanova: $('#ustanova').val(), 
				email: $('#email').val() })
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
	}

	else {

		if (broj_clanske_karte == 0 || datum_rodjenja == 0 
			|| mjesto_stanovanja == 0 || broj_telefona.length == 0 || ustanova == 0) {

			$("#inputerror").css('display', 'block');
			$("#eerror").css('display', 'none');
			$("#aerror").css('display', 'none');
			$("#nerror").css('display', 'none');

		}
		else if (format == null && emailformat == null &&  adresa.length < 2) {
			$("#nerror").css('display', 'block');
			$("#aerror").css('display', 'block');	
			$("#eerror").css('display', 'block');
			$("#inputerror").css('display', 'none');
		}
		else if (adresa.length < 2 && emailformat == null && format != null){
			$("#aerror").css('display', 'block');	
			$("#eerror").css('display', 'block');
			$("#inputerror").css('display', 'none');
			$("#nerror").css('display', 'none');
		}
		else if (emailformat == null && format == null && adresa.length >= 2) {
			$("#eerror").css('display', 'block');
			$("#nerror").css('display', 'block');
			$("#aerror").css('display', 'none');
			$("#inputerror").css('display', 'none');			
		}
		else if (adresa.length < 2 && emailformat != null && format == null){
			$("#aerror").css('display', 'block');	
			$("#eerror").css('display', 'none');
			$("#inputerror").css('display', 'none');
			$("#nerror").css('display', 'block');
		}
		else if (adresa.length >= 2 && emailformat != null && format == null){
			$("#eerror").css('display', 'none');
			$("#nerror").css('display', 'block');
			$("#aerror").css('display', 'none');
			$("#inputerror").css('display', 'none');
		}
		else if (adresa.length >= 2 && emailformat == null && format != null){
			$("#eerror").css('display', 'block');
			$("#nerror").css('display', 'none');
			$("#aerror").css('display', 'none');
			$("#inputerror").css('display', 'none');
		}
		else if (adresa.length < 2 && emailformat != null && format != null){
			$("#eerror").css('display', 'none');
			$("#nerror").css('display', 'none');
			$("#aerror").css('display', 'block');
			$("#inputerror").css('display', 'none');
		}
		else {
			$("#eerror").css('display', 'none');
			$("#aerror").css('display', 'none');
			$("#inputerror").css('display', 'none');
			$("#nerror").css('display', 'none');
		}
	}

	});
});