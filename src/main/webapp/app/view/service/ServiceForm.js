Ext.defind('plat.view.service.ServiceForm',{
	extend:'Ext.form.Panel',
	xtype:'serviceform',
	
	id:'serviceform',
	width:600,
	height:500,
	defaults:{
		labelAlign:'right',
		bodyPadding: 5
	},
	bodyStyle:'padding:10 15',
	initComponent: function() {
    	this.items = [
						{
							xtype:'hiddenfield',
							name:'id'
						},
						{
							xtype:'textfield',
							name:'scode',
							columnWidth:.4,
							fieldLabel:'服务编码'
						},
						{
							xtype:'textfield',
							name:'sname',
							columnWidth:.6,
							fieldLabel:'服务名称'
						},
//						{
//							xtype:'fieldcontainer',
//							layout:'hbox',
//							columnWidth:.6,
//							defaultType:'radiofield',
//							fieldLabel:'性别',
//							items:[
//								{
//				                    boxLabel  : '女',
//				                    name      : 'sex',
//				                    inputValue: '1'
//				                }, {
//				                    boxLabel  : '男',
//				                    name      : 'sex',
//				                    inputValue: '2',
//				                    checked   : true
//				                }
//							]
//						}
			{
				xtype:'textfield',
				name:'source',
				width:400,
				fieldLabel:'服务来源'
			},
			{
				xtype:'filefield',
				name:'image',
				width:400,
				bodyPadding: '5 0 5 5',
				labelAlign:'right',
				fieldLabel:'图片'
			},
			{
				xtype:'filefield',
				name:'file',
				width:400,
				bodyPadding: '5 0 5 5',
				labelAlign:'right',
				fieldLabel:'附件'
			},
			{
				xtype:'htmleditor',
				name:'description',
				width:400,
				bodyPadding: '5 0 5 5',
				labelAlign:'right',
				fieldLabel:'服务介绍'
			}
		]
        this.callParent();
    }
});