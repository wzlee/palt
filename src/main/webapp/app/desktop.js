Ext.Loader.setPath({
    'Ext.ux.desktop': 'app/ux',
    Plat: 'app',
    module:'app/module'
});

Ext.require('Plat.App');

var PlatApp;
Ext.onReady(function () {
    PlatApp = new Plat.App();
});