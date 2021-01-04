package QuanLyKho.DAO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import QuanLyKho.Entity.Page;


public interface BaseDAO<E> {
	public List<E> findAll();
	public E findById(Class<E> e, Serializable id);
	public List<E> findByProperty(String property, Object value,Page page);
	public void save(E instance);
	public void update(E instance);
	public void delete(E instance);
	public List<E> findAllJoin(String queryStr, Map<String, Object> mapParams);
	public List<E> findMutliProp(Map<String, Object> hash);
	public List<E> findAllAndPage(Page page);
	public void update1(E instance, Map<String, Object> mapParams, Map<String, Object> mapParams1);
	public List<Object[]> ThongKe(Map<String, Object> map,E instance);
}
