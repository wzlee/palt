Ext.define('plat.view.user.RightsGrid',{
	extend:'Ext.grid.Panel',
	alias:'widget.rightsgrid',
	title:'权限菜单显示',
	id:'rightsgrid',
    height: 400,
    width: 300,
    closeAction:'hide',
    useArrows: true,
    features: [{ftype:'grouping',
	    groupHeaderTpl: [
			    '菜单: ',
			    '<span>{name:this.formatName}</span>',
			    {
			        formatName: function(name) {
			        	if(name==1000){
			        		name = "基础数据维护";
			        	}else if(name==1001){
			        		name = "运营数据管理";
			        	}else if(name==1002){
			        		name = "平台CMS";
			        	}else if(name==1003){
			        		name = "系统数据管理";
			        	}else if(name==0){
			        		name = "服务类别";
			        	}else{
			        			name=Ext.getCmp('rightsgrid').getStore().getAt(Ext.getCmp('rightsgrid').getStore().find('id',name)).data.text;
			        	}
			            return name;
			        }
			    }
		]
	}],
    store:{
            fields: ['id','pid','text','idxtype','leaf'],
            groupField:'pid'
    },
    columns: [  { header: '权限菜单',  dataIndex: 'text' },
			    { header: '父id',  dataIndex: 'pid' },
			    { header: 'IDXTYPE',  dataIndex: 'idxtype' ,width : 200},
			    { header: '是否叶子节点',  dataIndex: 'leaf', renderer:function(val){
			    	if(val == 1){
			    		return '是';
			    	} else {
			    		return '否';
			    	}
			    }}
    ]
});

