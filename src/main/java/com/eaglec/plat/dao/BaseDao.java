package com.eaglec.plat.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.eaglec.plat.view.JSONData;

/**
 * 数据操作基类
 * @author Xiadi
 * @since 2013-8-12
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 保存对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param o
	 *@return
	 */
	public abstract T save(T o);

	/**
	 * 保存列表对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param its
	 *@return
	 */
	public abstract List<T> save(Iterable<T> its);

	/**
	 * 删除对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param o 目标对象
	 */
	public abstract void delete(T o);

	/**
	 * 根据id删除对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param id 对象id
	 */
	public abstract void delete(Serializable id);

	/**
	 * 删除列表对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param its 列表
	 */
	public abstract void delete(Iterable<T> its);

	/**
	 * 更新对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param o 目标对象
	 *@return T
	 */
	public abstract T update(T o);

	/**
	 * 保存或更新对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param o 目标对象
	 *@return T
	 */
	public abstract T saveOrUpdate(T o);

	/**
	 * 根据id查询实体对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param id
	 *@return T
	 */
	public abstract T get(Serializable id);

	/**
	 * 根据hql查询单一实体对象(不带参数注入)
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句
	 *@return T
	 */
	public abstract T get(String hql);

	/**
	 * 根据hql查询单一实体对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句
	 *@param params 注入参数,如：<br/>
	 *		hql：from User user where user.name=:username and user.age=:age<br/> 
	 *		map：
	 *		map.put("username",args0);
	 *		map.put("age",args0);
	 *@return T
	 */
	public abstract T get(String hql, Map<String, Object> params);

	/**
	 * 根据Hql查询Object列表(不带参数注入)
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句
	 *@return List  
	 */
	public abstract List<Object> findObjects(String hql);

	/**
	 * 根据Hql查询实体列表(不带参数注入)
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句
	 *@return List  
	 */
	public abstract List<T> findList(String hql);

	/**
	 * 根据Hql查询实体列表
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句
	 *@param params 注入参数,如：<br/>
	 *		hql：from User user where user.name=:username and user.age=:age<br/> 
	 *		map：
	 *		map.put("username",args0);
	 *		map.put("age",args0);
	 *@return List  
	 */
	public abstract List<T> findList(String hql, Map<String, Object> params);

	/**
	 * 根据Hql分页查询实体列表(不带参数注入)
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句
	 *@param start 开始行数
	 *@param limit 限定行数
	 *@return List  
	 */
	public abstract List<T> findList(String hql, int start, int limit);

	/**
	 * 根据Hql分页查询实体列表
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句
	 *@param params 注入参数,如：<br/>
	 *		hql：from User user where user.name=:username and user.age=:age<br/> 
	 *		map：
	 *		map.put("username",args0);
	 *		map.put("age",args0);
	 *@param start 开始行数
	 *@param limit 限定行数
	 *@return List  
	 */
	public abstract List<T> findList(String hql, Map<String, Object> params,
			int start, int limit);

	/**
	 * 根据查询条件输出JSONData
	 *@author lizhiwei
	 *@since 2013-8-15 
	 *
	 *@param hql 查询语句
	 *@param params 注入参数,如：<br/>
	 *		hql：from User user where user.name=:username and user.age=:age<br/> 
	 *		map：
	 *		map.put("username",args0);
	 *		map.put("age",args0);
	 *@param start 开始行数
	 *@param limit 限定行数
	 *@return JSONData  
	 */
	public abstract JSONData<T> outJSONData(String hql,int start, int limit);
	
	/**
	 * 返回该实体的所有总数
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@return Long 总数
	 */
	public abstract Long count();

	/**
	 * 根据hql查询返回符合条件的总数(不带Hql参数注入)
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句 
	 *@return Long 总数
	 */
	public abstract Long count(String hql);

	/**
	 * 根据hql查询返回符合条件的总数
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句 
	 *@param params 注入参数,如：<br/>
	 *		hql：select count(*) from User user where user.name=:username and user.age=:age<br/> 
	 *		map：
	 *		map.put("username",args0);
	 *		map.put("age",args0);
	 *@return Long 总数
	 */
	public abstract Long count(String hql, Map<String, Object> params);

	/**
	 * 执行Hql语句
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 执行语句 
	 *@param params 注入参数,如：<br/>
	 *		hql：update User set sex = '女' where name=:username and user.age=:age<br/> 
	 *		map：
	 *		map.put("username",args0);
	 *		map.put("age",args0);
	 *@return int 返回受影响行数
	 */
	public abstract int executeHql(String hql, Map<String, Object> params);

	/**
	 * 根据Hql查询单一对象
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param hql 查询语句 
	 *@return Object 
	 */
	public abstract Object uniqueResult(String hql);

	/**
	 * 执行Sql语句
	 *@author Xiadi
	 *@since 2013-8-12 
	 *
	 *@param sql 执行语句 
	 *@return int 返回受影响行数
	 */
	public abstract int executeSql(String sql);

}