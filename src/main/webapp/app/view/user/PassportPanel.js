Ext.define('plat.view.user.PassportPanel',{
	extend:'Ext.panel.Panel',
	xtype:'passportpanel',
    title:'用户及权限管理',
	id: 'passportpanel',
	closable:true,
    closeAction:'hide',
    layout:'fit',
     tbar :['-',
//				{iconCls:'icon-search',text:'查找',action:'search'},'-',
				{iconCls:'icon-add',text:'添加用户',action:'add'},'-','->'
	],
    initComponent: function() {
        Ext.apply(this, {
        	items :{
	        		xtype: 'usersgrid'
        	}
        });
        this.callParent();
    }
});