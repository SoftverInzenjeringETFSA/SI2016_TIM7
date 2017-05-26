import Ember from 'ember';

export default Ember.Controller.extend({
	literaturaService: Ember.inject.service('literatura-service'),
    naziv_literature: "",

    izmijeni: function(literatura) {

        this.get('literaturaService').update(literatura, literatura.id).then(x => {}).catch(x => {});
        //set
    },

    actions: {
        izmijeni: function(index){
            let _lit = this.get("literatura");
            let literatura = _lit[index];
            this.izmijeni(literatura);
        }    
    }
});