package QuanLyKho.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;

import QuanLyKho.DAO.HistoryDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.category;
import QuanLyKho.Entity.history;
import QuanLyKho.Entity.product;
import QuanLyKho.Entity.product_in_stock;
import QuanLyKho.Service.ProductInStockService;
import QuanLyKho.Service.ProductService;
import QuanLyKho.Untils.Constant;

@Controller
public class ProductInStockController {
	@Autowired
	ProductInStockService productInStockService;
	final static Logger log4j = Logger.getLogger(ProductInStockController.class);
	static int getQty = 0,checkOut = 0;
	
	@GetMapping({"/product-in-stock/list","/product-in-stock/list/"})
	public String redirect() {
		return "redirect:/product-in-stock/list/1";
	}
	@GetMapping("/product-in-stock/list/{currentPage}")
	public String getAll(Model model,@PathVariable("currentPage") int currentPage) {
		if (currentPage==  0)
			currentPage = 1;
		Page page = new Page(3);
		page.setCurrentPage(currentPage);
		List<product_in_stock> product_in_stocks = productInStockService.getAll1(page);
		if (currentPage>=page.getTotalPages())
			currentPage=page.getTotalPages()-1;
		model.addAttribute("crpage",currentPage );
		model.addAttribute("listStocks", product_in_stocks);
		model.addAttribute("pageInfo", page);
		return "product-stock-list";
	}
	@GetMapping("/product-in-stock/input")
	public String Input(Model model) {

		model.addAttribute("StockForm",new product_in_stock());
		model.addAttribute("idList", getIdProduct1());
		return "product-stock-action";
	}
	@GetMapping("/product-in-stock/output/{id}")
	public String Output(Model model,@PathVariable int id) {
		product_in_stock product_in_stock = productInStockService.findByID(id);
		if (product_in_stock!=null) {
			model.addAttribute("StockForm", product_in_stock);
			model.addAttribute("idList", getIdProduct1());
			getQty = product_in_stock.getQty();
			checkOut=1;
			return "product-stock-action";
		}
		return "redirect:/product-in-stock/list";
	}
	
	@GetMapping("/product-in-stock/edit/{id}")
	public String update(Model model,@PathVariable int id) {
		product_in_stock product_in_stock = productInStockService.findByID(id);
		if (product_in_stock!=null) {
			model.addAttribute("StockForm", product_in_stock);
			model.addAttribute("idList", getIdProduct1());
			getQty = product_in_stock.getQty();
			checkOut=0;
			return "product-stock-action";
		}
		return "redirect:/product-in-stock/list";
		
	}
	
	
	@PostMapping("/product-in-stock/save")
	public String SaveStock(Model model,@ModelAttribute("StockForm")@Validated  product_in_stock product_in_stock, BindingResult result,HttpSession httpSession ) {
//		log4j.info("XXXXX: "+product_in_stock.getId() + " "+product_in_stock.getProduct().getId() + " "+product_in_stock.getProduct().getImg_url());
		history history = new history();
		if (getQty < product_in_stock.getQty()) {
			history.setAction_name("Buy");
			
		} else {
			history.setAction_name("Sale");
		}
		history.setPrice(product_in_stock.getPrice());
		if (checkOut==1) {
			product_in_stock.setQty(getQty-product_in_stock.getQty());
		}
		if (product_in_stock.getQty()==0) {
			productInStockService.deleteProductInStock(product_in_stock);
		} else {
			productInStockService.updateProductInStock(product_in_stock);
		}
		history.setQty(Math.abs(getQty-product_in_stock.getQty()));
		history.setProduct(product_in_stock.getProduct());
		
		productInStockService.insertHistory(history);
		return "redirect:/product-in-stock/list";
	}
	@GetMapping("/product-in-stock/delete/{id}")
	public String Delete(Model model,@PathVariable int id) {
		product_in_stock product_in_stock = productInStockService.findByID(id);
		if(product_in_stock!=null) {
			productInStockService.deleteProductInStock(product_in_stock);
		}
		return "redirect:/product-in-stock/list";
		
	}
	@Autowired
	ProductService productService;
	public List<Integer> getIdProduct( ){
		List<product> product = productService.getAllProducts();
		List<Integer> idList = new ArrayList<>();
		for(product pr : product) {
			idList.add(pr.getId());
			log4j.info("this is product id "+pr.getId());
		}
		return idList;
	}
	public Map<String, String> getIdProduct1( ){
		List<product> product = productService.getAllProducts();
		Map<String, String> map = new HashMap<>();
		for(product pr : product) {
			map.put(String.valueOf(pr.getId()), pr.getName());
		}
		return map;
	}

}
