Ext.define('plat.store.system.CategoryStore', {
    extend: 'Ext.data.TreeStore',
    model:'plat.model.system.CategoryModel',
    
//    proxy: {
//        type: 'ajax',
//        url: 'resources/data/tree/treegrid2.json'
//    },
//    folderSort: true
    proxy: {
        type: 'ajax',
     	actionMethods: {  
        	read: 'GET'
            },
        api:{  
		    read:'category/findAll',  
		    create:'category/add',  
		    destroy:'category/delete',  
		    update:'category/update'  
      		},  
		reader:{  
      		type: 'json'
      		}
    },
    autoSync:true,
    folderSort: true,
    sorters: [{property: 'id', direction: 'ASC'}]
    
});
