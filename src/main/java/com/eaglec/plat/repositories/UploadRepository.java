package com.eaglec.plat.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.eaglec.plat.domain.Upload;

public interface UploadRepository extends CrudRepository<Upload, Serializable> ,MongoRepository<Upload, Serializable>{
}
