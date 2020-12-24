package QuanLyKho.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.product;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ProductDAOImplement extends BaseDAOImplement<product> implements ProductDAO<product>{
	
}
