package QuanLyKho.DAO;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.user_role;

@Transactional(rollbackFor = Exception.class)
@Repository
public class UserRoleDAOImplement extends BaseDAOImplement<user_role> implements UserRoleDAO<user_role>{

}
