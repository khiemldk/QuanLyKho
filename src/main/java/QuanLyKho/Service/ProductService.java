package QuanLyKho.Service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.CategoryDAO;
import QuanLyKho.DAO.ProductDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.category;
import QuanLyKho.Entity.product;

@Service
public class ProductService {
	public final static Logger log4j = Logger.getLogger(ProductService.class);
	@Autowired
	private CategoryDAO<category> categoryDAO;
	@Autowired
	private ProductDAO<product> productDAO;
	
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
	public List<category> getAll( ){
		return categoryDAO.findAll();
	}
	public category findByIdCategory(int id){
		return categoryDAO.findById(category.class, id);
	}
	public List<category> getAllPae(Page page){
		return categoryDAO.findAllAndPage(page);
	}
	
	// product Infor
	public void InsertProduct(product productInfo) {
		productInfo.setActive_flag(true);
		productInfo.setCreate_date(new Date());
		productInfo.setUpdate_date(new Date());
		productDAO.save(productInfo);
	}
	
	public void updateProductInfo(product productInfo) throws Exception {
		productInfo.setUpdate_date(new Date());
		productDAO.update(productInfo);
	}
	public void deleteProductInfor(product product) {
		product.setUpdate_date(new Date());
		product.setActive_flag(false);
		productDAO.update(product);
	}
	public List<product> findProductInfo(String property , Object value){
		
		return productDAO.findByProperty(property, value);
	}
	public product findByIdProductInfo(int id) {
		
		return productDAO.findById(product.class, id);
	}
	
	public List<product> getAllProducts( ){
		return productDAO.findAll();
	}
	public List<product> getAllProducts1( Page page){
		return productDAO.findAllAndPage(page);
	}
	
}
