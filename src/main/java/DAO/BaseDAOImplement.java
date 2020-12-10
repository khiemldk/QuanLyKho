package DAO;

import java.io.Serializable;
import java.util.List;

public class BaseDAOImplement<E> implements BaseDAO<E>{

	public List<E> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public E findById(Class<E> e, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<E> FindByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(E instance) {
		// TODO Auto-generated method stub
		
	}

	public void update(E instance) {
		// TODO Auto-generated method stub
		
	}

	public void delete(E instance) {
		// TODO Auto-generated method stub
		
	}

}
