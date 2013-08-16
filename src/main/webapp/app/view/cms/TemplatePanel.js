Ext.define('plat.view.cms.TemplatePanel',{
	extend:'Ext.panel.Panel',
	alias:'widget.templatePanel',
    border : false,
    region : 'center',
    title: '频道模版',
    layout:'column',
    autoScroll:true,
    defaults: {
        layout: 'anchor',
        defaults: {
            anchor: '100%',
            style: {
            	border: '0px #C7C1BB solid'
            }
        }
    },
    initComponent: function() {
        this.callParent();
    },
    tbar : [{
    	xtype : 'label',
    	text : '请选择模版：',
        forId: 'myFieldId',
        margin: '0 10',
    	scope : this
    }, {
    	xtype: 'combobox',
        width:135,
    	hideLabel: true,
    	valueField: 'mtcode',
        store: 'cms.TemplateStore',
        displayField: 'mtname',
        typeAhead: true,
        queryMode: 'local',
        triggerAction: 'all',
        emptyText:'请选择模版……',
        selectOnFocus:true
    }],
    items: [{
        columnWidth: 1/5,
        baseCls:'x-plain',
        bodyStyle:'padding:5px 0 5px 5px;',
        items:[{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        }]
    },{
        columnWidth: 1/5,
        baseCls:'x-plain',
        bodyStyle:'padding:5px 0 5px 5px',
        items:[{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        }]
    },{
        columnWidth: 1/5,
        baseCls:'x-plain',
        bodyStyle:'padding:5px',
        items:[{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        }]
    },{
        columnWidth: 1/5,
        baseCls:'x-plain',
        bodyStyle:'padding:5px',
        items:[{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        }]
    },{
        columnWidth: 1/5,
        baseCls:'x-plain',
        bodyStyle:'padding:5px',
        items:[{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        },{
        	xtype: 'panel',
        	action: 'model',
        	height: 50,
            html: ''
        }]
    }]
});

