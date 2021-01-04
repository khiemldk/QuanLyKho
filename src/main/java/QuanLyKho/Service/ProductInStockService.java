package QuanLyKho.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.HistoryDAO;
import QuanLyKho.DAO.ProductDAO;
import QuanLyKho.DAO.ProductInStockDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.category;
import QuanLyKho.Entity.history;
import QuanLyKho.Entity.product;
import QuanLyKho.Entity.product_in_stock;

@Service
public class ProductInStockService {
	@Autowired
	ProductInStockDAO<product_in_stock> productInStockDAO;
	@Autowired
	HistoryDAO<history> historyDAO;
	
	public void insertProductInStock(product_in_stock product_in_stock) { // nhap kho
		product_in_stock.setActive_flag(true);
		product_in_stock.setCreate_date(new Date());
		product_in_stock.setUpdate_date(new Date());
		productInStockDAO.save(product_in_stock);
	}
	public void updateProductInStock(product_in_stock product_in_stock) { // update kho
		
		product_in_stock.setActive_flag(true);
		product_in_stock.setUpdate_date(new Date());
//		product_in_stock.setProduct(product_in_stock.getProduct());
		productInStockDAO.update(product_in_stock);
	}
	public void deleteProductInStock(product_in_stock product_in_stock) { // xuat kho
		product_in_stock.setActive_flag(false);
		productInStockDAO.update(product_in_stock);
	}
	public List<product_in_stock> getAll( ){
		return productInStockDAO.findAll();
	}
	public List<product_in_stock> getAll1(Page page){
		return productInStockDAO.findAllAndPage(page);
	}
	
	public List<product_in_stock> findProductInStockByProp(String prop,Object value){
		return productInStockDAO.findByProperty(prop, value,null);
	}
	public product_in_stock findByID(int id) {
		return productInStockDAO.findById(product_in_stock.class, id);
	}
//	public List<product_in_stock> getStocks(){
//		return productInStockDAO.getAllInStock();
//	}
	
	//History 
	public void insertHistory(history history) {
		history.setActive_flag(true);
		history.setCreate_date(new Date());
		history.setUpdate_date(new Date());
		historyDAO.save(history);
	}
	public List<history> ShowList( ) {
		return historyDAO.findAll();
	}
	public List<history> ShowList1(Page page){
		return historyDAO.findAllAndPage(page);
	}
	public List<history> InOut(String prop,Object value){
		return historyDAO.findByProperty(prop, value,null);
	}
	public List<Object[]> ThongKe(Map<String, Object> map,history history){
		return historyDAO.ThongKe(map, history);
	}
}
