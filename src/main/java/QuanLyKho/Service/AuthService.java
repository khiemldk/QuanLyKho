package QuanLyKho.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.AuthDAO;
import QuanLyKho.Entity.auth;
import QuanLyKho.Entity.invoice;
import QuanLyKho.Entity.menu;

@Service
public class AuthService {
	@Autowired
	private AuthDAO<auth> authDAO;
	public List<auth> getAuths(){
		return authDAO.findAll();
	}
	public void update(auth auth) {
		auth.setActive_flag(true);
		auth.setUpdate_date(new Date());
		authDAO.update(auth);
	}
	public List<auth> Search(Map<String,Object> hash){
		return authDAO.findMutliProp(hash);
	}
}
