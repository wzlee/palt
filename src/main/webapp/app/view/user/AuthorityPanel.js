Ext.define('plat.view.user.AuthorityPanel',{
	extend:'Ext.panel.Panel',
	xtype:'authoritypanel',
    title:'权限产看',
	id: 'authoritypanel',
	closable:true,
    closeAction:'hide',
    layout:'border',
    initComponent: function() {
        Ext.apply(this, {
        	items :[
	    		{
	        		xtype: 'rolesgrid',
	        		region:'west',
	        		width:400,
	        		collapsible:true,
	        		split:true
	        	},
	        	{
	        		xtype:'rightsgrid',
	        		region:'center'
	        	}
	    	]
        });
        this.callParent();
    }
});