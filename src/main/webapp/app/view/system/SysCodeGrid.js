Ext.define('plat.view.system.SysCodeGrid',{
	extend:'Ext.grid.Panel',
	xtype:'syscodegrid',
	
	title:'数据字典列表',
	id:'sjzdgl',
	closable:true,
    closeAction:'hide',
	columnLines:true,
	emptyText:'无数据或者数据加载失败！',
    store:'system.SysCodeStore',
    tbar :['-',
				{xtype:'textfield',width:150,name:'sname',emptyText:'输入搜索关键字...'},'-',
				{iconCls:'icon-search',text:'查找',action:'search'},'-',
				{iconCls:'icon-add',text:'添加',action:'add'},'-','->'
//    					{xtype:'button',text:'显示分组',enableToggle:true,action:'group'},'-'
	],
    initComponent: function() {
    	var me = this;
        Ext.apply(this, {
			columns: [
						new Ext.grid.column.RowNumberer({text:'#',align:'center',width:30}),
				        { text: '字典ID',align:'center', dataIndex: 'id',hidden:true},
				        { text: '字典类型',align:'center',width:120, dataIndex: 'type'},
				        { text: '值',align:'center',width:80, dataIndex: 'value', flex: 1 },
				        { text: '显示文本',align:'center',width:120, dataIndex: 'remark'}
		    		]
        });
        this.callParent();
    }
});