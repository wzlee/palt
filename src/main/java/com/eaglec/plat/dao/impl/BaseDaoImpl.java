package com.eaglec.plat.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.eaglec.plat.dao.BaseDao;
import com.eaglec.plat.view.JSONData;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> entityClass;

	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#save(T)
	 */
	@Override
	public T save(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(o);
		return o;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#save(java.lang.Iterable)
	 */
	@Override
	public List<T> save(Iterable<T> its) {
		// TODO Auto-generated method stub
		List<T> result = new ArrayList<T>();

		for (T entity : its) {
			this.save(entity);
			result.add(entity);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#delete(T)
	 */
	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(o);
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		this.delete(this.get(id));
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<T> its) {
		// TODO Auto-generated method stub
		for (T entity : its) {
			this.delete(entity);
		}
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#update(T)
	 */
	@Override
	public T update(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(o);
		return o;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#saveOrUpdate(T)
	 */
	@Override
	public T saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(o);
		return o;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#get(java.io.Serializable)
	 */
	@Override
	public T get(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getCurrentSession().get(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#get(java.lang.String)
	 */
	@Override
	public T get(String hql) {
		// TODO Auto-generated method stub
		return this.get(hql, null);
	}
	
	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#get(java.lang.String, java.util.Map)
	 */
	@Override
	public T get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()){
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		Object o = q.uniqueResult();
		return o == null ? null : (T) o;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#findObjects(java.lang.String)
	 */
	@Override
	public List<Object> findObjects(String hql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery(hql).list();
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#findList(java.lang.String)
	 */
	@Override
	public List<T> findList(String hql) {
		// TODO Auto-generated method stub
		return this.findList(hql, null);
	}

	@Override
	public List<T> findList(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> list = q.list();
		return list == null ? null : list;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#findList(java.lang.String, int, int)
	 */
	@Override
	public List<T> findList(String hql, int start, int limit) {
		// TODO Auto-generated method stub
		return this.findList(hql, null, start, limit);
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#findList(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public List<T> findList(String hql, Map<String, Object> params, int start,
			int limit) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql).setFirstResult(start)
				.setMaxResults(limit);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> list = q.list();
		return list == null ? null : list;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#count()
	 */
	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return this.count("select count(*) from " + entityClass.getName());
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#count(java.lang.String)
	 */
	@Override
	public Long count(String hql) {
		// TODO Auto-generated method stub
		return this.count(hql, null);
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#count(java.lang.String, java.util.Map)
	 */
	@Override
	public Long count(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		Object obj = q.uniqueResult();
		return obj != null ? (Long)obj : 0;
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#executeHql(java.lang.String, java.util.Map)
	 */
	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		if (params == null || params.isEmpty())
			return this.getCurrentSession().createQuery(hql).executeUpdate();
		Query q = this.getCurrentSession().createQuery(hql);
		for (String key : params.keySet()) {
			q.setParameter(key, params.get(key));
		}
		return q.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#uniqueResult(java.lang.String)
	 */
	@Override
	public Object uniqueResult(String hql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.eaglec.plat.dao.impl.BaseDao#executeSql(java.lang.String)
	 */
	@Override
	public int executeSql(String sql) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public JSONData<T> outJSONData(String hql,int start, int limit) {
		Query query = this.getCurrentSession().createQuery(hql);
		int total = query.list().size();
		List<T> list = query.setFirstResult(start).setMaxResults(limit).list();
		return new JSONData<T>(true,list,total);
	}

}
