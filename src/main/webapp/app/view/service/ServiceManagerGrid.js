Ext.define('Plat.view.service.ServiceManagerGrid',{
	extend:'Ext.grid.Panel',
	alias:'widget.servicemanagergrid',
    
	title:'服务列表',
	id:'servicemanagergrid',
    useArrows: true,
    
    initComponent: function() {
        Ext.apply(this, {
    	 	store: Ext.data.StoreManager.lookup('service-store'),
			columns: [
				        { text: '服务ID',align:'center', dataIndex: 'id',hidden:true},
				        { text: '服务编码',align:'center',width:100, dataIndex: 'scode'},
				        { text: '服务编码',align:'center', dataIndex: 'scode', flex: 1 },
				        { text: '来源',align:'center', dataIndex: 'resource', flex: 1 },
				        { text: '注册时间',align:'center', dataIndex: 'regdate', flex: 1 }
		    		],
    		tbar :['-',
	    				{xtype:'textfield',width:150,name:'servername',emptyText:'输入搜索关键字...'},'-',
    					{iconCls:'icon-search',text:'查找',action:'search'},'-',
    					{iconCls:'icon-publish',text:'添加',action:'publish'},'-','->',
    					{xtype:'button',text:'显示分组',enableToggle:true,action:'group'},'-'
	    	],
	    	features :[{ftype:'groupingsummary',id:'servicegroupingsummary',startCollapsed:true,groupHeaderTpl: '<font color="green">{name}</font> : 共[ <font color="green">{rows.length}</font> ]个服务'}],
	    	dockedItems :[{
					        xtype: 'pagingtoolbar',
					        store: Ext.data.StoreManager.lookup('service-store'),
					        dock: 'bottom',
					        displayInfo: true
					    }]
        });
        this.callParent();
    }
});