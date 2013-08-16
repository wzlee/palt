package com.eaglec.plat.biz.publik;

import java.util.List;

import com.eaglec.plat.domain.Category;

/**
 * 服务类别Service
 * 封装了对服务类别的操作
 * 
 * @author xuwf
 * @since 2013-8-13
 *
 */
public interface CategoryBiz {
	
	/**
	 * 查询所有服务类别
	 *
	 *@author xuwf
	 *@since 2013-8-13
	 *
	 * @return 类别列表
	 */
	public List<Category> findAll();
	
	/**
	 * 根据clazz加载类别
	 *
	 *@author lizw
	 *@since 2013-8-14
	 *
	 * @return 类别列表
	 */
	public List<Category> findCategoryByClazzAndPid(String clazz,int pid);
}
