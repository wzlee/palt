Ext.define('plat.view.service.UServiceGrid',{
	extend:'Ext.grid.Panel',
	xtype:'uservicegrid',
    
	title:'服务列表',
	id:'ysjfwgl',
	closable:true,
    closeAction:'hide',
	columnLines:true,
    store:'service.UServiceStore',
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
				        { text: '服务编码',align:'center',width:80, dataIndex: 'serviceNo',locked:true},
				        { text: '服务名称',align:'center',width:120, dataIndex: 'serviceName',locked:true},
				        { text: '注册时间',align:'center',width:120, dataIndex: 'registerTime',locked:true },
				        { text: '服务状态',align:'center',width:80, dataIndex: 'currentStatus',locked:true},
				        {text:'操作',locked:true,columns:[
				        	{
					            xtype:'actioncolumn',
					            text:'申请变更',
					            align:'center',
					            sortable:false,
					            width:50,
					            items: [
					            	{
						                iconCls:'icon-edit',
						                tooltip: '申请变更',
						                handler: function(grid, rowIndex, colIndex) {
						                    var record = grid.getStore().getAt(rowIndex);
						                    var serviceWindow;
    										var serviceWindows = Ext.ComponentQuery.query('uservicewindow');
									    	if(serviceWindows.length == 0){
									    		serviceWindow = Ext.widget('uservicewindow',{
									    			title:'服务变更',
									    			id:'uservicewindow'
									    		}).show();
									    		serviceWindow.getComponent('userviceform').form.loadRecord(record);
									    	}else{
									    		serviceWindows[0].show();
									    		serviceWindows[0].getComponent('userviceform').form.reset();
									    	}
						                },
						                isDisabled:function(grid, rowIndex, colIndex){
						                	return grid.getStore().getAt(rowIndex).data.currentStatus != "已上架";
						                }
						            }
					            ]
					        },
					        {
					            xtype:'actioncolumn',
					            text:'下架',
					            align:'center',
					            sortable:false,
					            width:50,
					            items: [
						            {
						            
						                iconCls:'icon-edit',
						                tooltip: '申请下架',
						                handler: function(grid, rowIndex, colIndex) {
						                    var record = grid.getStore().getAt(rowIndex);
						                    Ext.MessageBox.confirm('警告','确定将【 '+record.data.serviceName+' 】申请下架吗?',function(btn){
									    		if(btn == 'yes'){
									    			record.set('currentStatus',"下架审核中");
									    			record.set('lastStatus','已上架');
												}
											});
						                },
						                isDisabled:function(grid, rowIndex, colIndex){
						                	return grid.getStore().getAt(rowIndex).data.currentStatus != "已上架";
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
//		    plugins: [{
//		        ptype: 'rowexpander',
//		        rowBodyTpl : new Ext.XTemplate(
//		            '<p><b>来源:</b> {serviceSource}</p>',
//		            '<p><b>联系人:</b> {linkMan}</p><br>'
//	            )
//		    }],
//	    	features :[{ftype:'groupingsummary',id:'servicegroupingsummary',startCollapsed:true,groupHeaderTpl: '<font color="green">{name}</font> : 共[ <font color="green">{rows.length}</font> ]个服务'}],
	    	dockedItems :[{
					        xtype: 'pagingtoolbar',
					        store: 'service.UServiceStore',
					        dock: 'bottom',
					        displayInfo: true
					    }]
        });
        this.callParent();
    }
});