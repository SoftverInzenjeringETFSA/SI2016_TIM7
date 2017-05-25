import Ember from 'ember';

export default Ember.Controller.extend({
    flashMessages: Ember.inject.service(),
    session: Ember.inject.service('session'),
    collapsedBool: false,
    collapsedStr: "collapse navbar-collapse",

    authenticate: function(credentials) {
        var authenticator = 'authenticator:jwt';

        return this.get('session').authenticate(authenticator, credentials);
    },

    actions: {
        login: function(credentials, doRedirect) {
            const flashMessages = Ember.get(this, 'flashMessages');
            var self = this;

            this.authenticate(credentials).then(function() {
                if (doRedirect) {
                    self.transitionToRoute('/');
                }
                flashMessages.success("Uspješno prijavljen!");
            }.bind(doRedirect), function() {
                flashMessages.danger("Pogrešni podaci.");
            });
        },

        loginNormal: function() {
            var credentials = this.getProperties('identification', 'password');
            this.send('login', credentials, true);
        },

        loginWithoutRedirect: function(credentials) {
            this.send('login', credentials, false);
        },

        logout(){
            this.get('session').invalidate();
        }
    }
});