import Ember from 'ember';
import $ from 'jquery';
import config from '../config/environment';

export default Ember.Service.extend({
    session: Ember.inject.service('session'),

    ajax: function(params) {
        var token = this.get('session.data.authenticated.token');
        if(token !== undefined) {
            params.beforeSend = function(request) {
                request.setRequestHeader("Authorization", "Bearer " + token);
            };
        }
        
        params.url = `${config.apiHost}/${params.url}`;
        params.contentType = "application/json";
        return $.ajax(params);
    }
});