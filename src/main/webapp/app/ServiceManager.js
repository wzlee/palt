/*!
* Ext JS Library 4.0
* Copyright(c) 2006-2011 Sencha Inc.
* licensing@sencha.com
* http://www.sencha.com/license
*/

var windowIndex = 0;

Ext.define('Plat.ServiceManager', {
    extend: 'Ext.ux.desktop.Module',
    requires: [
        'Ext.panel.Panel',
        'Plat.controller.ServiceController'
    ],
    id: 'service-manager',
    init : function(){
        this.launcher = {
        	text: '服务管理',
        	iconCls: 'tabs'
        };
    },
    createWindow : function(){
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow('service-window');
        if(!win){
            win = desktop.createWindow({
                id: 'service-window',
                title:'服务管理',
                width:800,
                height:600,
                iconCls: 'tabs',
                layout:'border',
                items:[
	                	{
	                		xtype: 'servicecategorygrid',
	                		region:'west',
	                		width:200,
	                		margins:2,
	                		collapsible:true
	                	},
	                	{
	                		xtype: 'servicemanagergrid',
	                		margins:2,
	                		region:'center'
	                	}
	            	]
            });
        }
        return win;
    }

});