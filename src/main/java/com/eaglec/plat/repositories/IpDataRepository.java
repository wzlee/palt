package com.eaglec.plat.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.eaglec.plat.domain.IpData;

public interface IpDataRepository extends CrudRepository<IpData, Serializable> ,MongoRepository<IpData, Serializable>{
}
