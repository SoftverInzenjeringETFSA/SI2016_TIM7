import BaseModel from './base-model';

var _modelProperties = ['id', 'naziv_literature'];//, 'izdavac', 'godina_izdavanja', 'broj_strana', 'mogucnost_preuzimanja','datum_povratka'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});;