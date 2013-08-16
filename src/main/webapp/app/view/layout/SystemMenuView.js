/**
 * 系统菜单视图
 */
Ext.define('plat.view.layout.SystemMenuView' ,{
    extend: 'Ext.button.Button',
    alias : 'widget.systemmenu',
    
    text:'系统菜单',
    iconCls:'icon-windows',
	initComponent:function(){
		var me = this;
    	me.menu = [{
            			text:'系统信息',
            			iconCls:'icon-about',
            			handler:function(){
            				me.aboutSystem();
            			}
            		},'-',
            		{
            			text:'修改密码',
            			iconCls:'icon-password',
            			handler:function(){
            				me.changePassword();
            			}
            		},'-',
        			{
            			text:'锁定屏幕',
            			iconCls:'icon-lock',
            			handler:function(){
            				me.lock();
            			}
            		},'-',
        			{
            			text:'退出登陆',
            			iconCls:'icon-logout',
            			handler:function(){
            				me.logout();
            			}
            		}];
	    me.callParent(arguments);
    },
    changetheme:function(theme){
//        location.href = location.href.replace(
//            'ext-theme-' + theme, 'ext-theme-' + combo.getValue()
//        );
    	if(Ext.isIE && theme != 'ext-ie'){
    		Ext.example.msg('温馨提示:','系统检测到你使用的是IE浏览器,系统自动设置样式为[<font color="green">IE兼容</font>],您选择其他的主题样式可能会产生样式不兼容的问题!');
    	}else{
    		Ext.example.msg('','系统主题修改成功!');
    	}
		Ext.util.CSS.swapStyleSheet('theme', 'jsLib/extjs/resources/css/' + theme+'.css');
		Ext.util.Cookies.set('theme', theme);
    },
    changePassword:function(){
    	var passwordwin = Ext.getCmp('passwordwindow');
    	if(!passwordwin){
    		passwordwin = Ext.createWidget('passwordwindow');
    	}
    	var passwordform = passwordwin.getComponent('passwordform');
    	passwordform.form.reset();
    	passwordwin.show();
    },
    aboutSystem:function(){
    	Ext.createWidget('systemwindow').show();
    },
    logout:function(){
		Ext.getBody().mask("退出系统中,请稍候...");
		Ext.Ajax.request({
			url:'public/userlogout',
			timeout:10000,
			success:function(response){
				Ext.getBody().unmask();
				var result = Ext.decode(response.responseText);
		    	if(result.success){
					Ext.util.Cookies.clear();
					window.location.href = "";
//					var loginWindow = Ext.getCmp('login-window');
//					if(!loginWindow){
//						loginWindow = Ext.create('Ext.window.Window', {
//			        		id:'login-window',
//							title:'系统登录',
//							layout:'fit',
//							frame:true,
//							closable:false,
//							items: [{
//								xtype:'loginform',
//								width:300,
//								height:200
//							}]
//						});
//					}
//					loginWindow.show()
		    	}else{
					Ext.example.msg("提示:",'退出系统失败,请直接关闭页面!');
		    	}
			},
			failure:function(response){
				Ext.getBody().unmask();
				Ext.example.msg("提示:",'退出系统失败,请直接关闭页面!');
			}
		});
	},
	lock:function(){
//		Ext.MessageBox.prompt('屏幕已被锁定!', '请输入解锁密码:', function(btn){
//			console.log(btn);
//		});
		Ext.create('Ext.window.Window', {
    		id:'lock-window',
			title:'屏幕已被锁定!',
			layout:'fit',
			modal:true,
			closable:false,
			buttonAlign:'center',
			items: [{
				xtype:'form',
				width:200,
				height:50,
				bodyPadding:'10',
				items:[
						{
							xtype:'textfield',
							inputType:'password',
							labelAlign:'right',
							labelWidth:60,
							allowBlank:false,
							fieldLabel:'解锁密码'
						}
				]
			}],
			buttons:[
					{
						text:'解锁',
						handler:function(){
							this.ownerCt.ownerCt.close();
						}
					}
			]
		}).show();
	}
});
