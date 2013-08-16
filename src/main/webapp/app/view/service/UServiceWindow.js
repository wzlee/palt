Ext.define('plat.view.service.UServiceWindow', {
    extend: 'Ext.window.Window',
	xtype:'uservicewindow',
	
    width: 600,
    height: 510,
	layout:'fit',
	buttonAlign:'center',
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            items: [
		            {	
		            	xtype:'form',
		            	id:'userviceform',
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
				                    xtype: 'hiddenfield',
				                    name:'id'
				                },
					    	 	{
				                    xtype: 'displayfield',
				                    width: 259,
				                    name:'serviceNo',
				                    fieldLabel: '服务编码'
				                },
				                {
				                    xtype: 'radiogroup',
				                    width: 259,
				                    name:'serviceSource',
				                    fieldLabel: '服务来源',
				                    items: [
				                        {
				                            xtype: 'radiofield',
				                            boxLabel: '平台',
				                            inputValue: '1',
				                            name      : '服务来源',
				                            checked: true
				                            
				                            
				                        },
				                        {
				                            xtype: 'radiofield',
				                            boxLabel: '服务机构',
				                            inputValue: '2',
				                            name: 'serviceSource'
				                            
				                        }
				                    ]
				                },
				                {
				                    xtype: 'hiddenfield',
				                    name:'serviceOrg.id'
				                },
				                {
				                    xtype: 'serviceorgcombo',
				                    name:'serviceOrg.orgName',
				                    width: 259,
				                    fieldLabel: '服务机构',
				                    listeners:{
				                    	select:function(combo,records){
				                    		this.ownerCt.down('hiddenfield[name=serviceOrg.id]').setValue(records[0].data.id);
				                    	}
				                    }
				                },
				                {
				                    xtype: 'textfield',
				                    name:'serviceName',
				                    width: 259,
				                    fieldLabel: '服务名称'
				                },
				                {
				                    xtype: 'displayfield',
				                    name:'currentStatus',
				                    width: 259,
				                    fieldLabel: '当前状态'
				                },
				                {
				                    xtype: 'displayfield',
				                    name:'lastStatus',
				                    width: 259,
				                    fieldLabel: '上一状态'
				                },
				                {
				                    xtype: 'displayfield',
				                    width: 259,
				                    name:'registerTime',
				                    fieldLabel: '注册时间'
				                },
				                {
				                    xtype: 'displayfield',
				                    name:'serviceNum',
				                    width: 259,
				                    fieldLabel: '服务次数'
				                },
				                {
				                    xtype: 'hiddenfield',
				                    name:'category.id'
				                },
				                {
				                    xtype: 'comboboxtree',
				                    name:'category.text',
				                    store: new Ext.data.TreeStore({
			            				fields:['id','text','pid','leaf','idxtype'],
						                proxy: {
						                    type: 'ajax',
						                    url: 'category/load'
						                },
						                root: {
						                    text: '所有类别',
						                    id: '0',
						                    expanded: true
						                },
						                reader:{  
							      			type: 'json',
											root: '',
							        		messageProperty:"message"  
							      		}, 
						                folderSort: true,
						                nodeParam: 'pid',
						                sorters: [{
						                    property: 'id',
						                    direction: 'ASC'
						                }],
						                listeners : {  
							                exception : function(proxy, response, operation) {  
							                    Ext.MessageBox.show({  
							                        title : '服务器错误',  
							                        msg : operation.getError(),  
							                        icon : Ext.MessageBox.ERROR,  
							                        buttons : Ext.Msg.OK  
							                    });  
							                },  
							                beforeload : function(store, operation) {  
							                    Ext.apply(store.proxy.extraParams, {clazz:'service'});
							                }  
							            }  
						            }),
						            submitValue:'text',
									pathValue:'text',
									valueTarget:'hiddenfield[name=category.id]',
									onlyLeaf:true,
				                    width: 350,
				                    allowBlank:false,
				                    editable:false,
				                    emptyText:'请选择服务类别...',
				                    fieldLabel: '服务类别'
				                },
				                {
				                	xtype: 'sobjectcombo',
				                	name:'serviceObject',
				                	width: 550,
				                    fieldLabel: '服务对象',
				                    multiSelect:true
				                },
				                {
				                    xtype: 'smethodcombo',
				                    fieldLabel: '服务方式',
				                    width: 550,
				                    name:'serviceMethod',
				                    multiSelect:true
				                },
				                {
				                    xtype: 'textfield',
				                    width: 180,
				                    name:'linkMan',
				                    fieldLabel: '联系人'
				                },
				                {
				                    xtype: 'textfield',
				                    name:'tel',
				                    width: 180,
				                    fieldLabel: '电话'
				                },
				                {
				                    xtype: 'textfield',
				                    width: 180,
				                    name:'email',
				                    fieldLabel: '邮箱',
				                    vtype:'email'
				                },
				                {
				                    xtype: 'textfield',
				                    width: 550,
				                    name:'chargeMethod',
				                    fieldLabel: '收费模式'
				                },
				                {
				                    xtype: 'htmleditor',
				                    height: 150,
				                    width:550,
				                    name:'serviceProcedure',
				                    fieldLabel: '服务描述'
				                }
					    	]
		            	}
            		],
			buttons:[
				{
					text:'申请变更',
//					iconCls:'icon-submit',
					action:'submit'
				},
				{
					text:'关闭',
//					iconCls:'icon-reset',
					action:'close'
				}
			]
        });

        me.callParent(arguments);
    }

});