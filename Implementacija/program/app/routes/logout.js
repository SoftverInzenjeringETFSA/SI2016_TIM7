import Ember from 'ember';

export default Ember.Route.extend({
	userService: Ember.inject.service(),
	session: Ember.inject.service(),

	beforeModel(transition) {
	
		if (this.get('session.isAuthenticated')) 
		{
			this.get('session').invalidate();
			this.get('router').transitionTo('index');
		}
	}
});
