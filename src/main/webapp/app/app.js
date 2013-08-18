Ext.Loader.setConfig({enabled:true});
Ext.Loader.setPath({
	'Ext.ux':'jsLib/extjs/ux'
});
Ext.require([
	'Ext.ux.TabCloseMenu',
	'Ext.ux.MD5',
//	'Ext.ux.CheckColumn',
	'Ext.ux.grid.FiltersFeature',
//	'Ext.ux.RowExpander',
	'Ext.ux.GridComboBox',
	'Ext.ux.GridComboBoxList',
	'Ext.ux.DataView.DragSelector',
	'Ext.ux.UploadPanel',
	'Ext.ux.ComboBoxTree',
	'Ext.ux.form.SearchField'
]);

var plat = new Ext.application({
    name: 'plat',
    controllers: [
    	'MainController',
    	'system.MonitorController',
    	'service.ServiceController',
    	'cms.CmsController',
    	'user.UserController',
    	'cms.NewsController',
    	'system.SysCodeController',
    	'system.CategoryController'
    ],
    launch: function() {
  		Ext.Ajax.request({
  			type:'POST',
	    	url: 'public/check',
  			dataType:'json',
		    success: function(response){
		    	Ext.getBody().unmask();
		    	Ext.get('loading').remove();
		        Ext.fly('loading-mask').animate({
		            opacity:0,
		            remove:true
		        });
		    	var result = Ext.JSON.decode(response.responseText)
		        if(result.success){
					Ext.create('Ext.container.Viewport', {
			            layout: 'border',
			            items: [{
		        			xtype:'menupanel',
		        			region:'west',
		        			width:250,
		        			collapsible:true,
		        			split:true
		        		}, {
		                    xtype: 'contenttab',
		                    region:'center'
		                }]
			    	});
		        }else{
		        	Ext.create('Ext.window.Window', {
		        		id:'login-window',
						title:'系统登录',
						layout:'fit',
						frame:true,
						closable:false,
						items: [{
							xtype:'loginform',
							width:300,
							height:200
						}]
					}).show();
		        }
		    }
		});
        this.controllers.addListener('add',this.initController,this);
    },
    initController:function(index, controller, token){
    	controller.init();
    	console.log(token+'初始化完毕...');
  	}
});

