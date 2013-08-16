var window ,form;
Ext.onReady(function(){
	form = new Ext.form.Panel({
				id:'form',
				bodyStyle:'padding:10 15',
				items:[
					{
						layout:'column',
						defaults:{
							labelAlign:'right'
						},
						bodyPadding: 5,
						items:[
							{
								xtype:'textfield',
								name:'name',
								columnWidth:.4,
								fieldLabel:'姓名'
							},
							{
								xtype:'fieldcontainer',
		//						name:'sex',
								layout:'hbox',
								columnWidth:.6,
								defaultType:'radiofield',
								fieldLabel:'性别',
								items:[
									{
					                    boxLabel  : '女',
					                    name      : 'sex',
					                    inputValue: '1'
					                }, {
					                    boxLabel  : '男',
					                    name      : 'sex',
					                    inputValue: '2',
					                    checked   : true
					                }
								]
							}
						]
					},
					{
						xtype:'filefield',
						name:'image',
						width:400,
						bodyPadding: '5 0 5 5',
						labelAlign:'right',
						fieldLabel:'图片'
					},
					{
						xtype:'filefield',
						name:'file',
						width:400,
						bodyPadding: '5 0 5 5',
						labelAlign:'right',
						fieldLabel:'文件'
					}
				]
			});
	window = new Ext.window.Window({
		title:'ceshi',
		width:600,
		height:500,
		maximizable:true,
		minimizable :true,
		layout:'fit',
		buttonAlign:'center',
		buttons: [
		  { 
		  	text: '提交',
		  	iconCls:'icon-windows',
		  	handler:function(){
		  		form.getForm().submit({
				    clientValidation: true,
				    url: 'public/upload',
				    params: {
				        newStatus: 'delivered'
				    },
				    success: function(form, action) {
				       Ext.Msg.alert('Success', action.result.msg);
				    },
				    failure: function(form, action) {
				        switch (action.failureType) {
				            case Ext.form.action.Action.CLIENT_INVALID:
				                Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
				                break;
				            case Ext.form.action.Action.CONNECT_FAILURE:
				                Ext.Msg.alert('Failure', 'Ajax communication failed');
				                break;
				            case Ext.form.action.Action.SERVER_INVALID:
				               Ext.Msg.alert('Failure', action.result.msg);
				       }
				    }
				});
		  	}
		  }
		],
		items:[
			form
		]
	}).show();
}
)