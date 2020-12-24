package QuanLyKho.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.invoice;

@Repository
@Transactional(rollbackFor =  Exception.class)
public class InvoiceDAOImpliment extends BaseDAOImplement<invoice> implements InvoiceDAO<invoice>{
	
}
