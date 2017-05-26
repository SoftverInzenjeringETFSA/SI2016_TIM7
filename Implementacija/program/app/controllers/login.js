import Ember from 'ember';
import osoba from '../models/osoba';

export default Ember.Controller.extend({
    /*userService: Ember.inject.service(),
    isToSAccepted: Ember.computed.not('isToSCheckboxChecked'),
     store: Ember.inject.service(),
    session: Ember.inject.service(),
    model: {},

    
    
    actions: {

        login: function() {

            this.get('session').authenticate('authenticator:application', this.model, (data) => {
                    console.log(data);
                     this.set('model.korisnicko_ime', '');
                     this.set('model.sifra', '');
                     
                     this.transitionToRoute('administracija');
                })
                .catch(reason => {
                    Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                    this.set('authenticationError', this.errorMessage || reason);
                });
          }

       }
    */
    
});