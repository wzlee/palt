package com.eaglec.plat.biz.auth;

import java.io.Serializable;
import java.util.List;

import com.eaglec.plat.domain.auth.Rights;


/**
 * @author cs
 *权限的crud
 */
public interface RightsManagerBiz {
	//添加权限
	public Rights saveRights(Rights rights);
	//查询
	public List<Rights> queryRights();
	//删除
	public void deleteRights(Rights rights);
	

}
