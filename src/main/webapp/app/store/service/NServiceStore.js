Ext.define('plat.store.service.NServiceStore', {
    extend: 'Ext.data.Store',
    model:'plat.model.service.ServiceModel',
    storeId:'nservicestore',
    xtype : 'nservicestore',
//    groupField: 'cid',
    proxy: {
        type: 'ajax',
     	actionMethods: {  
        	read: 'POST'
            },
        api:{  
		    read:'service/query',  
		    create:'service/save',  
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
		    root:"service",  
		    allowSingle:true  
		}
    },
    autoSync:true,
    folderSort: true,
    sorters: [{property: 'id', direction: 'ASC'}]
});