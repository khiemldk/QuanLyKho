package QuanLyKho.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.MenuDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.menu;

@Service
public class MenuService {
	@Autowired
	private MenuDAO<menu> menuDAO;
	
	public List<menu> getMenu(Page page){
		return menuDAO.findAllAndPage(page);
	}
	public menu findByID(int id) {
		return menuDAO.findById(menu.class, id);
	}
	public void save(menu menu) {
		menuDAO.save(menu);
	}
}
