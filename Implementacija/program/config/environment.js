/* eslint-env node */

module.exports = function(environment) {
  var ENV = {
    modulePrefix: 'program',
    environment: environment,
    rootURL: '/',
    locationType: 'auto',
    EmberENV: {
      FEATURES: {
        // Here you can enable experimental features on an ember canary build
        // e.g. 'with-controller': true
      },
      EXTEND_PROTOTYPES: {
        // Prevent Ember Data from overriding Date.parse.
        Date: false
      }
    },

    APP: {
      // Here you can pass flags/options to your application instance
      // when it is created
    }
  };

  ENV['ember-simple-auth'] = {
        authorizer: 'authorizer:token',
        baseURL: '',
        crossOriginWhitelist: ['http://localhost:8080']
    };

    ENV['ember-simple-auth-token'] = {
        refreshAccessTokens: false,
        authorizer: 'authorizer:token',
        identificationField: 'username',
        serverTokenEndpoint: ''
    };

  if (environment === 'development') {
    ENV.host = 'http://localhost:8080';        
    ENV.apiHost = "http://localhost:8080";
  }

  if (environment === 'test') {
    // Testem prefers this...
    ENV.locationType = 'none';

    // keep test console output quieter
    ENV.APP.LOG_ACTIVE_GENERATION = false;
    ENV.APP.LOG_VIEW_LOOKUPS = false;

    ENV.APP.rootElement = '#ember-testing';
  }

  if (environment === 'production') {

  }

    ENV['ember-simple-auth'].baseURL = ENV.apiHost;
    ENV['ember-simple-auth-token'].serverTokenEndpoint = `${ENV.apiHost}/login`;

    return ENV;
};
