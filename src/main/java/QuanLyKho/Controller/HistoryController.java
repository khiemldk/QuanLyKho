package QuanLyKho.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.history;
import QuanLyKho.Service.ProductInStockService;

@Controller
public class HistoryController {
	public final static Logger log4j = Logger.getLogger(HistoryController.class);
	@Autowired
	ProductInStockService productInStockService;
	@GetMapping({"/history","/history/"})
	public String redirect() {
		return "redirect:/history/1";
	}
	@GetMapping("/history/{page}")
	public String ListHistory(Model model ,@PathVariable("page") int page) {
		if (page == 0)
			page =1;
		Page page2 = new Page(3);
		page2.setCurrentPage(page);
		
		List<history> list = productInStockService.ShowList1(page2);
		if (page>=page2.getTotalPages())
			page=page2.getTotalPages()-1;
		model.addAttribute("crpage", page);
		for(Object obj : list) {
			log4j.info("obj hisotyr : "+obj.toString());
		}
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
	@GetMapping("/history/thongke")
	public String ListThongKe(Model model) {
		history history = new history();
		model.addAttribute("thongKeForm", history);
		log4j.info("hkie : " + history.getUpdate_date());
		return "thong-ke";
	}
	@PostMapping("history/thongke/save")
	public String Action(Model model , @ModelAttribute("thongKeForm") history history,@RequestParam("date") String date,@RequestParam("date1")String date1) throws ParseException {
		Map<String, Object> map = new HashMap();
		map.put("action_name", history.getAction_name());
		
		if (StringUtils.isEmpty(history.getType()))
			map.put("type", "");
		else
			map.put("type", String.valueOf(history.getType()));
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd"); 
		Date dt = formatter1.parse(date);
		Date dt1 = formatter1.parse(date1); 
		Pair<String, String> pair = new Pair<>(date, date1);
		
//		history.setUpdate_date(dt);
		model.addAttribute("date", date);
		model.addAttribute("date1", date1);
		log4j.info("Date update : "+pair.getFirst()+ " " +pair.getSecond());
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");  
//		try {
//			Date date1=dateFormat.parse(history.tmp.toString());
//			Timestamp timestamp = new Timestamp(date1.getTime());
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		map.put("update_date",pair);
		
//		log4j.info("hhaha" +map.get("update_date"));
//		log4j.info("update date la : "+String.valueOf(history.getUpdate_date()));
		List<Object[]> list = productInStockService.ThongKe(map, history);
		model.addAttribute("listThongKe", list);
		return "thong-ke";
	}
//	public static void main(String[] args) {
//		String date = "Wed Mar 11 2020 05:29:01 GMT+0100 (West Africa Standard Time)";
//		date = date.substring(0,15);
//		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy");
//		Date parsedDate = null;
//		try {
//		    parsedDate = format.parse(date);
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}     
//		System.out.println(parsedDate);
//		SimpleDateFormat outformat = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(outformat.format(parsedDate));
//	}
}
