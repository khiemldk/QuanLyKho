package QuanLyKho.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import QuanLyKho.Entity.invoice;
import QuanLyKho.Untils.Constant;

public class ExportFile extends AbstractXlsView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = "invoice-export-"+System.currentTimeMillis()+".xlsx";
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		Sheet sheet = workbook.createSheet("data");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("#");
		header.createCell(1).setCellValue("Code");
		header.createCell(2).setCellValue("Qty");
		header.createCell(3).setCellValue("Price");
		header.createCell(4).setCellValue("Product");
		header.createCell(5).setCellValue("Update date");
		List<invoice> invoices = (List<invoice>) model.get(Constant.ExportStockFIle);
		int i = 1;
		for (invoice invoice : invoices) {
			Row row = sheet.createRow(i++);
			row.createCell(0).setCellValue(i-1);
			row.createCell(1).setCellValue(invoice.getCode());
			row.createCell(2).setCellValue(invoice.getQty());
			row.createCell(3).setCellValue(invoice.getPrice());
			row.createCell(4).setCellValue(invoice.getProduct().getName());
			row.createCell(5).setCellValue(invoice.getUpdate_date());
		}
		
	}

}
