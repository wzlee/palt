/**
 * Servive Model
 */
Ext.define('plat.model.service.ServiceModel', {
    extend: 'Ext.data.Model',
    fields: ['id','serviceNo','serviceSource','serviceOrg.id','serviceOrg.orgName','category.id','category.text','serviceName','registerTime','serviceNum','linkMan','tel','email','serviceObject','serviceMethod','serviceProcedure','chargeMethod','currentStatus','lastStatus']
});
