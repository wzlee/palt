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
        extraParams: {
            currentStatus: "新服务','上架审核中"
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
		    root:"services",  
		    allowSingle:false  
		}
    },
//    autoSync:true,
    folderSort: true,
    sorters: [{property: 'id', direction: 'ASC'}],
    listeners: {
        beforeload: function(){
            var params = store.getProxy().extraParams;
            if (params.query) {
                delete params.currentStatus;
            } else {
                params.currentStatus = "新服务','上架审核中";
            }
        }
    }
});