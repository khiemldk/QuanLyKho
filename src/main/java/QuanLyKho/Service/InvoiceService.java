package QuanLyKho.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuanLyKho.DAO.InvoiceDAO;
import QuanLyKho.Entity.Page;
import QuanLyKho.Entity.invoice;

@Service
public class InvoiceService {
	@Autowired
	InvoiceDAO<invoice> invoiceDAO;
	public void InsertInvoice(invoice invoice) {
		invoiceDAO.save(invoice);
	}
	public void Update(invoice invoice) {
		invoice.setActive_flag(true);
		invoice.setUpdate_date(new Date());
		invoiceDAO.update(invoice);
	}
	
	public List<invoice> GetInOuT(String prop,Object value,Page page){
		return invoiceDAO.findByProperty(prop, value,page);
	}
	public List<invoice> Search(Map<String,Object> hash){
		return invoiceDAO.findMutliProp(hash);
	}
	public invoice findByID(int id) {
		return invoiceDAO.findById(invoice.class, id);
	}
	public void delete(invoice invoice) {
		invoice.setActive_flag(false);
		invoice.setUpdate_date(new Date());
		invoiceDAO.update(invoice);
	}
}
