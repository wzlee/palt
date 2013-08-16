package com.eaglec.plat.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eaglec.plat.domain.service.Service;

public interface ServiceRepository extends MongoRepository<Service, Serializable>{
	List<Service> findServiceBySname(String sname);
	List<Service> findServiceByCid(String cid);
}
