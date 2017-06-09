$(document).ready(function () {
	$('.brisanje-admina').click(function () {
		var element = $(this);
		var admin = element.data().id;
		
		$.post("http://localhost:8080/administracija/administratori/brisi", {id: admin}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});

	$('#dodaj-novog-administratora').on('click', function () {

		var sigurnosniId = $('#sigurnosniId').val();
		var idformat = sigurnosniId.match(/^\d+$/);


		if (idformat != null && sigurnosniId.length > 0) {
			$("#nerror").css('display', 'none');

			$.post('http://localhost:8080/administracija/administratori/dodaj', { korisnicko_ime: $('#korisnicko-ime').val(), sigurnosniId: $('#sigurnosniId').val() })
			.done(function () {
				alert('Novi administrator uspješno dodan');
				location.reload();
			})
			.fail(function (xhr, textStatus, errorthrown) {
				if(xhr.status == 406)
					alert('Administrator već postoji!');
				else
					alert('Došlo je do greške, statusni kod greške: ' + xhr.status);
			});
		}
		else {
			if (idformat == null) 
				$("#nerror").css('display', 'block');

			else 
				$("#nerror").css('display', 'none');


		}
	});
});