$(document).ready(function () {
	$('.brisanje-moderatora').click(function () {
		var element = $(this);
		var moderator = element.data().id;
		
		$.post("http://localhost:8080/administracija/moderatori/brisi", {id: moderator}, function(result){
	        element.closest('tr').fadeOut(300);
	    });
	});

	$('#dodaj-novog-moderatora').on('click', function () {


		var sigurnosniId = $('#sigurnosniId').val();
		var idformat = sigurnosniId.match(/^\d+$/);

		var adresa = $('#adresa').val().length;
		var grad = $('#grad').val().length;

		var email = $('#email').val();
		var emailformat = email.match(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);

		if (adresa > 0 && grad > 0 && emailformat != null && idformat != null) {
			$("#eerror").css('display', 'none');
			$("#inputerror").css('display', 'none');
			$("#nerror").css('display', 'none');

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
		}
		else {

			if (grad == 0 || adresa == 0 || sigurnosniId.length == 0 || email.length == 0) {
				$("#inputerror").css('display', 'block');
				$("#eerror").css('display', 'none');
				$("#nerror").css('display', 'none');
			}
			else if (idformat == null && emailformat == null) {
				$("#inputerror").css('display', 'none');
				$("#eerror").css('display', 'block');
				$("#nerror").css('display', 'block');
			}
			else if (idformat != null && emailformat == null) {
				$("#inputerror").css('display', 'none');
				$("#eerror").css('display', 'block');
				$("#nerror").css('display', 'none');
			}
			else if (idformat == null && emailformat != null) {
				$("#inputerror").css('display', 'none');
				$("#eerror").css('display', 'none');
				$("#nerror").css('display', 'block');
			}
			else {
				$("#eerror").css('display', 'none');
				$("#inputerror").css('display', 'none');
				$("#nerror").css('display', 'none');
		}


		}
	});
});