$(document).ready(function () {
	$('#pretraga-literature').on('keyup', function () {
		var query = $(this).val();
		
		$.get('http://localhost:8080/clan/pretraga/' + query, function (result) {
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
						      +	'<a data-id="{{literatura.id}}" class="btn btn-default download-literature" title="Preuzmi">'
			            	  +'	<span class="glyphicon glyphicon-download-alt"></span>'
			          		   +'</a>'
						      +'</td>'
						+'</tr>');
				});
		});
	});
});