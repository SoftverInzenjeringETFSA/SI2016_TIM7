$(document).ready(function () {
	
	$.get('http://localhost:8080/moderator/kategorije', function (result) {
		var selectOption = $('.select-kategorija');
				
		$.each(result, function (i, val) {
			selectOption.append('<option value="'+val['id']+'" data-id="' + val['id'] + '">'+ val['naziv_kategorije'] + '</option>');
		});
	});

	$('#filter-kategorija').on('change', function () {
		if($(this).val() != 0)
			$.get('http://localhost:8080/moderator/literatura/kategorija/' + $(this).val(), function (result) {
				var literaturaLista = $('#literatura-lista');
				literaturaLista.empty();

				$.each(result, function (i, val) {
					literaturaLista.append('<tr>'
						      +'<td>' + val['naziv_literature'] + '</td>'
						      +'<td>' + val['autor_literature'] + '</td>'
						      +'<td>' + val['izdavac'] + '</td>'
						      +'<td>' + val['izdavac'] + '</td>'
						      +'<td>' + val['kategorija']['naziv_kategorije'] + '</td>'
						      +'<td>' + val['kategorija']['potkategorija'] + '</td>'
						      +'<td>' 
						      +	'<a data-id="{{literatura.id}}" class="btn btn-default download-literature" title="Mogucnost preuzimanja">'
			            	  +'	<span class="glyphicon glyphicon-download-alt"></span>'
			          		   +'</a>'
								+'<a data-id="'+val['id']+'" class="btn btn-default izmjena-literature" title="Izmjena">' 
						        +'    <span class="glyphicon glyphicon-pencil"></span>'
						        +'  </a>'
						        +'  <a data-id="' + val['id'] + '" class="btn btn-default brisanje-literature" title="Brisanje">'
						        +'    <span class="glyphicon glyphicon-remove"></span>'
						        +'  </a>'
						      +'</td>'
						+'</tr>');
				});
			});
		else location.reload(true);
	});

	$('.brisanje-literature').on('click', function () {
		var element = $(this);
		var literatura = element.data().id;
		
		$.post("http://localhost:8080/literatura/brisi", {id: literatura}, function(result){
	        element.closest('tr').fadeOut(400).delay(400).remove();
	    });
	});

	$('#dodaj-novu-literaturu').on('click', function () {

		$.post('http://localhost:8080/moderator/literatura/dodaj', { 
			kategorija: $('#kategorija').val(),
			autor_literature: $('#autor-literature').val(), 
			naziv_literature: $('#naziv-literature').val(), 
			izdavac: $('#izdavac').val(), 
			godina_izdavanja: $('#godina-izdavanja').val(), 
			broj_strana: $('#broj-strana').val(),
			komentar: $('#komentar').val(),
			mogucnost_preuzimanja: $('#mogucnost-preuzimanja').val(),
			datum_unosa: $('#datum-unosa').val() })
		.done(function () {
			alert('Literatura uspješno dodana!');
			location.reload();
		})
		.fail(function (xhr, textStatus, errorthrown) {
			if(xhr.status == 406)
				alert('Literatura sa istim nazivom već postoji!');
			else
				alert('Došlo je do greške, statusni kod greške: ' + xhr.status);
		});
	});
});