$(document).ready(function () {
	
	$.get('http://localhost:8080/administracija/osoba', function (result) {
		var selectOption = $('.select-korisnicko-ime');

		$.each(result, function (i, val) {
			if (val['tip'] =="Clan"){
				selectOption.append('<option value="'+val['id']+'" data-id="' + val['id'] + '">'+ val['korisnicko_ime'] + '</option>');}
		});
	});


	$('#dodaj-novu-osobu').on('click', function () {
			var korisnicko_ime = $('#korisnicko-ime').val().length;
			var ime = $('#ime').val().length;
			var prezime = $('#prezime').val().length;
			var sifra = $('#sifra').val().length;


			if (korisnicko_ime > 0 && ime >= 2 && prezime >= 2 && sifra >= 8) {
				$("#inputerror").css('display', 'none');
				$("#perror").css('display', 'none');
				$.post('http://localhost:8080/administracija/osoba/dodaj', { korisnicko_ime: $('#korisnicko-ime').val(), ime: $('#ime').val(), prezime: $('#prezime').val(), sifra: $('#sifra').val(), tip: $('#tip').val() })
				.done(function () {
					alert('Osoba uspješno dodana');
					location.reload();
				})
				.fail(function (xhr, textStatus, errorthrown) {
					if(xhr.status == 406)
						alert('Osoba sa tim korisničkim imenom već postoji!');
					else
						alert('Došlo je do greške, statusni kod greške: ' + xhr.status);
				});
		}
	else {

		if ((korisnicko_ime == 0 || ime < 2 || prezime < 2) && sifra < 8) {
			$("#inputerror").css('display', 'block');
			$("#perror").css('display', 'none');
		}
		else if ((korisnicko_ime > 0 && ime > 2 && prezime > 2) && sifra < 8) {
			$("#inputerror").css('display', 'none');
			$("#perror").css('display', 'block');
		}
		else {
			$("#inputerror").css('display', 'none');
			$("#perror").css('display', 'none');	
		}
	}
	
	});
});