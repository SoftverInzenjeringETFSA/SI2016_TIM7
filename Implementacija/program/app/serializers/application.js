
import DS from 'ember-data';

export default DS.RESTSerializer.extend({
  normalizeResponse(store, primaryModelClass, hateoasPayload, id, requestType) {
    let restPayload = {};
    hateoasPayload.meta = {};
    hateoasPayload.meta.links = hateoasPayload.links;
    delete hateoasPayload.links;
    restPayload[primaryModelClass.modelName] = hateoasPayload;
    return this._super(store, primaryModelClass, restPayload, id, requestType);
  }
});