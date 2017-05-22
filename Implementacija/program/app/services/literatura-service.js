import BaseService from './base-service';
import Literatura from '../models/literatura';

export default BaseService.extend({
    getById: function(id) {
        var literatura = literatura.create({});
        this.ajax({ url: "http://localhost:8080/clan/literatura/get?id="+id, type: "GET"}).then(function(data) {
        	console.log("data: ");
        	console.log(data);
        	literatura.setProperties(data);
        	console.log("created: ");
        	console.log(literatura);

        });

        return literatura;
    }

});