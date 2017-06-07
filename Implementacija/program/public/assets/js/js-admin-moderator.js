$(document).ready(function () {
	$('.brisanje-moderatora').click(function () {
		var element = $(this);
		var moderator = element.data().id;
		
		$.post("http://localhost:8080/administracija/moderatori/brisi", {id: moderator}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});

	$('#dodaj-novog-moderatora').on('click', function () {

		$.post('http://localhost:8080/administracija/moderatori/dodaj', { 
			korisnicko_ime: $('#korisnicko-ime').val(), 
			sigurnosniId: $('#sigurnosniId').val(), 
			adresa: $('#adresa').val(),
			grad: $('#grad').val(), 
			email: $('#email').val() })
		.done(function () {
			alert('Novi moderator uspješno dodan');
			location.reload();
		})
		.fail(function (xhr, textStatus, errorthrown) {
			if(xhr.status == 406)
				alert('Moderator već postoji!');
			else
				alert('Došlo je do greške, statusni kod greške: ' + xhr.status);
		});
	});
});