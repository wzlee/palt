var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';

Ext.define('plat.view.cms.NewsForm', {
	extend : 'Ext.form.Panel',
	xtype: 'newsform',
    frame: true,
    bodyPadding: '5 5 0',
    fieldDefaults: {
        labelAlign: 'right',
        msgTarget: 'side',
        labelWidth: 80
    },
    init : function () {
    	console.log('NewsForm was initialized!!!');
    	this.callParent(arguments);
    },
    items: [{
        xtype: 'container',
        anchor: '100%',
        layout: 'hbox',
        items:[{
            xtype: 'container',
            flex: 1,
            layout: 'anchor',
            defaults : {
			    anchor:'100%'        
            },
            items: [{
                xtype:'textfield',
                fieldLabel: '标题',
                afterLabelTextTpl: required,
                allowBlank: false,
                name: 'title'
            }, {
                xtype:'textfield',
                fieldLabel: '发布人',
                allowBlank: false,
                afterLabelTextTpl: required,
                name: 'author'
            }, {
                xtype:'textfield',
                fieldLabel: '来源',
                allowBlank: false,
                afterLabelTextTpl: required,
                name: 'source'
            }]
        }, {
            xtype: 'container',
            flex: 1,
            layout: 'anchor',
            defaults : {
				anchor:'100%'	            
            },
            items: [{
                xtype:'combo',
                fieldLabel: '类别',
                afterLabelTextTpl: required,
                allowBlank: false,
                name: 'cid',
			    queryMode: 'local',
			    displayField: 'text',
			    valueField: 'value',
			    editable : false,
			    store:  Ext.create('Ext.data.Store', {
				    fields: ['value', 'text'],
				    data : [
				        {"value" : 1, "text" : "展会信息"},
				        {"value" : 2, "text" : "最新推荐"},
				        {"value" : 3, "text" : "政策法规"},
				        {"value" : 4, "text" : "最新公告"},
				        {"value" : 5, "text" : "新闻动态"}
				 ]})
            }, {
                xtype:'combo',
                fieldLabel: '显示位置',
                afterLabelTextTpl: required,
                allowBlank: false,
                editable : false,
                name: 'isTop',
                queryMode: 'local',
			    displayField: 'text',
			    valueField: 'value',
			    store:  Ext.create('Ext.data.Store', {
				    fields: ['value', 'text'],
				    data : [
				        {"value" : false, "text" : "默认"},
				        {"value" : true, "text" : "置顶"}
				 ]})
            }, {
            	xtype: 'container',
		        anchor: '100%',
		        layout: 'hbox',
		        items : [{
		        	xtype:'textfield',
	                fieldLabel: '配图',
	                name: 'picture',
	                readOnly : true,
	                flex : 1
		        }, {
		        	xtype : 'button',
		        	name : 'select',
		        	icon : 'jsLib/extjs/resources/themes/icons/add1.png'
		        }]
            	
            }]
        }]
    }, {
        xtype: 'htmleditor',
        name: 'content',
        height: 200,
        anchor: '100%'
    }, {
    	xtype : 'textfield',
    	hidden : true,
    	name : 'id'
    }, {
    	xtype : 'textfield',
    	hidden : true,
    	name : 'pubdate'
    }, {
    	xtype : 'textfield',
    	hidden : true,
    	name : 'originalPic'
    }]/*,

    buttons: [{
        text: 'Save',
        handler: function() {
            this.up('form').getForm().isValid();
        }
    },{
        text: 'Cancel',
        handler: function() {
            this.up('form').getForm().reset();
        }
    }]*/
});

