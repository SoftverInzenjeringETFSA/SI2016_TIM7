import BaseService from './base-service';
import literatura from '../models/literatura';

export default BaseService.extend({
    getById: function(id) {

        var literatura = literatura.create({});
        this.ajax({ url: "http://localhost:8080/clan/literatura/get?id="+id, type: "GET"}).then(function(data) {
            literatura.setProperties(data);
        });
        
        return literatura;
    }
});