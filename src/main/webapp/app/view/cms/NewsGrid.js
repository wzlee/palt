Ext.define('plat.view.cms.NewsGrid', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.newsgrid',
	store : 'cms.NewsStore',
	title : '新闻管理',
	closable : true,
	id : 'xmzxgl',
	initComponent : function () {
		console.log('NewsGrid was initialized!!!');
		this.callParent(arguments);
	},
	features: [{
		ftype:'grouping',
		groupHeaderTpl: [
		    '{columnName}: ',
		    '<span>{name:this.formatName}</span>',
		    {
		        formatName: function(name) {
		        	switch (name) {
						case 1 : 
							name = "展会信息";
							break;
						case 2 : 
							name = "最新推荐";
							break;
						case 3 : 
							name = "政策法规";
							break;
						case 4 : 
							name = "最新公告";
							break;
						case 5 : 
							name = "新闻动态";
					}
		            return name;
		        }
		    }
		]
	}],
	tbar : [{
		text : '新增',
		iconCls : 'icon-add',
		name : 'add'
	}, '-', {
		text : '修改',
		iconCls : 'icon-edit',
		name : 'modify'
	}, '-', {
		text : '删除',
		iconCls : 'icon-remove',
		name : 'delete'
	}],
	dockedItems: [{
        xtype: 'pagingtoolbar',
        store: 'cms.NewsStore',   // same store GridPanel is using
        dock: 'bottom',
        displayInfo: true
    }],
	columns : [
		{header : '标题', dataIndex : 'title', flex : 1, align : 'center'},
//		{header : '图片',dataIndex : 'picture'},
//		{header : '内容',dataIndex : 'content'},
		{header : '发布人', dataIndex : 'author', width : 100, align : 'center' },
		{header : '更新时间', dataIndex : 'pubdate', width : 130, align : 'center'},
		{header : '来源', dataIndex : 'source', width : 100, align : 'center'},
		{header : '类别', dataIndex : 'cid', align : 'center', renderer : function (value) {
			switch (value) {
				case 1 : 
					value = "展会信息";
					break;
				case 2 : 
					value = "最新推荐";
					break;
				case 3 : 
					value = "政策法规";
					break;
				case 4 : 
					value = "最新公告";
					break;
				case 5 : 
					value = "新闻动态";
			}
			return value;
		}},	{
	        xtype:'actioncolumn',
	        text:'操作',
	        align:'center',
	        width:100,
	        items: [{
	            iconCls:'icon-remove',
	            tooltip: '删除',
	            handler: function(grid, rowIndex, colIndex) {
	                var record = grid.getStore().getAt(rowIndex);
	                Ext.MessageBox.confirm('警告','确定删除该新闻吗?',function(btn){
			    		if(btn == 'yes'){
			    			grid.getStore().remove(record);
			    		}
			    	});
	            }
	       }]
       }]
});
