Ext.define('plat.view.system.CategoryGrid',{
	extend:'Ext.tree.Panel',
	alias:'widget.categorygrid',
    
	requires: [
        'Ext.data.*',
        'Ext.grid.*',
        'Ext.tree.*',
        'Ext.ux.CheckColumn'
    ],
	
    id:'sjlbgl',
    closable : true,
    useArrows: true,
    rootVisible: false,
    multiSelect: true,
    singleExpand: true,
  	store : 'system.CategoryStore',
    tbar :['-',
				{iconCls:'icon-add',text:'添加根类',action:'add'},'-','->'
	],
    initComponent: function() {
        this.width = 600;
        Ext.apply(this, {
            columns: [{
                xtype: 'treecolumn', //this is so we know which column will show the tree
                text: '类别名称',
                flex: 2,
                sortable: true,
                dataIndex: 'text'
            },{
                text: '所属实体类',
                flex: 1,
                dataIndex: 'clazz',
                sortable: true
            },{
                text: '编码',
                flex: 1,
                dataIndex: 'code',
                sortable: true
            }, {
            	text: '添加',
               	width: 55,
                menuDisabled: true,
                xtype: 'actioncolumn',
                tooltip: '添加子节点',
                align: 'center',
                icon: 'resources/images/add.png',
                handler: function(grid, rowIndex, colIndex, actionItem, event, record, row) {
                	console.log(record);
                    Ext.Msg.alert('提示',record.get('text'));
                }
            }, {
                text: '编辑',
                width: 55,
                menuDisabled: true,
                xtype: 'actioncolumn',
                tooltip: '编辑节点',
                align: 'center',
                icon: 'resources/images/edit.png',
                handler: function(grid, rowIndex, colIndex, actionItem, event, record, row) {
                    Ext.Msg.alert('提示',record.get('text'));
                }
            },{
            	text: '删除',
               	width: 55,
                menuDisabled: true,
                xtype: 'actioncolumn',
                tooltip: '删除节点',
                align: 'center',
                icon: 'resources/images/delete.png',
                handler: function(grid, rowIndex, colIndex, actionItem, event, record, row) {
                    Ext.Msg.alert('提示',record.get('text'));
                }
            }]
        });
        this.callParent();
    }
});