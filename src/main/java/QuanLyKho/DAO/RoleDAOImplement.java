package QuanLyKho.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.roles;

@Repository
@Transactional(rollbackFor = Exception.class)
public class RoleDAOImplement extends BaseDAOImplement<roles>implements RoleDAO<roles>{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public long NumberOfRow() {
		StringBuilder countRows = new StringBuilder("");
		countRows.append("select count(*) from ").append(getGenericName()).append(" as model where model.active_flag = 1");
		Session ss = sessionFactory.getCurrentSession();
		return (long)ss.createQuery(countRows.toString()).uniqueResult();
	}

}
