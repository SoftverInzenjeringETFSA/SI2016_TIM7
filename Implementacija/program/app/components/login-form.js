import Ember from 'ember';

export default Ember.Component.extend({
    store: Ember.inject.service(),
    session: Ember.inject.service(),
    isToSAccepted: false,

    model: {},
    errorMessage: '',


    actions: {
     
       login() {
            this.get('session').authenticate('authenticator:application', this.model, (data) => {
                    console.log(data);
                   Ember.set(this, 'errorMessage', '');
                     this.set('model.korisnicko_ime', '');
                     this.set('model.sifra', '');
                     this.set('model.id', '');
                    
                    this.get('router').transitionTo('index');
                })
                .catch(reason => {
                    Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                    this.set('authenticationError', this.errorMessage || reason);
                });
        },

        logout()
        {
              this.get('session').invalidate();
              this.get('router').transitionTo('index');

        }
    }
});