$(document).ready(function () {
	
	$.get('http://localhost:8080/administracija/osoba', function (result) {
		var selectOption = $('.select-korisnicko-ime');

		$.each(result, function (i, val) {
			if (val['tip'] =="Clan"){
				selectOption.append('<option value="'+val['id']+'" data-id="' + val['id'] + '">'+ val['korisnicko_ime'] + '</option>');}
		});
	});
});