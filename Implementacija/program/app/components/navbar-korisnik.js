import Ember from 'ember';
import Osoba from '../models/osoba';

export default Ember.Component.extend({
    store: Ember.inject.service(),
    session: Ember.inject.service(),
    isToSAccepted: false,

    model: {},
    errorMessage: '',


    actions: {
     
        logout()
        {
              this.get('session').invalidate();
              this.get('router').transitionTo('index');

        }
    }
});