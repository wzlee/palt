package com.eaglec.plat.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eaglec.plat.domain.Category;

public interface CategoryRepository extends MongoRepository<Category, Serializable>{
	List<Category> findCategoryByPid(String pid);
}
