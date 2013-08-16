Ext.define('plat.view.user.UsersGrid',{
	extend:'Ext.grid.Panel',
	alias:'widget.usersgrid',
	columnLines:true,
	title:'用户显示',
	id:'usersgrid',
    height: '100%',
    width: '100%',
    closeAction:'hide',
    useArrows: true,
	features: [{ftype:'grouping',
	    groupHeaderTpl: [
			    '角色名称: ',
			    '<span>{name:this.formatName}</span>',
			    {
			        formatName: function(name) {
			            return name;
			        }
			    }
		]}],
    store:{
    		autoLoad: true,
    		autoSync:true,
            fields: ['username',
            	{
            	name : 'rolename',
            	mapping : 'role.rolename'
            	},
            		'password'],
            groupField:'rolename',
            proxy: {
	        type: 'ajax',
	        url: 'rights/queryusers',
	        reader: {
	            type: 'json',
	            root: 'data',
	            successProperty: 'success'
	        	}
        	}
        },
    columns: [{ header: '用户名',  dataIndex: 'username',width:300 },
    		  { header: '用户密码',  dataIndex: 'password',width:300 },{
				            xtype:'actioncolumn',
				            text:'删除',
				            align:'center',
				            width:50,
				            items: [
				            	{
					                iconCls:'icon-remove',
					                tooltip: '删除',
					                handler: function(grid, rowIndex, colIndex) {
					                    var record = grid.getStore().getAt(rowIndex);
					                    Ext.MessageBox.confirm('警告','确定删除【 '+record.data.username+' 】吗?',function(btn){
								    		if(btn == 'yes'){
//								    			grid.getStore().remove(record);
								    			Ext.Ajax.request({
												    type:'POST',
												    url: 'user/delete',
												    params:{'username':record.data.username},
												    success: function(response) {
												    	var result = Ext.decode(response.responseText);
												    	if(result.success){
												    		Ext.getCmp('usersgrid').getStore().reload();
												    	}
												    },
												    failure: function(form, action) {
												    		Ext.example.msg('删除失败！',result.messgae);
												    }
												});
    
											}
										});
					                }
					            }
				            ]
				        }
    ]
});