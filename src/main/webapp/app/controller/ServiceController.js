Ext.define('Plat.controller.ServiceController', {
    extend: 'Ext.app.Controller',
    alias:'widget.servicecontroller',
    stores: [
				'service.ServiceStore'
			],
    views: [
    			'service.ServiceCategoryGrid',
    			'service.ServiceManagerGrid'
    		],
    refs: [
    		{
    			ref:'categorygrid',
    			selector:'categorygrid'
    		},
    		{
    			ref:'servicegrid',
    			selector:'servicegrid'
    		}
    ],
    init: function() {
        this.control({
            'categorygrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
	            	gridpanel.on('itemclick',function(view,record,item,index){
						if(record.data.leaf){
							this.loadService(record.data.id,record.data.clazz);
						}
					},this);
            	}
            },
            'servicegrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            	}
            }
        });
    },
    loadService:function(id,clazz){
    	this.getServiceManagerGrid().getStore().load();
    }
});