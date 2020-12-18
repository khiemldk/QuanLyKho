package QuanLyKho.Service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.UserDAO;
import QuanLyKho.Entity.users;


@Service
public class UserService {
	final static Logger log4j = Logger.getLogger(UserService.class);
	@Autowired
	private UserDAO<users> userDAO;
	
	
	public List<users> findByProperty(String property, Object value){
		log4j.info("UserService Start Right Now");
		return userDAO.findByProperty(property, value);
	}
	
}
