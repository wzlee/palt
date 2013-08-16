package com.eaglec.plat.dao.impl.auth;

import org.springframework.stereotype.Repository;

import com.eaglec.plat.dao.auth.RightsDao;
import com.eaglec.plat.dao.impl.BaseDaoImpl;
import com.eaglec.plat.domain.auth.Rights;

@Repository
public class RightsDaoImpl extends BaseDaoImpl<Rights> implements RightsDao {

}
