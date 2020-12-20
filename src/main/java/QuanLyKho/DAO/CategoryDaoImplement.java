package QuanLyKho.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.category;

@Repository
@Transactional(rollbackFor =  Exception.class)
public class CategoryDaoImplement extends BaseDAOImplement<category> implements CategoryDAO<category>{

}
