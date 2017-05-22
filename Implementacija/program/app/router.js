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
    this.route('clanovi');
    this.route('moderatori');
    this.route('administratori');
    this.route('osoba');
  });

  this.route('moderator', function() {
    this.route('clanovi');
    this.route('kategorije');
    this.route('literatura');
  });

  this.route('clan', function() {
    this.route('pocetna');
    this.route('literatura');
  });
});

export default Router;
