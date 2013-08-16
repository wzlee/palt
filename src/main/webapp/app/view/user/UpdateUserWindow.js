Ext.define('plat.view.user.UpdateUserWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.updateuserwindow',
    id:'updateuserwindow',

    title: '修改用户',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                items: [
                    {
                        xtype: 'textfield',
                        name : 'username',
                        fieldLabel: '用户名'
                    },
                    {
                        xtype: 'textfield',
                        name : 'password',
                        fieldLabel: '密码'
                    },
//                    {
//                        xtype: 'textfield',
//                        name : 'rolename',
//                        fieldLabel: '所属角色',
//                        id:'textrolename'
//                    },
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
        ];

        this.buttons = [
            {
                text: '保存',
                action: 'save'
            },
            {
                text: '取消',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});