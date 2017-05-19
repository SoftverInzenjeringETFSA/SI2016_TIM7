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
<<<<<<< HEAD
  this.route('home');
  this.route('iznajmljivanje');
=======
   this.route('home');
      this.route('homekorisnik');
>>>>>>> 13bfc97448ba04f3f10d48ebc36b3bfc4ec0b8e0

  this.route('iznajmljivanje');
  this.route('addmoderator');
  this.route('addadministrator');
  this.route('administracija', function() {
    this.route('clanovi');
    this.route('moderatori');
  });

  this.route('clan', function() {
    this.route('literatura');
  });
});

export default Router;
