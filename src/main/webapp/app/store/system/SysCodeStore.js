Ext.define('plat.store.system.SysCodeStore', {
    extend: 'Ext.data.Store',
    model:'plat.model.system.SysCodeModel',
    
    proxy: {
        type: 'ajax',
     	actionMethods: {  
        	read: 'POST'
            },
        api:{  
		    read:'service/query',  
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
    sorters: [{property: 'service_id', direction: 'ASC'}]
});
