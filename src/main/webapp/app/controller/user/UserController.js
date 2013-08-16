Ext.define('plat.controller.user.UserController', {
    extend: 'Ext.app.Controller',
    
    alias:'widget.usercontroller',
    
    views: [
    			'user.PassportPanel',
    			'user.AuthorityPanel',
    			'user.UpdateUserWindow',
    			'user.UsersGrid',
    			'user.RolesGrid',
    			'user.RightsGrid',
    			'user.UserWindow'
    		],
    refs: [
    		{
    			ref:'passportpanel',
    			selector:'passportpanel'
    		},
    		{
    			ref:'rightsgrid',
    			selector:'rightsgrid'
    		},
    		{
    			ref:'usersgrid',
    			selector:'usersgrid'
    		},
    		{
    			ref:'rolesgrid',
    			selector:'rolesgrid'
    		},
    		{
    			ref:'authoritypanel',
    			selector:'authoritypanel'
    		},
    		{
    			ref:'updateuserwindow',
    			selector:'updateuserwindow'
    		},
    		{
    			ref:'userwindow',
    			selector:'userwindow'
    		}
    ],
    showUsers:function(grid, record) {
        Ext.getCmp('rightsgrid').getStore().loadData(record.get('rights'));
    },
    init: function() {
        this.control({
            'rolesgrid':{
            	afterrender:function(gridpanel){
            		gridpanel.getStore().load();
            		console.log(gridpanel.title + '渲染完毕...');
            	},
        		itemclick: this.showUsers
            },
            'usersgrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            	},
            	itemdblclick:function(grid, record){
            		var view = Ext.widget('updateuserwindow');
					view.down('form').loadRecord(record);
					var value = record.data.rolename;
					Ext.getCmp('updateuserwindow').down('form').down('combobox').setValue(value);
            	}
            },
            'updateuserwindow':{
            	afterrender:function(updateuserwindow){
            		console.log(updateuserwindow.title + '渲染完毕...');
//            		console.log(Ext.getCmp('updateuserwindow').down('form').down('textfield[name=password]').getValue());
            		updateuserwindow.down('button[action=save]').on('click',function(button){
            			updateuserwindow.down('form').submit({
				    		clientValidation: true,
						    url: 'user/update',
						    params:{'rolename':updateuserwindow.down('form').down('combobox').getValue(),'username':updateuserwindow.down('form').down('textfield[name=username]').getValue()},
						    success: function(form, action) {
						    	if(action.result.success){
							       Ext.example.msg('','<p align="center">'+action.result.message+'</p>');
							       updateuserwindow.close();
							       Ext.getCmp('usersgrid').getStore().reload();
						    	}else{
						    		Ext.Msg.alert('提示','<p align="center">'+action.result.message+'</p>');
						    	}
						    },
						    failure: function(form, action) {
						    	Ext.example.msg('','<p align="center">'+action.result.message+'</p>');
						        switch (action.failureType) {
						            case Ext.form.action.Action.CLIENT_INVALID:
						                Ext.Msg.alert('Failure', '提交表单中包含非法字符(或必填项为空)！');
						                break;
						            case Ext.form.action.Action.CONNECT_FAILURE:
						                Ext.Msg.alert('Failure', 'Ajax请求失败');
						                break;
						            case Ext.form.action.Action.SERVER_INVALID:
						               Ext.Msg.alert('Failure', action.result.msg);
						       }
						    }
				    	
            			});
            		},this)
            	}
            },
            'passportpanel':{
            	afterrender:function(panel){
            		console.log(panel.title + '渲染完毕...');
            		panel.down('button[action=add]').on('click',function(){
                		this.addUser();
					},this);
            	}
            },
            'rightsgrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            	}
            },
            'authoritypanel':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title+'渲染完毕。。。。');
            	}
            },
            'userwindow':{
            	afterrender:function(window){
            		var me = this;
            		window.down('button[action=submit]').on('click',function(){
            			window.getComponent('userform').form.submit({
				    		clientValidation: true,
						    url: 'user/save',
						    params: {
						        'rolename':window.down('form').down('combobox').getValue()					        
						    },
						    success: function(form, action) {
						    	if(action.result.success){
							       Ext.example.msg('','<p align="center">'+action.result.message+'</p>');
							       window.close();
							       Ext.getCmp('usersgrid').getStore().reload();
						    	}else{
						    		Ext.Msg.alert('提示','<p align="center">'+action.result.message+'</p>');
						    	}
						    },
						    failure: function(form, action) {
						    	Ext.example.msg('','<p align="center">'+action.result.message+'</p>');
						        switch (action.failureType) {
						            case Ext.form.action.Action.CLIENT_INVALID:
						                Ext.Msg.alert('Failure', '提交表单中包含非法字符(或必填项为空)！');
						                break;
						            case Ext.form.action.Action.CONNECT_FAILURE:
						                Ext.Msg.alert('Failure', 'Ajax请求失败');
						                break;
						            case Ext.form.action.Action.SERVER_INVALID:
						               Ext.Msg.alert('Failure', action.result.msg);
						       }
						    }
				    	});
            		});
            		//重置按钮
            		window.down('button[action=reset]').on('click',function(){
            			window.getComponent('serviceform').form.reset()
            		});
            	}
            }
        });
    },
    refreshUserGrid:function(){
    	this.getUsersgrid().getStore().reload();
    },
    addUser:function(){
//    	var userWindows = Ext.ComponentQuery.query('userwindow');
//    	if(userWindows.length == 0){
    		Ext.widget('userwindow',{
    			title:'添加用户',
    			id:'userwindow'
    		}).show();    		
//    	}else{
//    		userwindow.show();
//    	}
    }
});