/**
 * 布局控制层
 */
Ext.define('plat.controller.MainController', {
    extend: 'Ext.app.Controller',
    alias:'widget.maincontroller',
    
    views: [
    		'layout.LoginFormView',
    		'layout.LoginWindowView',
    		'layout.WelcomeView',
    		'layout.MenuPanelView',
    		'layout.ContentTabView',
    		'layout.SystemMenuView',
    		'layout.SystemWindowView',
    		'layout.PasswordWindowView'
    		],
    refs: [
    		{
	            ref: 'loginform',
	            selector: 'loginform'
	        },
	        {
	            ref: 'loginwindwo',
	            selector: 'loginwindwo'
	        },
	        {
	            ref: 'welcomepanel',
	            selector: 'welcomepanel'
	        },
	        {
	            ref: 'menupanel',
	            selector: 'menupanel'
	        },
	        {
	            ref: 'systemmenu',
	            selector: 'systemmenu'
	        },
	        {
	            ref: 'systemwindow',
	            selector: 'systemwindow'
	        },
	        {
	            ref: 'passwordwindow',
	            selector: 'passwordwindow'
	        },
        	{
	            ref: 'contenttab',
	            selector: 'contenttab'
	        }
    ],
    init: function() {
        this.control({
        	'loginform':{
    			afterrender:function(loginform){
    				this.loadCookies(loginform);
					loginform.down('textfield[name=password]').on('specialkey',function(field,e){
						 // e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
                    	// e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
	                    if (e.getKey() == e.ENTER) {
                       		this.formSubmit(loginform);
	                    }
					},this);
    				loginform.down('button[action=login]').on('click',function(){
                		if(loginform.form.isValid()){
//    						var md5_password = hex_md5(loginform.down('textfield[name=password]').getValue());
                			if(loginform.down('checkbox[name=rusername]').getValue()){Ext.util.Cookies.set("username",loginform.down('textfield[name=username]').getValue());};
                			if(loginform.down('checkbox[name=rpassword]').getValue()){Ext.util.Cookies.set("user",loginform.down('textfield[name=username]').getValue()+'|'+loginform.down('textfield[name=password]').getValue());};
//                			loginform.down('textfield[name=password]').setValue(md5_password);
                			this.formSubmit(loginform);
                		};
					},this);
					loginform.down('button[action=reset]').on('click',function(){loginform.form.reset();},this);
    			}
    		},
        	'welcomepanel':{
        		afterrender:function(formpanel){
        			this.showCurrentTime(formpanel.down('displayfield[name=currenttime]'));
//        			this.loadUserInfo(topform);
        		}
        	},
            'menupanel > treepanel':{
            	afterrender:function(treepanel){
            		treepanel.on('itemclick',function(view,record,item,index){
//            			console.log(record.data.qtip);
						if(record.data.leaf){
//							this.loadController(record.raw.controller);
							this.addPanel(record.data.text,record.data.idxtype);
						}
					},this);
            	}
            },
            'contenttab':{
            	beforeadd:function(tab,panel,index){
//            		Ext.getBody().mask("界面渲染中...");
            		console.log(tab.title + '加入组件:'+ panel.title);
            	},
            	afterlayout:function(tab,layout){
//            		Ext.getBody().unmask();
            		console.log(tab.title + '布局完毕...');
            	},
            	remove:function(tab,panel){
            		console.log(tab.title + '移除组件:'+ panel.title);
            	}
            }
        });
    },
    loadCookies:function(loginform){
    	if(Ext.util.Cookies.get("user")){
    		loginform.down('textfield[name=username]').setValue(Ext.util.Cookies.get("user").split('|')[0]);
			loginform.down('textfield[name=password]').setValue(Ext.util.Cookies.get("user").split('|')[1]);
    	}else if(Ext.util.Cookies.get("username")){
    		loginform.down('textfield[name=username]').setValue(Ext.util.Cookies.get("username"));
    		loginform.down('textfield[name=password]').focus();
    	}else{
    		return;
    	}
    },
    formSubmit:function(formpanel){
    	formpanel.getEl().mask("登陆验证中,请稍候...");
    	Ext.Ajax.request({
//			clientValidation: true,
		    type:'POST',
		    url: 'public/login',
		    params:{'password':Ext.ux.MD5.hex_md5(formpanel.down('textfield[name=password]').getValue()),'username':formpanel.down('textfield[name=username]').getValue()},
		    success: function(response) {
		    	formpanel.getEl().unmask();
		    	var result = Ext.decode(response.responseText);
		    	if(result.success){
			    	formpanel.ownerCt.hide();
			    	Ext.getBody().mask("登陆成功！主界面渲染中,请稍候...");
	    			Ext.create('Ext.container.Viewport', {
			            layout: 'border',
			            items: [
			    				{
				        			xtype:'menupanel',
				        			region:'west',
				        			width:250,
				        			collapsible:true,
				        			split:true
				        		},
				                {
				                    xtype: 'contenttab',
				                    region:'center'
				                }
				        	]
			        });
			        Ext.getBody().unmask();
		    	}else{
		    		Ext.example.msg('登陆失败!',result.message);
		    	}
		    },
		    failure: function(form, action) {
		    	formpanel.getEl().unmask();
		        switch (action.failureType) {
		            case Ext.form.action.Action.CLIENT_INVALID:
		                Ext.example.msg('登录失败!', '请核对是否输入不合法的字符!');
		                break;
		            case Ext.form.action.Action.CONNECT_FAILURE:
		                Ext.example.msg('登录失败!', 'Ajax请求失败!');
		                break;
		            case Ext.form.action.Action.SERVER_INVALID:
	            		formpanel.down('textfield[name='+action.result.errorfield+']').markInvalid(action.result.message);
	              		formpanel.down('textfield[name='+action.result.errorfield+']').focus();
		       }
		    }
		});
    },
    showCurrentTime:function(ev,type){   
		var Y,M,D,W,H,I,S;   
		function fillZero(v){   
			if(v<10){v='0'+v;}   
			return v;   
		}
		(function(){   
		 	var d=new Date();   
			var Week=['星期天','星期一','星期二','星期三','星期四','星期五','星期六'];   
			Y=d.getFullYear();   
			M=fillZero(d.getMonth()+1);   
			D=fillZero(d.getDate());   
			W=Week[d.getDay()];   
			H=fillZero(d.getHours());   
			I=fillZero(d.getMinutes());   
			S=fillZero(d.getSeconds());   
			if(type && type==12){   
				if(H<=12){   
					H='上午 '+H;   
				}else if(H>12 && H<24){   
					H-=12;   
					H='下午 '+fillZero(H);   
				}else if(H==24){   
					H='下午 00';   
				}   
			}   
			ev.setValue(Y+'年'+M+'月'+D+'日 '+' '+W+' '+H+':'+I+':'+S);   
			setTimeout(arguments.callee,1000);   
		})();   
	},
    collapseAll:function(){
    	this.getMenutree().collapseAll();
    },
    expandAll:function(){
    	this.getMenutree().expandAll();
    },
    loadController:function(controller){
    	this.getController(controller);
    },
    addPanel:function(title,id_xtype){
    	var id = id_xtype.split('|')[0];
    	var xtype = id_xtype.split('|')[1];
    	var contenttab = this.getContenttab();
    	var component = contenttab.getComponent(id);
    	if(!component){
    		contenttab.getEl().mask("组件初始化中,请稍候...");
    		if(Ext.ClassManager.getNameByAlias('widget.'+xtype)){
	    		component = Ext.widget(xtype,{
	    			title:title,
	    			id:id
	    		});
	    		contenttab.add(component).show();
    		}else{
    			Ext.example.msg('','<p align="center">模块建设中,敬请期待!</p>');
    		}
    	}else{
    		contenttab.setActiveTab(component);
    	}
    	contenttab.getEl().unmask();
    }
});