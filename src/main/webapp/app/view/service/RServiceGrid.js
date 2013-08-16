Ext.define('plat.view.service.RServiceGrid',{
	extend:'Ext.grid.Panel',
	xtype:'rservicegrid',
    
	title:'已删除服务列表',
	id:'yscfwgl',
	closable:true,
	closeAction:'hide',
	columnLines:true,
    store:'service.RServiceStore',
      tbar :['-',
				{xtype:'textfield',width:150,name:'serviceName',emptyText:'输入搜索关键字...'},'-',
				{iconCls:'icon-search',text:'查找',action:'search'},'-'
	],
    initComponent: function() {
    	var me = this;
        Ext.apply(this, {
			columns: [
						new Ext.grid.column.RowNumberer({text:'#',align:'center',width:30}),				        
				        { text: '服务ID',align:'center', dataIndex: 'id',hidden:true},
				        { text: '上次服务状态',align:'center', dataIndex: 'lastStatus',hidden:true},
				        { text: '服务编码',align:'center',width:80, dataIndex: 'serviceNo',locked:true},
				        { text: '服务名称',align:'center',width:120, dataIndex: 'serviceName',locked:true},
				        { text: '注册时间',align:'center',width:120, dataIndex: 'registerTime',locked:true },
				        { text: '服务状态',align:'center',width:80, dataIndex: 'currentStatus',locked:true},
				        {text:'操作',locked:true,columns:[
				        	{
				       
					            xtype:'actioncolumn',
					            text:'还原服务',
					            align:'center',
					            sortable:false,
					            width:80,
					            items: [
					            	{
						                iconCls:'icon-edit',
						                tooltip: '还原服务',
						                handler: function(grid, rowIndex, colIndex) {
						                    var record = grid.getStore().getAt(rowIndex);						                    
						                    Ext.MessageBox.confirm('警告','确定还原【 '+record.data.serviceName+' 】吗?',function(btn){		
									    		if(btn == 'yes'){	
									    			record.set('currentStatus',record.data.lastStatus);
									    			record.set('lastStatus',"已删除");
												}
											});
						                },
						                isDisabled:function(grid, rowIndex, colIndex){
						                	return grid.getStore().getAt(rowIndex).data.currentStatus != "已删除";
						                }
						            }
					            ]
				        	}
		    			]},
		    			{text:'联系方式',columns:[
					        { text: '联系人',align:'center',width:60, dataIndex: 'linkMan'},
					        { text: '电话',align:'center',width:60, dataIndex: 'tel'},
					        { text: '邮箱',align:'center',width:80, dataIndex: 'email'}
				        ]},
				        { text: '服务类别ID',align:'center', dataIndex: 'category.id',hidden:true},
				        { text: '服务类别',align:'center',width:100, dataIndex: 'category.text'},
					    { text: '来源',align:'center',width:100, dataIndex: 'serviceSource'},
				        { text: '服务机构ID',align:'center', dataIndex: 'serviceOrg.id',hidden:true},
				        { text: '服务机构',align:'center',width:80, dataIndex: 'serviceOrg.orgName'},
				        { text: '服务对象',align:'center',width:100, dataIndex: 'serviceObject'},
				        { text: '服务方式',align:'center',width:100, dataIndex: 'serviceMethod'},
				        { text: '服务描述',align:'center',width:150, dataIndex: 'serviceProcedure'},
				        { text: '收费方式',align:'center',width:80, dataIndex: 'chargeMethod'},
				        { text: '服务次数',align:'center',width:80, dataIndex: 'serviceNum'}
			],
	    	dockedItems :[{
					        xtype: 'pagingtoolbar',
					        store: 'service.RServiceStore',
					        dock: 'bottom',
					        displayInfo: true
					    }]
        });
        this.callParent();
    }
});