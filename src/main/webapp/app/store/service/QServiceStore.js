Ext.define('plat.store.service.QServiceStore', {
    extend: 'Ext.data.Store',
    model:'plat.model.service.ServiceModel',
    storeId:'qservicestore',
    groupField: 'category.text',
    proxy: {
        type: 'ajax',
     	actionMethods: {  
        	read: 'POST'
            },
        api:{  
		    read:'service/find',  
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
		    root:"services",  
		    allowSingle:false  
		}
    },
    autoSync:true,
    folderSort: true,
    sorters: [{property: 'id', direction: 'ASC'}]
});