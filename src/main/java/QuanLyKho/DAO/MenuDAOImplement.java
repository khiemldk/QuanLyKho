package QuanLyKho.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.menu;

@Repository
@Transactional(rollbackFor = Exception.class)
public class MenuDAOImplement extends BaseDAOImplement<menu> implements MenuDAO<menu>{

}
