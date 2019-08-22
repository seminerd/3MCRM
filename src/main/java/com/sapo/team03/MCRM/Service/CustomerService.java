package com.sapo.team03.MCRM.Service;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.Marketing.Model.Customer;

public class CustomerService {
	CustomerDAO customerDAO;
	XlsxHandler handler;
	public XlsxHandler getHandler() {
		return handler;
	}
	public void setHandler(XlsxHandler handler) {
		this.handler = handler;
	}
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	public File fileExport() throws IOException {
		List<Customer> customers = new ArrayList<>();
		customers = customerDAO.findAll();
		
		
		return new File(handler.writeCustomersToFile(customers));
	}

}
