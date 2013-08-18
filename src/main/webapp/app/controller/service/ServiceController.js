Ext.define('plat.controller.service.ServiceController', {
    extend: 'Ext.app.Controller',
    
    alias:'widget.servicecontroller',
    
    stores: [
				'service.ServiceStore',
				'service.UServiceStore',
				'service.DServiceStore',
				'service.RServiceStore',
				'service.AServiceStore',
				'service.NServiceStore',
				'service.QServiceStore'
			],
    views: [
    			'service.ServicePanel',
    			'layout.combo.CategoryCombo',
    			'layout.combo.SMethodCombo',
    			'layout.combo.SObjectCombo',
    			'layout.combo.SOrgCombo',
    			'layout.combo.BClassCombo',
    			'layout.combo.MClassCombo',
    			'layout.combo.ServiceOrgCombo',
    			'service.ServiceGrid',
    			'service.NServiceGrid',
    			'service.UServiceGrid',
    			'service.DServiceGrid',
    			'service.RServiceGrid',
    			'service.AServiceGrid',
    			'service.ServiceEditWindow',
    			'service.ServiceDetailWindow',
    			'service.UServiceWindow',
    			'service.QServiceGrid',
    			'service.QServicePanel',
    			'layout.combo.ServiceStatus',
    			'service.QServiceWindow'
    		],
    refs: [
    		{
    			ref:'servicepanel',
    			selector:'servicepanel'
    		},
    		{
    			ref:'categorygrid',
    			selector:'categorygrid'
    		},
    		{
    			ref:'servicegrid',
    			selector:'servicegrid'
    		},
    		{
    			ref:'uservicestore',
    			selector:'uservicestore'
    		},
    		{
    			ref:'dservicestore',
    			selector:'dservicestore'
    		},
    		{
    			ref:'nservicestore',
    			selector:'nservicestore'
    		},
    		{
    			ref:'qservicestore',
    			selector:'qservicestore'
    		},
    		{
    			ref:'nservicegrid',
    			selector:'nservicegrid'
    		},
    		{
    			ref:'uservicegrid',
    			selector:'uservicegrid'
    		},
    		{
    			ref:'dservicegrid',
    			selector:'dservicegrid'
    		},
    		{
    			ref:'rservicegrid',
    			selector:'rservicegrid'
    		},
    		{
    			ref:'serviceeditwindow',
    			selector:'serviceeditwindow'
    		},
    		{
    			ref:'servicedetailwindow',
    			selector:'servicedetailwindow'
    		},
    		{
    			ref:'uservicewindow',
    			selector:'uservicewindow'
    		}
    ],
    
    init: function() {
        this.control({
        	'servicepanel':{
            	afterrender:function(panel){
            		console.log(panel.title + '渲染完毕...');
            	}
            },
            /*'servicestore':{
            	beforeload:function(store,options){
            		this.extraParams(store);
            	}
            	
            },
            'nservicestore':{
            	beforeload:function(store,options){
            		console.debug(this);
            		this.extraParams(store,"新服务");
            	}
            	
            },
            'uservicestore':{
            	beforeload:function(store,options){
            		this.extraParams(store);
            	}
            	
            },
            'dservicestore':{
            	beforeload:function(store,options){
            		this.extraParams(store);
            	}
            	
            },*/
            'qservicestore':{
            	beforeload:function(store,options){
            		this.extraParams(store);
            	}
            },
            /*'servicegrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            		gridpanel.down('button[action=search]').on('click',function(){
                		gridpanel.getStore().load({params:{status:"01"}});
					},this);
					gridpanel.down('button[action=add]').on('click',function(){
                		this.addService();
					},this);
        			gridpanel.down('textfield[name=sname]').on('specialkey',function(field,e){
        				if (e.getKey() == e.ENTER) {
                       		gridpanel.getStore().load();
	                    }
					},this);
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.updateService(record);
            	}
            },*/
            'nservicegrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            		gridpanel.down('button[action=search]').on('click',function(){
            			gridpanel.getStore().load();
					},this);
					gridpanel.down('button[action=add]').on('click',function(){
                		this.addService();
					},this);
					gridpanel.down('button[action=sync]').on('click',function(){
                		gridpanel.getStore().sync();
					},this);
        			gridpanel.down('textfield[name=serviceName]').on('specialkey',function(field,e){
        				if (e.getKey() == e.ENTER) {
        					if(!field.getValue()){
        						gridpanel.getStore().load();
        					}else {
        						gridpanel.getStore().load({params:{serviceName:field.getValue()}});
        					}
                       		
	                    }
					},this);
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.showServiceDetail(record);
            	}
            },
            'uservicegrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            		gridpanel.getStore().on('beforeload',function(store){
            			Ext.apply(store.proxy.extraParams, {queryStatus:"已上架','变更审核中','下架审核中",serviceName:gridpanel.down('textfield[name=serviceName]').getValue()});
            		});
            		gridpanel.down('button[action=search]').on('click',function(){
            			gridpanel.getStore().load({params:{queryStatus:"已上架','变更审核中','下架审核中",serviceName:gridpanel.down('textfield[name=serviceName]').getValue()}});
					},this);
        			gridpanel.down('textfield[name=serviceName]').on('specialkey',function(field,e){
        				if (e.getKey() == e.ENTER) {
        					if(!Ext.getCmp('serviceName').getValue()){
        						gridpanel.getStore().load({params:{queryStatus:"已上架','变更审核中','下架审核中"}});
        					}else {
        						gridpanel.getStore().load({params:{queryStatus:"已上架','变更审核中','下架审核中",serviceName:gridpanel.down('textfield[name=serviceName]').getValue()}});
        					}
                       		
	                    }
					},this);
					gridpanel.getStore().load({params:{queryStatus:"已上架','变更审核中','下架审核中"}});
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.serviceDetail(record);
            	}
            },
             'dservicegrid':{
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            		gridpanel.getStore().on('beforeload',function(store){
            			Ext.apply(store.proxy.extraParams, {queryStatus:"已下架','上架审核中",serviceName:gridpanel.down('textfield[name=serviceName]').getValue()});
            		});
            		gridpanel.down('button[action=search]').on('click',function(){
            			gridpanel.getStore().load({params:{queryStatus:"已下架','上架审核中",serviceName:gridpanel.down('textfield[name=serviceName]').getValue()}});
					},this);
        			gridpanel.down('textfield[name=seviceName]').on('specialkey',function(field,e){
        				if (e.getKey() == e.ENTER) {
        					if(!Ext.getCmp('serviceName').getValue()){
        						gridpanel.getStore().load({params:{queryStatus:"已下架','上架审核中"}});
        					}else {
        						gridpanel.getStore().load({params:{queryStatus:"已下架','上架审核中",serviceName:gridpanel.down('textfield[name=serviceName]').getValue()}});
        					}
                       		
	                    }
					},this);
					gridpanel.getStore().load({params:{queryStatus:"已下架','上架审核中"}});
        					
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.updateService(record);
            	}
            },
            'rservicegrid':{	//已删除服务管理表
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');            		
            		gridpanel.getStore().on('beforeload',function(store){
            			Ext.apply(store.proxy.extraParams, {queryStatus:"已删除"});
            		});
            		gridpanel.down('button[action=search]').on('click',function(){            			
            			gridpanel.getStore().load(
            				{params:{
            					status:"已删除",
            					sname:gridpanel.down('textfield[name=serviceName]').getValue()
            				}});
					},this);
        			gridpanel.down('textfield[name=serviceName]').on('specialkey',function(field,e){        				
        				if (e.getKey() == e.ENTER) {
                       		gridpanel.getStore().load(
            				{params:{
            					status:"已删除",
            					sname:gridpanel.down('textfield[name=serviceName]').getValue()
            				}});
	                    }
					},this);
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.serviceDetail(record);
            	}
            },
            'aservicegrid':{	//服务审核表单
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');
            		gridpanel.down('button[action=search]').on('click',function(){
            			this.extraParams(store, "")
                		gridpanel.getStore().load({params:{status:"06,02"}});
					},this);
        			gridpanel.down('textfield[name=sname]').on('specialkey',function(field,e){
        				if (e.getKey() == e.ENTER) {
                       		gridpanel.getStore().load();
	                    }
					},this);
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.updateService(record);
            	}
            },
            'qservicegrid':{   	//服务综合查询表格
            	afterrender:function(gridpanel){
            		console.log(gridpanel.title + '渲染完毕...');	
            		gridpanel.getStore().on('beforeload',function(store){
            			Ext.apply(store.proxy.extraParams, {status:gridpanel.down('combo[name=status]').getValue(),sname:gridpanel.down('textfield[name=sname]').getValue()});
            		});
            		gridpanel.down('button[action=search]').on('click',function(){
            			gridpanel.getStore().load(
            				{params:{
            					status:gridpanel.down('combo[name=status]').getValue(),
            					sname:gridpanel.down('textfield[name=sname]').getValue()
            				}});
					},this);
					gridpanel.down('textfield[name=sname]').on('specialkey',function(field,e){
        				if (e.getKey() == e.ENTER) {
                       		gridpanel.getStore().load();
	                    }
					},this);
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.serviceDetail(record);
            	}
            },
            'serviceeditwindow':{
            	afterrender:function(window){
            		var me = this;
            		window.down('button[action=submit]').on('click',function(){
//            			console.log(window.getComponent('serviceeditform').form.getValues());
            			console.log(window.getComponent('serviceeditform').form.getRecord().get('serviceObject'));
            			window.getComponent('serviceeditform').form.updateRecord(window.getComponent('serviceeditform').form.getRecord());
            			window.close();
//            			window.getComponent('serviceeditform').form.submit({
//				    		clientValidation: true,
//						    url: 'service/edit',
//						    params: {
//						        action: 'edit'						        
//						    },
//						    success: function(form, action) {
//						    	if(action.result.success){
//							       Ext.example.msg('提示','<p align="center">'+action.result.message+'</p>');
//							       window.hide();
//							       me.refreshService();
//						    	}else{
//						    		Ext.Msg.alert('提示','<p align="center">'+action.result.message+'</p>');
//						    	}
//						    },
//						    failure: function(form, action) {
//						        switch (action.failureType) {
//						            case Ext.form.action.Action.CLIENT_INVALID:
//						                Ext.Msg.alert('Failure', '提交表单中包含非法字符(或必填项为空)！');
//						                break;
//						            case Ext.form.action.Action.CONNECT_FAILURE:
//						                Ext.Msg.alert('Failure', 'Ajax请求失败');
//						                break;
//						            case Ext.form.action.Action.SERVER_INVALID:
//						               Ext.Msg.alert('Failure', action.result.msg);
//						       }
//						    }
//				    	});
            		});
            		window.down('button[action=reset]').on('click',function(){
            			window.getComponent('serviceeditform').form.reset()
            		});
            	}
            },
            'uservicewindow':{
            	afterrender:function(window){
            		var me = this;
            		window.down('button[action=submit]').on('click',function(){
            			window.getComponent('userviceform').form.submit({
				    		clientValidation: true,
						    url: 'service/updateComments',
						    params: {
						        action: 'update'						        
						    },
						    success: function(form, action) {
						    	if(action.result.success){
							       Ext.example.msg('提示','<p align="center">'+action.result.message+'</p>');
							       window.hide();
							       me.refreshService();
						    	}else{
						    		Ext.Msg.alert('提示','<p align="center">'+action.result.message+'</p>');
						    	}
						    },
						    failure: function(form, action) {
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
            		//关闭按钮
            		window.down('button[action=close]').on('click',function(){
            			window.close();
            		})
          		  }
            }
        });
    },
    extraParams:function(store,param){
    	Ext.apply(store.proxy.extraParams, {queryStatus:param,sname:this.getServiceGrid().down('textfield[name=sname]').getValue()});
    },
    
    qextraParams:function(store,param){	//参数持久化
    	Ext.apply(store.proxy.extraParams, {queryStatus:param,sname:this.getServiceGrid().down('textfield[name=sname]').getValue()});
    },
    
    loadService:function(cid){
    	this.getServicegrid().getStore().load({params:{cid:cid}});
    },
    refreshService:function(){
    	this.getNservicegrid().getStore().reload();
    },
    addService:function(record){
    	var addServiceWindows;
    	if(!addServiceWindows){
    		addServiceWindows = Ext.widget('serviceeditwindow',{
    			title:'添加新服务'
    		});    		
    	}
		addServiceWindows.show();
		addServiceWindows.getComponent('serviceeditform').form.reset();
    },
    showServiceDetail:function(record){
    	var serviceDetailWindows;
    	if(!serviceDetailWindows){
    		serviceDetailWindows = Ext.widget('servicedetailwindow',{
    			title:'服务详情['+record.data.serviceName+']'
    		});    		
    	}
		serviceDetailWindows.show();
		serviceDetailWindows.getComponent('servicedetailform').form.loadRecord(record);
    },
    updateService:function(record){
    	var serviceWindow;
    	var serviceWindows = Ext.ComponentQuery.query('servicewindow');
    	if(serviceWindows.length == 0){
    		serviceWindow = Ext.widget('servicewindow',{
    			title:'修改服务',
    			id:'servicewindow'
    		}).show();
    		serviceWindow.getComponent('serviceform').form.loadRecord(record);
    	}else{
    		serviceWindows[0].show();
    		serviceWindows[0].getComponent('serviceform').form.reset();
    	}
    },
    serviceDetail:function(record){
    	var serviceWindow;
    	var serviceWindows = Ext.ComponentQuery.query('qservicewindow');
    	if(serviceWindows.length == 0){
    		serviceWindow = Ext.widget('qservicewindow',{
    			title:'服务详情',
    			id:'qservicewindow'
    		}).show();
    		serviceWindow.getComponent('serviceform').form.loadRecord(record);
    	}else{
    		serviceWindows[0].show();
    		serviceWindows[0].getComponent('serviceform').form.reset();
    	}
    }
});