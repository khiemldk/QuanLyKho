package QuanLyKho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.product;
import QuanLyKho.Service.ProductService;

@Controller
public class ProductInfor {
	@Autowired
	ProductService productService;
	@GetMapping({"/product-info/list","/product-info/list/"})
	public String redirect() {
		return "redirect://product-info/list/1";
	}
	@GetMapping("/product-info/list/{index}")
	public String productList(Model model ,@PathVariable("index") int index) {
		if (index ==0)
			 index  = 1;
		Page page = new Page(3);
		page.setCurrentPage(index);
		
		List<product>listProduct = productService.getAllProducts1(page);
		if (index>=page.getTotalPages())
			index=page.getTotalPages()-1;
		model.addAttribute("crpage", index);
		model.addAttribute("pageInfo", page);
		model.addAttribute("listProduct", listProduct);
		return "product-list";
	}
}
