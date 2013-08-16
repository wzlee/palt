Ext.define('plat.controller.system.CategoryController', {
    extend: 'Ext.app.Controller',
    stores: ['system.CategoryStore'],
    views: [
    	'system.CategoryGrid',
    	'system.CategoryWindow'
    ],
    refs: [
	        {
	            ref: 'categorygrid',
	            selector: 'categorygrid'
	        },{
	        	ref: 'categoryform',
	            selector: 'categoryform'
	        }
    ],
    init: function() {
        this.control({
            'categorygrid' : {
            	afterrender:function(gridpanel){
            		var categoryWindow = null;
            		gridpanel.down('button[action=add]').on('click',function(){
				    	if(categoryWindow == null){
				    		categoryWindow = Ext.widget('categoryWindow').show();    		
				    	}else{
				    		categoryWindow.show();
				    	}
					},this);
            	}
            }
        });
    }    
});