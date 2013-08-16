package com.eaglec.plat.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.eaglec.plat.domain.auth.User;

public interface UserRepository extends CrudRepository<User, Serializable> ,MongoRepository<User, Serializable>{
}
