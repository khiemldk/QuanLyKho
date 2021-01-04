package QuanLyKho.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.auth;

@Repository
@Transactional(rollbackFor = Exception.class)
public class AuthDAOImplement extends BaseDAOImplement<auth> implements AuthDAO<auth>{

}
