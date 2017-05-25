//import Ember from 'ember';
import BaseRoute from './base-route';

// Limits access to this route only to authenticated users
export default BaseRoute.extend({
    beforeModel: function() {
        if (!this.get('session.isAuthenticated')) {
            return this.transitionTo("login");
        }
    }
});