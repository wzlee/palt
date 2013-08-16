Ext.define('plat.view.user.UserWindow', {
    extend: 'Ext.window.Window',
	xtype:'userwindow',
	
    width: 300,
    height: 300,
	layout:'fit',
	buttonAlign:'center',
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
		            {	
		            	xtype:'form',
		            	id:'userform',
		            	layout: {
					        type: 'column'
					    },
					    defaults:{
					        labelWidth:60,
					        labelAlign:'right',
					        margin:'2'
					    },
					    bodyPadding:'10',
					    items:[
				                {
				                    xtype: 'textfield',
				                    name:'username',
				                    width: 259,
				                    fieldLabel: '用户名'
				                },
				                {
				                    xtype: 'textfield',
				                    name:'password',
				                    inputType :'password',
				                    width: 259,
				                    fieldLabel: '密码'
				                },
				                {
				                    xtype: 'textfield',
				                    name:'password1',
				                    inputType :'password',
				                    width: 259,
				                    fieldLabel: '请核对密码'
				                },
				                {
			                		xtype: 'combobox',
								    fieldLabel: '所属角色下拉框',
								    queryMode: 'local',
								    displayField: 'rolename',
								    valueField: 'rolename',
								    editable:false,
								    store:  new Ext.data.Store({
								        fields: ['rolename','id','rights','createTime','roledesc'],
								        autoLoad: true,
										proxy: {
									        type: 'ajax',
									        url: 'rights/queryrole',
									        reader: {
									            type: 'json',
									            root: 'data',
									            successProperty: 'success'
									        }
									    }
								    })
								}
					    	]
		            	}
            		],
			buttons:[
				{
					text:'提交',
//					iconCls:'icon-submit',
					action:'submit'
				},
				{
					text:'清空',
//					iconCls:'icon-reset',
					action:'reset'
				}
			]
        });

        me.callParent(arguments);
    }

});