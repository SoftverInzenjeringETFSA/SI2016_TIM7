import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('about');
  this.route('pretraga');
  this.route('kategorije');
  this.route('profil');
  this.route('faq');
  this.route('login');
  this.route('register')
  this.route('iznajmljivanje');

  this.route('administracija', function() {
    this.route('clan', function() {
      this.route('show', { path: '/show/:id' });
    });
  });
});

export default Router;
