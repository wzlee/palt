/*!
* Ext JS Library 4.0
* Copyright(c) 2006-2011 Sencha Inc.
* licensing@sencha.com
* http://www.sencha.com/license
*/

var windowIndex = 0;

Ext.define('MyDesktop.HelloWorld', {
    extend: 'Ext.ux.desktop.Module',
    requires: [
        'Ext.panel.Panel'
    ],
    id: 'helloworld',
    init : function(){
        this.launcher = {
        	text: '我的菜单',
        	iconCls: 'tabs'
        };
    },
    createWindow : function(){
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow('tab-win');
        if(!win){
            win = desktop.createWindow({
                id: 'tab-win',
                title:'Tab Window',
                width:740,
                height:480,
                iconCls: 'tabs',
                items:[
                	{
                		xtype: 'panel',
                		width: 200,
                		height: 100,
                		html: '这是什么？'
                	}
                	]
            });
        }
        return win;
    }

});