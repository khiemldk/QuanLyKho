package QuanLyKho.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import QuanLyKho.DAO.HistoryDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.history;
import QuanLyKho.Service.ProductInStockService;

@Controller
public class HistoryController {
	@Autowired
	ProductInStockService productInStockService;
	@GetMapping({"/history","/history/"})
	public String redirect() {
		return "redirect:/history/1";
	}
	@GetMapping("/history/{page}")
	public String ListHistory(Model model ,@PathVariable("page") int page) {
		Page page2 = new Page(3);
		page2.setCurrentPage(page);
		List<history> list = productInStockService.ShowList1(page2);
		model.addAttribute("listHistory",list);
		model.addAttribute("pageInfo", page2);
		return "history";
	}
//	@GetMapping("/goods-issue/list")
//	public String getOut(Model model) {
//		List<history> list= productInStockService.InOut("action_name", "sale");
//		model.addAttribute("listHistory",list);
//		return "history";
//	}
//	@GetMapping("/goods-recept/list")
//	public String getIn(Model model) {
//		List<history> list= productInStockService.InOut("action_name", "buy");
//		model.addAttribute("listHistory",list);
//		return "history";
//	}
}
