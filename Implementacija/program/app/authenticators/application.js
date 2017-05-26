import Ember from 'ember';
import Base from 'ember-simple-auth/authenticators/base';

const {RSVP: { Promise }} = Ember;

export default Base.extend({
    libHttp: Ember.inject.service('lib-http'),

    restore(data) {
        return new Promise((resolve, reject) => {
            if (!Ember.isEmpty(data.token)) {
                resolve(data);
            } else {
                reject();
            }
        });
    },

    authenticate(credentials, callback) {
        return this.get('libHttp').post('auth', credentials, (resp) => {
            if (callback) {
                callback(resp);
            }

            return resp;
        });
    },

    invalidate(data) {
        return Promise.resolve(data);
    }
    
});
