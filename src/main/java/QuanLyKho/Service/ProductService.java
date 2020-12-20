package QuanLyKho.Service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.CategoryDAO;
import QuanLyKho.Entity.category;

@Service
public class ProductService {
	public final static Logger log4j = Logger.getLogger(ProductService.class);
	@Autowired
	private CategoryDAO<category> categoryDAO;
	
	public void insertCategory(category category) {
		log4j.info("insert Category");
		category.setActive_flag(true);
		category.setUpdate_date(new Date());
		category.setCreate_date(new Date());
		categoryDAO.save(category);
	}
	public void updateCategory(category category) {
		log4j.info("update Category");
		category.setActive_flag(true);
		category.setUpdate_date(new Date());
		categoryDAO.update(category);
	}
	public void deleteCategory(category category) {
		log4j.info("delete Category");
		category.setActive_flag(false);
		categoryDAO.update(category);
	}
	public List<category> findCategory(String property,Object value){
		log4j.info("find Category");
		return categoryDAO.findByProperty(property, value);
	}
	public List<category> getAll(){
		return categoryDAO.findAll();
	}
	public category findByIdCategory(int id){
		return categoryDAO.findById(category.class, id);
	}
}
