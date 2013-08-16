package com.eaglec.plat.dao.cms;

import java.util.List;

import com.eaglec.plat.dao.BaseDao;
import com.eaglec.plat.domain.cms.Channel;

public interface ChannelDao extends BaseDao<Channel>{
	
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：获取所有的频道
	 */
	public List<Channel> findAll();
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：添加频道
	 */
	public void add(Channel c);
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：删除频道
	 */
	public void delete(Channel c);
	/**
	 * @date: 2013-8-14
	 * @author：lwch
	 * @description：修改频道
	 */
	public Channel update(Channel c);

}
