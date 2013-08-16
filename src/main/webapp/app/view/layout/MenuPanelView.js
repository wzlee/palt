/**
 * 左边菜单树
 */
Ext.define('plat.view.layout.MenuPanelView' ,{
    extend: 'Ext.panel.Panel',
    
    xtype: 'menupanel',
    
    title : '系统菜单',
    animate : Ext.isIE9?false:true,
    animCollapse : true,
    layout: 'accordion',
    width: 500,
    defaults: {
        bodyPadding: 10,
        titleAlign:'center',
        rootVisible: false,
        xtype:'treepanel'
    },
    initComponent:function(){
    	Ext.apply(this, {
            items: [
                	{
		                title: '基础数据维护',
//		                store:Ext.createByAlias('menutree',{
//		                	defaultRootId:'1000'
//		                })
                		store: new Ext.data.TreeStore({
            				fields:['id','text','pid','leaf','idxtype'],
			                proxy: {
			                    type: 'ajax',
			                    url: 'rights/load'
			                },
			                root: {
			                    text: '所有类别',
			                    id: '1000',
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
			                }]
			            })
		            }, 
		            {
		                title: '运营数据管理',
                		store: new Ext.data.TreeStore({
                			fields:['id','text','pid','leaf','idxtype'],
			                proxy: {
			                    type: 'ajax',
			                    url: 'rights/load'
			                },
			                root: {
			                    text: '所有类别',
			                    id: '1001',
			                    expanded: true
			                },
			                folderSort: true,
			                nodeParam: 'pid',
			                sorters: [{
			                    property: 'id',
			                    direction: 'ASC'
			                }]
			            })
		            }, 
	            	{
		                title: '平台CMS',
                		store: new Ext.data.TreeStore({
                			fields:['id','text','pid','leaf','idxtype'],
			                proxy: {
			                    type: 'ajax',
			                    url: 'rights/load'
			                },
			                root: {
			                    text: '所有类别',
			                    id: '1002',
			                    expanded: true
			                },
			                folderSort: true,
			                nodeParam: 'pid',
			                sorters: [{
			                    property: 'id',
			                    direction: 'ASC'
			                }]
			            })
		            }, 
	            	{
		                title: '系统数据管理',
                		store: new Ext.data.TreeStore({
                			fields:['id','text','pid','leaf','idxtype'],
			                proxy: {
			                    type: 'ajax',
			                    url: 'rights/load'
			                },
			                root: {
			                    text: '所有类别',
			                    id: '1003',
			                    expanded: true
			                },
			                folderSort: true,
			                nodeParam: 'pid',
			                sorters: [{
			                    property: 'id',
			                    direction: 'ASC'
			                }]
			            })
		            }
            	],
            bbar:['->','-',
    				{	
		                xtype: 'systemmenu'
					},'-'
				]
    	});
	    this.callParent(arguments);
    }
});

