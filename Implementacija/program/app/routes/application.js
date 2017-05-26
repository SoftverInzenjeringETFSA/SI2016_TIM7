import Ember from 'ember';

export default Ember.Route.extend({
    session: Ember.inject.service(),

  actions:{
  
        invalidateSession: function() {
            this.get('session').invalidate();
        },
    }

});