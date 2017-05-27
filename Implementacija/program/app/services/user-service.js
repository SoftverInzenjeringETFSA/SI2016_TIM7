import Ember from 'ember';
import BaseService from './base-service';
import Osoba from '../models/osoba';

export default BaseService.extend({
	
    store: function(korisnik) {
        var korisnici = [];
        	this.ajax({ url: 'osoba/store', type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });
    
        return true;
    },
    
});