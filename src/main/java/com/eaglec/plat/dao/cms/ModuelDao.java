package com.eaglec.plat.dao.cms;

import java.util.List;

import com.eaglec.plat.dao.BaseDao;
import com.eaglec.plat.domain.cms.Module;

public interface ModuelDao extends BaseDao<Module>{
	
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：获取该频道下的所有色块
	 */
	public List<Module> findAll();
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：获取所有的模版
	 */
	public List<?> findAllTempplate();
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：添加频道
	 */
	public void add(Module m);
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：删除频道
	 */
	public void delete(Module m);
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：修改频道
	 */
	public Module update(Module m);
}




