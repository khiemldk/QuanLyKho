package QuanLyKho.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.product_in_stock;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ProductInStockDAOImplement extends BaseDAOImplement<product_in_stock> implements ProductInStockDAO<product_in_stock> {
//	public final static Logger log4j = Logger.getLogger(ProductInStockDAOImplement.class);
//	@Autowired
//	SessionFactory sessionFactory;
//	@Override
//	public List<E> getAllInStock() {
//		StringBuilder query = new StringBuilder("");
//		query.append("select model.id,product_id,qty,price,code,img_url from ").append(getGenericName()).append(" as model ");
//		query.append("inner join product where product.id = model.product_id");
//		query.append(" and model.active_flag = 1");
//		log4j.info("this query" + query.toString());
//		Session ss = sessionFactory.getCurrentSession();
//		return ss.createQuery(query.toString()).list();
//	}
	
}
