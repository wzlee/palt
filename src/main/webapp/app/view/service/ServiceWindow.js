Ext.define('Plat.view.service.ServiceWindow',{
	extend:'Ext.window.Window',
	alias:'widget.servicewindow',
    
	title:'服务管理',
	id:'servicewindow',
    height: 600,
    width: 500,
    useArrows: true,
    
    initComponent: function() {
        Ext.apply(this, {
//            tbar: [{
//                text: 'Expand All',
//                scope: this,
//                handler: this.onExpandAllClick
//            }, {
//                text: 'Collapse All',
//                scope: this,
//                handler: this.onCollapseAllClick
//            }]
        });
        this.callParent();
    }
});