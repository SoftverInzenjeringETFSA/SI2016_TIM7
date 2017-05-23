import Ember from 'ember';

export default Ember.Controller.extend({
    flashMessages: Ember.inject.service(),

    authenticate: function(credentials) {
        var authenticator = 'authenticator:jwt';

        return this.get('session').authenticate(authenticator, credentials);
    },

    actions: {
        login: function(credentials, doRedirect) {
            const flashMessages = Ember.get(this, 'flashMessages');
            var self = this;
            this.authenticate(credentials).then(function(value) {
                if (doRedirect) {
                    self.transitionToRoute('index');
                }
                flashMessages.success("Uspješno prijavljen!");
            }.bind(doRedirect), function(reason) {
                flashMessages.danger("Pogrešni podaci.");
            });
        },

        loginNormal: function() {
            var credentials = this.getProperties('identification', 'password');//properties
            this.send('login', credentials, true);
        },

        loginWithoutRedirect: function(credentials) {
            this.send('login', credentials, false);
        }
    }
});