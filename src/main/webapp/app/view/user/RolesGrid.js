Ext.define('plat.view.user.RolesGrid',{
	extend:'Ext.grid.Panel',
	alias:'widget.rolesgrid',
	title:'角色显示',
	id:'rolesgrid',
    height: 400,
    width: 500,
    closeAction:'hide',
    useArrows: true,
    store:new Ext.data.Store({
        fields: ['rolename','id','rights','createTime','roledesc'],
        autoLoad: false,
		proxy: {
	        type: 'ajax',
	        url: 'rights/queryrole',
	        reader: {
	            type: 'json',
	            root: 'data',
	            successProperty: 'success'
	        }
	    }
    }),
    columns: [
		  {header: '角色名',  dataIndex: 'rolename',  flex: 1},
		  {header: '角色描述',  dataIndex: 'roledesc',  flex: 1},
		  {header: '创建时间',  dataIndex: 'createTime',  flex: 1}]
});