import Ember from 'ember';
import ENV from '../config/environment';

const { RSVP: { Promise }, $: { ajax }, run } = Ember;
const { isEmpty, get, assign, RSVP } = Ember;

export default Ember.Service.extend({
    _innerCreateMethod(route, data, httpRequest, happyPath, unhappyPath) {
        let requestOptions = {
            url: `${ENV.APP.apiUri}/${route}`,
            contentType: 'application/json; charset=utf-8',
            type: httpRequest,
            dataType: 'json'
        };

        if (data) {
            requestOptions.data = JSON.stringify(data);
        }

        return new RSVP.Promise((resolve, reject) => {
            ajax(requestOptions).then((response) => {
                run(() => {
                    if (happyPath) {
                        return resolve(happyPath(response));
                    }
                    else {
                        return resolve();
                    }
                });
                }, (error) => {
                    run(() => {
                        if (unhappyPath) {
                            return unhappyPath(error);
                        }

                        return reject(error);
                    });
            });
        });
    },

    get(route, data, happyPath, unhappyPath) {
        return this._innerCreateMethod(route, null, 'GET', happyPath, unhappyPath);
    },

    post(route, data, happyPath, unhappyPath) {
        return this._innerCreateMethod(route, data, 'POST', happyPath, unhappyPath);
    }
});