Ext.define('plat.view.cms.ChanelPanel',{
	extend:'Ext.container.Container',
	id: 'chanelpanel',
	xtype: 'chanelpanel',
    activeTab: 0,
    bodyPadding: '10',
    layout:'border',
    items: [
	    {
	    	region: 'west',
	    	xtype: 'treepanel',
	    	title: '模块菜单',
	    	width:160,
	    	rootVisible: false,
			split: true,
			collapsible: true,
			enableDrag: true,
			ddGroup: 'theme',
			autoScroll:true,
	        store: Ext.create('Ext.data.TreeStore', {
	            root: {
	                expanded: true,
	                children: [
	                    { text: '热点服务', expanded: true, children: [ { text: '正版软件', leaf: true }, { text: '技工培训', leaf: true } ] }, { text: '企业风采', children: [ { text: '子菜单', leaf: true } ] }, { text: '厚街制造', children: [ { text: '子菜单', leaf: true } ] }, { text: '电商荟萃', children: [ { text: '子菜单', leaf: true } ] }, { text: '厚街商贸', children: [ { text: '子菜单', leaf: true } ] }
	                ]
	            }
	        })
	    },
	    {
	    	region: 'center',
	    	xtype: 'panel',
	    	title: '模板选择',
	    	layout: 'fit',
	    	tbar:[{
				xtype: 'combobox',
				fieldLabel: '选择模板',
				store: Ext.create('Ext.data.Store',{
					fields: ['id', 'name'],
					data : [
				        {"id":"theme1", "name":"第一套模板"},
				        {"id":"theme2", "name":"第二套模板"}
					]
				}),
				value:'theme1',
				queryMode: 'local',
				displayField: 'name',
				valueField: 'id'
			}],
			items: [{
				id:'hipanel',
				xtype: 'panel',
				margin:10,
				border: false,
				bodyBorder: false
			}]
	    }
    ]
});