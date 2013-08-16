Ext.define('plat.view.system.CategoryWindow', {
    extend: 'Ext.window.Window',
	xtype:'categoryWindow',
	
    width: 300,
    height: 200,
	layout:'fit',
	title : '添加根类',
	buttonAlign:'center',
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
		            {	
		            	xtype:'form',
		            	id:'categoryform',
		            	layout: {
					        type: 'column'
					    },
					    defaults:{
					        labelWidth:60,
					        labelAlign:'right',
					        margin:'1'
					    },
					    bodyPadding:'10',
					    items:[
					    		{
				                    xtype: 'hiddenfield',
				                    name:'id'
				                },{
				                    xtype: 'hiddenfield',
				                    name:'code'
				                },{
				                    xtype: 'hiddenfield',
				                    name:'pid'
				                },{
				                    xtype: 'textfield',
				                    name:'text',
				                    width: '100%',
				                    fieldLabel: '名称'				                    
				                },{
				                    xtype: 'textfield',
				                    name:'clazz',
				                    width: '100%',
				                    fieldLabel: '关联类'
				                },{
				                    xtype: 'radiogroup',
				                    width: '100%',
				                    name:'leaf',
				                    fieldLabel: '叶节点',
				                    items: [
				                        {
				                            xtype: 'radiofield',
				                            boxLabel: '是',
				                            inputValue: 'true',
				                            name      : 'leaf',
				                            checked: true
				                        },{
				                            xtype: 'radiofield',
				                            boxLabel: '否',
				                            inputValue: 'false',
				                            name: 'leaf'
				                            
				                        }
				                    ]
				                },{
				                    xtype: 'textfield',
				                    name:'description',
				                    width: '100%',
				                    fieldLabel: '描述'
				                }
					    	]
		            	}
            		],
			buttons:[
				{
					text:'提交',
					action:'submit'
				},
				{
					text:'清空',
					action:'reset'
				}
			]
        });
        me.callParent(arguments);
    }

});