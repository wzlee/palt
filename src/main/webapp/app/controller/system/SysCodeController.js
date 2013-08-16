Ext.define('plat.controller.system.SysCodeController', {
	extend: 'Ext.app.Controller',
	
	stores:['system.SysCodeStore'],
    views: [
    		'system.SysCodeGrid'
    		],//声明该控制层要用到的view
    refs: [//相当于一个映射,这样就可以在控制层方便的通过geter取得相应的对象了
	        {
	            ref: 'syscodegrid',
	            selector: 'syscodegrid'
	        }
    ],
    init:function(){
    	this.control({
    		'syscodegrid': {
                afterrender:function(gridpanel){
                	console.log(gridpanel.title + '渲染完毕...');
                }
            }
    	});
    }
});