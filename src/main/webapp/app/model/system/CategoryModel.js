Ext.define('plat.model.system.CategoryModel', {
    extend: 'Ext.data.Model',
    fields: ['id','code','text','pid','leaf','description','clazz']
//    fields: [{
//        name: 'task',
//        type: 'string'
//    }, {
//        name: 'user',
//        type: 'string'
//    }, {
//        name: 'duration',
//        type: 'float'
//    }, {
//        name: 'done',
//        type: 'boolean'
//    }]
});