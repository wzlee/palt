package com.eaglec.plat.utils;

/**
 * Plat中存在的数据状态常量
 * 
 * @author Xiadi
 * @since 2013-8-13
 */
public class Constant {
	/*---------------Service-------------------*/
	/**
	 * 新服务
	 */
	public final static String SERVICE_STATUS_NEW = "新服务";

	/**
	 * 上架审核中
	 */
	public final static String SERVICE_STATUS_ADDED_AUDIT = "上架审核中";

	/**
	 * 已上架
	 */
	public final static String SERVICE_STATUS_ADDED = "已上架";

	/**
	 * 变更审核中
	 */
	public final static String SERVICE_STATUS_CHANGE_AUDIT = "变更审核中";

	/**
	 * 已删除
	 */
	public final static String SERVICE_STATUS_DELETEED = "已删除";

	/**
	 * 已下架
	 */
	public final static String SERVICE_STATUS_DOWN = "已下架";

	/**
	 * 下架审核中
	 */
	public final static String SERVICE_STATUS_DOWN_AUDIT = "下架审核中";
	
	public final static String SERVICE_SOURCE_PLAT = "运营平台";
	
	public final static String SERVICE_SOURCE_ORG = "服务机构";
	
	
	
	/*---------------ServiceDetail-------------------*/
	/**
	 * 未通过
	 */
	public final static String SERVICE_AUDIT_FAIL = "未通过";

	/**
	 * 通过
	 */
	public final static String SERVICE_AUDIT_PASS = "通过";
}
