Ext.define('plat.view.layout.combo.ServiceClass',{
	extend:'Ext.form.field.ComboBox',
	xtype:'serviceclass',
	queryMode: 'remote',
    displayField: 'text',
    valueField: 'id',
    
    initComponent:function(){
    	this.store = Ext.create('Ext.data.ArrayStore',{
    		fields:['id','text'],
    		proxy:{
    			type:'ajax',
    			url:'category/findAll'
    		}
    	});
    	this.callParent(arguments);
    }
});