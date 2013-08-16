Ext.define('plat.controller.cms.CmsController', {
    extend: 'Ext.app.Controller',
    alias:'widget.cmscontroller',
    stores: [],
    views: [
		'cms.ChanelPanel',
		'cms.Theme1',
		'cms.Theme2'
    		],
    refs: [
   	    {
	    	ref: 'theme1',
	    	selector: 'theme1',
	    	autoCreate: true
	    },
	    {
	    	ref: 'theme2',
	    	selector: 'theme2'
	    }
    ],
    init: function() {
        this.control({
        	'chanelpanel':{
            	afterrender:function(panel){
            		console.log(panel.title + '渲染完毕...');
            	}
            },
    		'#hipanel': {
				afterrender: function(item){
					//默认加载的主题
					item.add({xtype:'theme1'})
				}
			},
    		'chanelpanel combobox': {
    			afterrender: function(item){
    				item.on('select',function(combo, records, eOpts){
    					var hipanel = Ext.getCmp('hipanel');
    					var panels = Ext.ComponentQuery.query('#hipanel > panel');
    					if(records[0].data.id!=''){
    						console.log("当前选中的主题为"+records[0].data.id);
    						hipanel.removeAll(panels);
    						hipanel.add({xtype: records[0].data.id});
    					}else{
    						console.log('数据存在异常');
    					}
    				})
    			}
    		}
        });
    }
});