Ext.define('Plat.store.service.CategoryStore', {
    extend: 'Ext.data.Store',
    model:'Plat.model.service.CategoryModel',
    
    storeId:'service-category-store',
//    groupField: 'service_name',
    proxy: {
        type: 'ajax',
     	actionMethods: {  
        	read: 'POST'
            },
        api:{  
		    read:'service/load',  
		    create:'service/add',  
		    destroy:'service/delete',  
		    update:'service/update'  
      		},  
		reader:{  
      		type: 'json',
			root: 'data',
        	messageProperty:"message"  
      		}, 
		writer:{  
		    type:"json",  
		    encode:true,  
		    root:"data",  
		    allowSingle:false  
		}
    },
    folderSort: true,
    sorters: [{property: 'id', direction: 'ASC'}]
});
