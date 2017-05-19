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
  this.route('homekorisnik');


  this.route('iznajmljivanje');
  this.route('addmoderator');
  this.route('addadministrator');
  this.route('administracija', function() {
    this.route('clanovi');
    this.route('moderatori');
  });

  this.route('clan', function() {
    this.route('literatura');
    this.route('pocetna');
    this.route('faq');
    this.route('odjava');
  });
});

export default Router;
