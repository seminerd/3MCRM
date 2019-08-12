package com.sapo.team03.MCRM.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sapo.team03.MCRM.DAO.CategoryProductDAO;
import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.Model.CategoryProduct;
import com.sapo.team03.MCRM.Model.Lead;

public class LeadService {
	LeadDAO leadDAO;
	CategoryProductDAO categoryDAO;
	XlsxHandler handler;

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

	public void assignLead(Row row, Lead lead) {

		lead.setName(row.getCell(0).toString());
		lead.setEmail(row.getCell(1).toString());
		lead.setPhone(row.getCell(2).toString());
		List<String> interest = Arrays.asList(row.getCell(3).toString().split(","));
		for (int i = 0; i < interest.size(); i++) {
			long id = Long.parseLong(interest.get(i));
			CategoryProduct cate = new CategoryProduct();
			cate = categoryDAO.findById(id).get();
			lead.setInterest(cate);

			double opo = Double.parseDouble(row.getCell(4).toString());
			int oppo = (int) opo;
			lead.setOpportunity(oppo);

		}
	}

	public void addLeads() throws IOException {

		FileInputStream fin = new FileInputStream(handler.getOutPath());
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> itr = sheet.iterator();
		do {

			Lead lead = new Lead();
			Row row = itr.next();
			if (row.getCell(0) !=null) {
				assignLead(row, lead);
				leadDAO.save(lead);
			}
			

		} while (itr.hasNext());

	}
}
