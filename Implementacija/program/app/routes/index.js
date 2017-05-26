import Ember from 'ember';

export default Ember.Route.extend({
	userService: Ember.inject.service(),

  model: function() {
    return Ember.RSVP.hash({
      users: this.get('userService').all()
    });
  },
	session: Ember.inject.service(),

	beforeModel(transition) {
	

		if (!this.get('session.isAuthenticated')) {
			this.transitionTo('login');
		}
		else if (this.get('session.data.authenticated.korisnik.tip') == "Administrator") {
			this.transitionTo('administracija');	
		}
		else if (this.get('session.data.authenticated.korisnik.tip') == "Moderator") {
			this.transitionTo('moderator');
		}
		else if (this.get('session.data.authenticated.korisnik.tip') == "Clan") {
			this.transitionTo('clan');
		}
		else {
			/*var previousTransition = this.get('previousTransition');
			if (previousTransition) {
				this.set('previousTransition', null);
				previousTransition.retry();
			} else {
				this.transitionTo('index');
			}
		*/}

	}


});