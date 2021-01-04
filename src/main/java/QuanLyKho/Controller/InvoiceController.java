package QuanLyKho.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import QuanLyKho.DAO.InvoiceDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.invoice;
import QuanLyKho.Entity.product;
import QuanLyKho.Service.ExportFile;
import QuanLyKho.Service.InvoiceService;
import QuanLyKho.Service.ProductService;
import QuanLyKho.Untils.Constant;

@Controller
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	ProductService productService;
	@GetMapping({"/goods-recept/list","/goods-recept/list/"})
	public String redirect() {
		return "redirect:/goods-recept/list/1";
	}
	@GetMapping({"/goods-issue/list","/goods-issue/list/"})
	public String redirect1() {
		return "redirect:/goods-issue/list/1";
	}
	
	@GetMapping("/goods-recept/list/{currentPage}")
	public String Invoice1(Model model,@PathVariable("currentPage") int currentPage) {
		if (currentPage==0)
			currentPage=1;
		Page pg = new Page(3);
		pg.setCurrentPage(currentPage);
		
		List<invoice> invoices =invoiceService.GetInOuT("type", 1,pg);
		if (currentPage>=pg.getTotalPages())
			currentPage=pg.getTotalPages()-1;
		model.addAttribute("crpage", currentPage);
		model.addAttribute(Constant.type, 1);
		model.addAttribute("listInvoice", invoices);
		model.addAttribute("pageInfo", pg);
		return "goods-recept-list";
	}
	@GetMapping("/goods-issue/list/{currentPage}")
	public String Invoice0(Model model,@PathVariable("currentPage") int currentPage) {
		if (currentPage==0)
			currentPage=1;
		Page pg = new Page(3);
		pg.setCurrentPage(currentPage);
		
		List<invoice> invoices =invoiceService.GetInOuT("type", 0,pg);
		if (currentPage>=pg.getTotalPages())
			currentPage=pg.getTotalPages()-1;
		System.out.println("total la : " + pg.getTotalPages());
		model.addAttribute("crpage", currentPage);
		model.addAttribute(Constant.type, 0);
		model.addAttribute("listInvoice", invoices);
		model.addAttribute("pageInfo", pg);
		return "goods-issue-list";
	}
	@PostMapping("/goods-recept/list/save")
	public String XuLyAction(Model model,@ModelAttribute("InvoiceForm") invoice invoice,BindingResult result) {
		invoiceService.Update(invoice);
		return "redirect:/goods-recept/list";
	}
	@GetMapping("/goods-recept/list/edit/{id}")
	public String update(Model model,@PathVariable int id) {
		invoice invoice = invoiceService.findByID(id);
		model.addAttribute("InvoiceForm", invoice);
		model.addAttribute("idList", getIdProduct1());
		return "goods-recept-action";
	}
	public Map<String, String> getIdProduct1( ){
		List<product> product = productService.getAllProducts();
		Map<String, String> map = new HashMap<>();
		for(product pr : product) {
			map.put(String.valueOf(pr.getId()), pr.getName());
		}
		return map;
	}
	public List<Integer> getIdProduct( ){
		List<product> product = productService.getAllProducts();
		List<Integer> idList = new ArrayList<>();
		for(product pr : product) {
			idList.add(pr.getId());
		}
		return idList;
	}
	@GetMapping("/goods-recept/list/delete/{id}")
	public String delete(Model model,@PathVariable int id) {
		invoice invoice = invoiceService.findByID(id);
		invoiceService.delete(invoice);
		return "redirect:/goods-recept/list";
	}
	@GetMapping("goods-recept/list/FormSearch")
	public String FormSearch(Model model) {
		model.addAttribute("SearchForm", new invoice());
		model.addAttribute("idList", getIdProduct1());
		return "goods-recept-search";
	}
	@PostMapping("goods-recept/list/search")
	public String Search(Model model,@ModelAttribute("SearchForm") invoice invoice,BindingResult result) {
		Map<String, Object> map = new HashMap();
		map.put("code", invoice.getCode());
		map.put("product.id", invoice.getProduct().getId());
		map.put("type", invoice.getType());
		
		List<invoice> invoices =invoiceService.Search(map);
		model.addAttribute("listInvoice", invoices);
		return "goods-recept-list";

	}
	@GetMapping("/goods-issue/list/export/{type}")
	public ModelAndView exprot(@PathVariable("type") int type) {
		ModelAndView modelAndView = new ModelAndView();
		List<invoice> invoice = invoiceService.GetInOuT("type", type,null);
		modelAndView.addObject(Constant.ExportStockFIle, invoice);
		modelAndView.setView(new ExportFile());
		return modelAndView;
	}
	
}
