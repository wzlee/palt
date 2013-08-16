Ext.define('plat.view.cms.NewsWin', {
	extend : 'Ext.window.Window',
	xtype : 'newswindow',
    height : 400,
    width: 600,
    layout : 'fit',
    closeAction : 'hide',
    items : {
    	xtype : 'newsform'
    },
    buttons : [{
    	text : '提交',
    	name : 'add'
    }, {
    	text : '提交',
    	name : 'modify',
    	hidden : true
    }, {
    	text : '取消',
    	name : 'cancel'
    }],
    init : function () {
    	console.log('NewsWin was initialized!!!');
    	this.callParent(arguments);
    }
});