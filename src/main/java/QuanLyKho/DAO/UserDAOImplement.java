package QuanLyKho.DAO;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.users;


@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAOImplement extends BaseDAOImplement<users> implements UserDAO<users>{
	
}
