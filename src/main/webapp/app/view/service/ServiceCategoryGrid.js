Ext.define('Plat.view.service.ServiceCategoryGrid',{
	extend:'Ext.tree.Panel',
	alias:'widget.servicecategorygrid',
	
    requires: [
        'Ext.tree.*',
        'Ext.data.*'
    ],
    
	title:'服务类别',
	id:'servicecategorygrid',
    height: 400,
    width: 300,
    useArrows: true,
    initComponent: function() {
        Ext.apply(this, {
            store: new Ext.data.TreeStore({
                proxy: {
                    type: 'ajax',
                    url: 'category/load'
                },
                root: {
                    text: '所有类别',
                    id: '0',
                    expanded: true
                },
                folderSort: true,
                nodeParam: 'pid',
                sorters: [{
                    property: 'text',
                    direction: 'ASC'
                }]
            }),
//            viewConfig: {
//                plugins: {
//                    ptype: 'treeviewdragdrop',
//                    containerScroll: true
//                }
//            },
            tbar: ['->', {
                text: '全部展开',
                scope: this,
                handler: this.onExpandAllClick
            },'-',{
                text: '全部折叠',
                scope: this,
                handler: this.onCollapseAllClick
            }]
        });
        this.callParent();
    },
    
    onExpandAllClick: function(){
        var me = this,
            toolbar = me.down('toolbar');
            
        me.getEl().mask('Expanding tree...');
        toolbar.disable();
                    
        this.expandAll(function() {
            me.getEl().unmask();
            toolbar.enable();
        });
    },
    
    onCollapseAllClick: function(){
        var toolbar = this.down('toolbar');
        
        toolbar.disable();
        this.collapseAll(function() {
            toolbar.enable();
        });
    }
});