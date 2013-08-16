package com.eaglec.plat.biz.impl.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eaglec.plat.biz.auth.RightsManagerBiz;
import com.eaglec.plat.dao.auth.RightsDao;
import com.eaglec.plat.domain.auth.Rights;

@Service
public class RightsManagerBizImpl implements RightsManagerBiz {
	
	@Autowired
	private RightsDao rightsDao;

	@Override
	public Rights saveRights(Rights rights) {
		// TODO Auto-generated method stub
		return rightsDao.save(rights);
	}

	@Override
	public List<Rights> queryRights() {
		// TODO Auto-generated method stub
			return rightsDao.findList("from Rights");
	}

	@Override
	public void deleteRights(Rights rights) {
		// TODO Auto-generated method stub
		rightsDao.delete(rights);
	}
	
	

}
