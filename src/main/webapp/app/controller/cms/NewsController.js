Ext.define('plat.controller.cms.NewsController', {
	extend : 'Ext.app.Controller',
	views : ['cms.NewsGrid', 'cms.NewsWin', 'cms.NewsForm',
		'public.UploadWin', 'public.UploadForm'
	],
	stores : ['cms.NewsStore'],
	models : ['cms.NewsModel'],
	init : function () {
		this.control({
			"newsgrid" : {
				afterrender:function(gridpanel){
					gridpanel.down('button[name=add]').on('click',function(){
                		this.addNews();
					}, this);
					gridpanel.down('button[name=modify]').on('click',function(){
                		this.modifyNews();
					}, this);
					gridpanel.down('button[name=delete]').on('click',function(){
                		this.deleteNews();
					}, this);
            	},
            	itemdblclick:function(grid, record, item, index, e, eOpts){
            		this.modifyNews();
            	}
			},
			"newsform" : {
				afterrender : function (form) {
            		form.down('button[name=select]').on('click', function () {
            			this.selectPic();
            		}, this);
            	}
			},
			"newswindow" : {
				afterrender : function (window, opts) {
            		var options = {
        				clientValidation: true,
					    success: function(form, action) {
					    	if (action.result.success) {
						       Ext.example.msg('提示', action.result.message);
						       form.reset();
						       window.hide();
						       Ext.ComponentQuery.query('newsgrid')[0].getStore().reload();
					    	} else {
					    		Ext.Msg.alert('提示','<p align="center">'+action.result.message+'</p>');
					    	}
					    },
					    failure: function(form, action) {
					        switch (action.failureType) {
					            case Ext.form.action.Action.CLIENT_INVALID:
						            Ext.Msg.alert('Failure', '提交表单中包含非法字符(或必填项为空)！');
					                break;
					            case Ext.form.action.Action.CONNECT_FAILURE:
					                Ext.Msg.alert('Failure', '<p align="center">Ajax请求失败</p>');
					                break;
					            case Ext.form.action.Action.SERVER_INVALID:
					               Ext.Msg.alert('Failure', '<p align="center">' + 
					               	action.result.msg + '</p>');
					       }
					    }
        			};
            		window.down('button[name=add]').on('click', function () {
            			var form = Ext.ComponentQuery.query('newsform')[0];
            			options.url = 'news/add';
            			form.getForm().submit(options);
            		});
            		window.down('button[name=modify]').on('click', function () {
            			var form = Ext.ComponentQuery.query('newsform')[0];
            			options.url = 'news/update';
            			form.getForm().submit(options);
            		});
            		window.down('button[name=cancel]').on('click', function () {
            			var Eform = window.query('newsform')[0];
            			Eform.getForm().reset();
            			window.hide();
            		});
            		
            	}
			},
			"uploadwindow" : {
				afterrender : function (window, opts) {
					window.down('button[name=submit]').on('click', function () {
            			this.uplodImage();
            		}, this);
            		window.down('button[name=cancel]').on('click', function () {
            			window.hide();
            		}, this);
				}
			}
		})
	},
	
	
	addNews : function () {
    	var newsWindows = Ext.ComponentQuery.query('newswindow')[0];
    	if (!newsWindows) {
    		newsWindows = Ext.widget('newswindow',{
    			title:'添加新闻'
    		}).show();
    	} else {
    		newsWindows.setTitle('添加新闻');
    		newsWindows.show();
    	}
    	newsWindows.down('button[name=modify]').hide();
    	newsWindows.down('button[name=add]').show();
    },
    modifyNews : function () {	//修改新闻表单
    	var grid = Ext.ComponentQuery.query('newsgrid')[0];
    	var records = grid.getSelectionModel().getSelection();
    	if (records.length < 1) {
    		Ext.Msg.show({
			    title: '提示',
			    msg: '请选择一条记录',
			    width: 180,
			    buttons: Ext.Msg.OK,
			    icon: Ext.MessageBox.INFO
			});
			return;
    	}
    	var newsWindows = Ext.ComponentQuery.query('newswindow')[0];
    	if (!newsWindows) {
    		newsWindows = Ext.widget('newswindow',{
    			title:'修改新闻'
    		}).show();
    	} else {
    		newsWindows.setTitle('修改新闻');
    		newsWindows.show();
    	}
    	var Eform = Ext.ComponentQuery.query('newsform')[0];
    	Eform.getForm().loadRecord(records[0]);
    	var EoriginalPic = Eform.query('textfield[name=originalPic]')[0];
		if (records[0].data.picture) {	//当新闻图片存在时，隐藏输入框做标记
			EoriginalPic.setValue(records[0].data.picture);
		}
    	newsWindows.down('button[name=modify]').show();
    	newsWindows.down('button[name=add]').hide();
    },
	selectPic : function () {
		var picWindow = Ext.ComponentQuery.query('uploadwindow[name=news]')[0];
    	if(!picWindow){
    		Ext.widget('uploadwindow',{
    			title : '上传',
    			name : 'news'
    		}).show();
    	}else{
    		picWindow.show();
    	}
	},
	deleteNews : function () {
		var grid = Ext.ComponentQuery.query('newsgrid')[0];
    	var records = grid.getSelectionModel().getSelection();
    	if (records.length < 1) {
    		Ext.Msg.show({
			    title: '提示',
			    msg: '请选择一条记录',
			    width: 180,
			    buttons: Ext.Msg.OK,
			    icon: Ext.MessageBox.INFO
			});
			return;
    	}
    	Ext.MessageBox.confirm('警告','确定删除该新闻吗?',function(btn){
    		if(btn == 'yes'){
		    	grid.getStore().remove(records[0]);
    		}
    	});
	},
	uplodImage : function () {
		var Ewindow = Ext.ComponentQuery.query('uploadwindow')[0];
		var Eform = Ewindow.query('uploadform')[0];
		Eform.getForm().submit({
			url : 'public/uploadFile',
			clientValidation: true,
		    success: function(form, action) {
		    	if (action.result.success) {
			       var EnewsForm = Ext.ComponentQuery.query('newsform')[0];
			       var Epicture = EnewsForm.down('textfield[name=picture]');
			       Epicture.setValue(action.result.message);
			       form.reset();
			       Ewindow.hide();
		    	} else {
		    		Ext.Msg.alert('提示','<p align="center">'+action.result.message+'</p>');
		    	}
		    },
		    failure: function(form, action) {
		        switch (action.failureType) {
		            case Ext.form.action.Action.CLIENT_INVALID:
		                break;
		            case Ext.form.action.Action.CONNECT_FAILURE:
		                Ext.Msg.alert('Failure', '<p align="center">Ajax请求失败</p>');
		                break;
		            case Ext.form.action.Action.SERVER_INVALID:
		               Ext.Msg.alert('Failure', '<p align="center">' + 
		               	action.result.msg + '</p>');
		       }
		    }
		});
		Ewindow.hide();
	}
});