import Ember from 'ember';
import $ from 'jquery';

export default Ember.Service.extend({
    
    ajax: function(params) {
        params.contentType = "application/json";
        
        return $.ajax(params);
    }
});