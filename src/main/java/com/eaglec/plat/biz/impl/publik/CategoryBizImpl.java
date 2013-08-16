package com.eaglec.plat.biz.impl.publik;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eaglec.plat.biz.publik.CategoryBiz;
import com.eaglec.plat.dao.publik.CategoryDao;
import com.eaglec.plat.domain.Category;

@Service
public class CategoryBizImpl implements CategoryBiz {

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> findAll() {
		String hql = "from Category where pid is null";
		return categoryDao.findList(hql);
	}
	@Override
	public List<Category> findCategoryByClazzAndPid(String clazz, int pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clazz", clazz);
		map.put("pid", pid);
		return categoryDao.findList("from Category where clazz=:clazz and pid=:pid", map);
	}

}
