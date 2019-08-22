package com.sapo.team03.MCRM.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sapo.team03.MCRM.DAO.CategoryProductDAO;
import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.DAO.LeadSourceDAO;
import com.sapo.team03.MCRM.Marketing.Model.Lead;
import com.sapo.team03.MCRM.Marketing.Model.LeadSource;
import com.sapo.team03.MCRM.Sale.Model.CategoryProduct;
import com.sapo.team03.MCRM.Utils.Utilities;

public class LeadService {
	LeadDAO leadDAO;
	CategoryProductDAO categoryDAO;
	XlsxHandler handler;
	LeadSourceDAO sourceDAO;

	public LeadSourceDAO getSourceDAO() {
		return sourceDAO;
	}

	public void setSourceDAO(LeadSourceDAO sourceDAO) {
		this.sourceDAO = sourceDAO;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	MailService mailService;

	public LeadDAO getLeadDAO() {
		return leadDAO;
	}

	public void setLeadDAO(LeadDAO leadDAO) {
		this.leadDAO = leadDAO;
	}

	public CategoryProductDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryProductDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void checkNull(Object o) {
		if (o == null) {
			System.out.println("NULLLLLLLLL");
		} else
			System.out.println("NOT NULLLLL");
	}

	public XlsxHandler getHandler() {
		return handler;
	}

	public void setHandler(XlsxHandler handler) {
		this.handler = handler;
	}

	public LeadSource assignSource(Cell cell) {
		LeadSource source = new LeadSource();
		if (sourceDAO.findByName(cell.toString()) != null) {
			source = sourceDAO.findByName(cell.toString());
			return source;
		} else {
			LeadSource newsource = new LeadSource();
			newsource.setName(cell.toString());
			sourceDAO.save(newsource);
			return sourceDAO.findByName(newsource.getName());
		}

	}

	public void assignLead(Row row, Lead lead) {

		lead.setName(row.getCell(0).toString());
		lead.setEmail(row.getCell(1).toString());
		mailService.sendMail(lead.getName(), (long) 1, lead.getEmail());
		BigDecimal phoneNumber = new BigDecimal(row.getCell(2).toString());
		lead.setPhone(phoneNumber.toPlainString());
		if (row.getCell(3) != null) {
			List<String> interest = Arrays.asList(row.getCell(3).toString().split("."));
			for (int i = 0; i < interest.size(); i++) {
				long id = Long.valueOf(interest.get(i).replace(".0", ""));
				System.out.println(interest.get(i));
				CategoryProduct cate = new CategoryProduct();
				cate = categoryDAO.findById(id).get();
				lead.setInterest(cate);

			}

		}
		double opo = Double.parseDouble(row.getCell(4).toString());
		int oppo = (int) opo;
		lead.setOpportunity(oppo);
		lead.setSource(assignSource(row.getCell(5)));

	}

	public void addLeads() throws IOException {
		FileInputStream fin = new FileInputStream(handler.getOutPath());
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		do {
			Lead lead = new Lead();
			Row row = itr.next();
			if (row.getCell(0) != null) {
				assignLead(row, lead);
				leadDAO.save(lead);
				Utilities.log("Entity added to DB");
			}
		} while (itr.hasNext());
	}
}
