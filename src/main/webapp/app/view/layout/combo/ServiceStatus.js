Ext.define('plat.view.layout.combo.ServiceStatus',{
	extend:'Ext.form.field.ComboBox',
	xtype:'servicestatus',
	editable:false,
	width:80,
	queryMode: 'local',
    displayField: 'serviceStatus',
    valueField: 'id',
    initComponent:function(){
    	this.store = new Ext.data.SimpleStore({
    		fields:['id','serviceStatus'],
    		data:[['所有服务','所有服务'],['新服务','新服务'],['上架审核中','上架审核中'],['已上架','已上架'],
    		['变更审核中','变更审核中'],['已删除','已删除'],['已下架','已下架'],['下架审核中','下架审核中']
    		]
    	});
    	this.callParent(arguments);
    }
})