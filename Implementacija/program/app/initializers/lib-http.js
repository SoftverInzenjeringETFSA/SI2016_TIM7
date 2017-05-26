export function initialize(application) 
{
  application.inject('route', 'lib-http', 'service:lib-http');
  application.inject('controller', 'lib-http', 'service:lib-http');
  application.inject('component', 'lib-http', 'service:lib-http');
  application.inject('component', 'router', 'router:main');
}

export default {
  name: 'lib-http',
  initialize
};