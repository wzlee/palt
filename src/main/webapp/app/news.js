Ext.application({
	appFolder : 'app',
	name : 'plat',
	launch : function () {
		Ext.create('Ext.container.Viewport', {
			layout : 'border',
			items : [{
				xtype : 'panel',
				region : 'west',
				width : 200,
				titile : 'asdfasdf',
				border : true,
				html : '我在左边'
			}/*, {
				xtype : 'newsgrid',
				region : 'center'
			}*/, {
				xtype : 'aservicegrid',
				region : 'center'
			}]
		});
	},
	controllers : [/*'cms.NewsController', */'service.ServiceController']
});