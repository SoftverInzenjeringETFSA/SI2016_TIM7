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
  this.route('registermember');
   this.route('home');
  this.route('iznajmljivanje');

  this.route('administracija', function() {
    this.route('clanovi');
  });
});

export default Router;
