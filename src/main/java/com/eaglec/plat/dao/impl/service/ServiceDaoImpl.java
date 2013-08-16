package com.eaglec.plat.dao.impl.service;

import org.springframework.stereotype.Repository;

import com.eaglec.plat.dao.impl.BaseDaoImpl;
import com.eaglec.plat.dao.service.ServiceDao;
import com.eaglec.plat.domain.service.Service;

@Repository
public class ServiceDaoImpl extends BaseDaoImpl<Service> implements ServiceDao {
}