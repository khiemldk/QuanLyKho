package QuanLyKho.DAO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.query.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import QuanLyKho.Entity.Page;


@Repository
@Transactional(rollbackFor = Exception.class)
public class BaseDAOImplement<E> implements BaseDAO<E>{
	
	@Autowired
	SessionFactory sessionFactory;
	
	final static Logger log4j = Logger.getLogger(BaseDAOImplement.class);
	public List<E> findAll() {
		log4j.info("find all record from db");
		StringBuilder query = new StringBuilder("");
		StringBuilder countRows = new StringBuilder("");
		query.append(" from ").append(getGenericName()).append(" as model where model.active_flag = 1");
//		query.append("select count(*) from ").append(getGenericName()).append(" as model where model.active_flag = 1");
		log4j.info("This query : " +query.toString());
		Session ss = sessionFactory.getCurrentSession();
		
		Query<E> queryRes = ss.createQuery(query.toString());
//		if (page!=null) {
//			queryRes.setFirstResult(page.getOffset());
//			queryRes.setMaxResults(page.getRecordPerPage());
//			int totalRows = (int)ss.createQuery(countRows.toString()).uniqueResult();
//			page.setTotalRows(totalRows);
//		}
		return queryRes.list();
	}

	public E findById(Class<E> e, Serializable id) {
		log4j.info("find by id");
		Session ss = sessionFactory.getCurrentSession();
		
		return ss.get(e, id);
	}

	public List<E> findByProperty(String property, Object value) {
		log4j.info("Find by property");
		StringBuilder queryString = new StringBuilder();
		queryString.append(" from ").append(getGenericName()).append(" as model where model.active_flag=1 and model.").append(property).append("=?1");
		log4j.info(" query find by property ===>"+queryString.toString());
		Query<E> query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
		query.setParameter(1, value);
		return query.getResultList();
	}

	public void save(E instance) {
		log4j.info("save data");
		Session ss = sessionFactory.getCurrentSession();
		
		ss.persist(instance);
		
	}

	public void update(E instance) {
		log4j.info("update data");
		Session ss = sessionFactory.getCurrentSession();
		
		ss.merge(instance);
		
	}

	public void delete(E instance) {
		log4j.info("delete data");
		Session ss = sessionFactory.getCurrentSession();
		
		ss.delete(instance);
		
	}
	
	
	public String getGenericName() { // Hàm này lấy ra cái tên bảng để cho hibernate hiểu đc
		String s = getClass().getGenericSuperclass().toString();
		Pattern pattern = Pattern.compile("\\<(.*?)\\>");
		Matcher matcher = pattern.matcher(s);
		String generic = "null";
		if (matcher.find()) {
			generic = matcher.group(1);
		}
		return generic;
	}

	@Override
	public List<E> findAllJoin(String queryStr, Map<String, Object> mapParams) {
		StringBuilder queryString = new StringBuilder("");
		StringBuilder countQuery = new StringBuilder();
		countQuery.append(" select count(*) from ").append(getGenericName()).append(" as model where model.activeFlag=1");
		queryString.append(" from ").append(getGenericName()).append(" as model where model.activeFlag=1");
		if(queryStr!=null && !queryStr.isEmpty()) {
			queryString.append(queryStr);
			countQuery.append(queryStr);
		}
		Query<E> query  = sessionFactory.getCurrentSession().createQuery(queryString.toString());
		if(mapParams!=null && !mapParams.isEmpty()) {
			for(String key : mapParams.keySet()) {
				query.setParameter(key, mapParams.get(key));
			}
		}
		return query.list();
	}

	@Override
	public List<E> findMutliProp(Map<String, Object> hash) {
		StringBuilder query = new StringBuilder();
		query.append(" from ").append(getGenericName()).append(" as model where model.active_flag=1 and ");
		for(String key : hash.keySet()) {
			if (hash.get(key)!=null && !StringUtils.isEmpty(hash.get(key))) {
				query.append(key).append(" like '%").append(hash.get(key)).append("%' ");
				query.append("or ");
			}
		}
		log4j.info("This is : "+query);
		query.delete(query.length()-3, query.length());
		Session ss = sessionFactory.getCurrentSession();
		
		return ss.createQuery(query.toString()).list();
	}

	@Override
	public List<E> findAllAndPage(Page page) {
		log4j.info("find all record from db");
		StringBuilder query = new StringBuilder("");
		StringBuilder countRows = new StringBuilder("");
		query.append(" from ").append(getGenericName()).append(" as model where model.active_flag = 1");
		countRows.append("select count(*) from ").append(getGenericName()).append(" as model where model.active_flag = 1");
		log4j.info("This query : " +query.toString());
		Session ss = sessionFactory.getCurrentSession();
		
		Query<E> queryRes = ss.createQuery(query.toString());
		if (page!=null) {
			queryRes.setFirstResult(page.getOffset());
			queryRes.setMaxResults(page.getRecordPerPage());
			long totalRows = (long)ss.createQuery(countRows.toString()).uniqueResult();
			page.setTotalRows(totalRows);
		}
		return queryRes.list();
	}
	
	

}
