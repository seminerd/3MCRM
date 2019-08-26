package com.sapo.team03.MCRM.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.ConversionDAO;
import com.sapo.team03.MCRM.DAO.CustomerDAO;
import com.sapo.team03.MCRM.DAO.CustomerGroupDAO;
import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.DAO.OrderDAO;
import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Exception.DuplicateEmail;
import com.sapo.team03.MCRM.Exception.DuplicatePhoneNumber;
import com.sapo.team03.MCRM.Exception.StaffNotFound;
import com.sapo.team03.MCRM.Marketing.Model.Customer;
import com.sapo.team03.MCRM.Marketing.Model.CustomerGroup;
import com.sapo.team03.MCRM.Marketing.Model.Lead;
import com.sapo.team03.MCRM.Sale.Model.Orders;
import com.sapo.team03.MCRM.Service.CustomerService;
import com.sapo.team03.MCRM.Service.XlsxHandler;
import com.sapo.team03.MCRM.Service.StatisticModel.Conversion;
import com.sapo.team03.MCRM.Utils.Utilities;

@CrossOrigin(origins = "*")
@RestController(value = "customers")
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	StaffDAO staffDAO;
	@Autowired
	CustomerGroupDAO customerGroupDAO;
	@Autowired
	LeadDAO leadDAO;
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	ConversionDAO conversionDAO;

	@PostMapping("customers/add")
	public Customer addCustomer(@RequestBody Customer customer,
			@RequestParam(value = "idLead", required = false) Long idLead) {
		if (customer.getEmail() != null) {
			Customer cus = customerDAO.findByEmail(customer.getEmail());
			if (cus != null)
				throw new DuplicateEmail(customer.getEmail());
		}

		if (customer.getPhone() != null) {
			Customer cus = customerDAO.findByPhone(customer.getPhone());
			if (cus != null)
				throw new DuplicatePhoneNumber(cus.getPhone());
		}
		if (idLead != null) {
			customerDAO.updateLeadSource(leadDAO.findById(idLead).get().getSource().getId());
			Conversion temp = conversionDAO.findRecordByMonth(LocalDate.now());
			if (leadDAO.findById(idLead).get().getOpportunity() == 0)
				temp.setLeadToCustomer(temp.getLeadToCustomer() + 1);
			else
				temp.setOpportunityToCustomer(temp.getOpportunityToCustomer() + 1);
			leadDAO.deleteById(idLead);
		} else {
			Lead lead = new Lead();
			if ((lead = leadDAO.findByEmail(customer.getEmail())) != null) {
				Conversion temp = conversionDAO.findRecordByMonth(LocalDate.now());
				if (lead.getOpportunity() == 0)
					temp.setLeadToCustomer(temp.getLeadToCustomer() + 1);
				else
					temp.setOpportunityToCustomer(temp.getOpportunityToCustomer() + 1);
				customerDAO.updateLeadSource(lead.getSource().getId());
				leadDAO.deleteByEmail(customer.getEmail());
			} else if ((lead = leadDAO.findByPhone(customer.getPhone())) != null) {
				Conversion temp = conversionDAO.findRecordByMonth(LocalDate.now());
				if (lead.getOpportunity() == 0)
					temp.setLeadToCustomer(temp.getLeadToCustomer() + 1);
				else
					temp.setOpportunityToCustomer(temp.getOpportunityToCustomer() + 1);
				customerDAO.updateLeadSource(lead.getSource().getId());
				leadDAO.deleteByPhone(customer.getPhone());
			}
		}
		if (customer.getStaff() != null) {
			if (customer.getStaff().getId() == null)
				customer.setStaff(null);
			else if (staffDAO.findById(customer.getStaff().getId()).orElse(null) == null) {
				throw new StaffNotFound("Staff Id: " + customer.getStaff().getId());
			}
		}
		customer.setPoint(0);
		List<CustomerGroup> list;
		if (customer.getGroups().isEmpty())
			list = new ArrayList<CustomerGroup>();
		else
			list = customer.getGroups();
		int age = customerDAO.getAgeByDate(customer.getDob());
		list.add(customerGroupDAO.getGroupByAge(age));
		list.add(customerGroupDAO.getGroupByPoint(customer.getPoint()));
		customer.setGroups(list);
		customer.setUpdateDate(new Date());

		return customerDAO.save(customer);

	}

	@GetMapping("customers/{id}")
	public Customer findCustomerById(@PathVariable("id") long id) {
		Customer customer = customerDAO.findById(id).get();
		return customer;
	}

	@Transactional
	@PutMapping("customers/{id}")
	public Customer editCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		customer.setId(id);
		Customer cus = customerDAO.findById(id).get();
		List<CustomerGroup> listOld = cus.getGroups();
		List<CustomerGroup> listNew = customer.getGroups();

		for (CustomerGroup customerGroup : listOld) {
			if (customerGroup.checkExistingGroup(listNew)) {
				continue;
			}
			if (customerGroup.getIdGroup() == 1 || customerGroup.getIdGroup() == 2) {
				listNew.add(customerGroup);
				continue;
			}

		}
		customerGroupDAO.deleteOldCustomer(id);
		customer.setUpdateDate(new Date());
		customer.setGroups(listNew);
		customer.setPoint(cus.getPoint());
		return customerDAO.save(customer);

	}

	@DeleteMapping("customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerDAO.deleteById(id);
	}

	@GetMapping("customers/list")
	public List<Customer> getCustomList(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			@RequestParam(value = "email", required = false) String email) {
		if (email == null) {
			if (page != null && size == null)
				return customerDAO.findAll(PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "updateDate")))
						.getContent();
			if (page != null && size != null)
				return customerDAO.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "updateDate")))
						.getContent();
			else {
				return customerDAO.findAll(Sort.by(Sort.Direction.DESC, "updateDate"));
			}
		} else {
			List<Customer> list = staffDAO.findByEmail(email).getCustomers();
			Collections.sort(list, (s1, s2) -> {
				return s1.getUpdateDate().compareTo(s2.getUpdateDate());
			});
			Collections.reverse(list);
			return list;
		}

	}

	@GetMapping("customers/staff_id/{id}")
	public List<Customer> getCustomerByStaffId(@PathVariable Long id) {
		List<Customer> list = staffDAO.findById(id).get().getCustomers();

		Collections.sort(list, (s1, s2) -> {
			return s1.getUpdateDate().compareTo(s2.getUpdateDate());
		});
		Collections.reverse(list);
		return list;
	}

	@GetMapping("customers/orders-his/{id}")
	public List<Orders> getTransactionHistory(@PathVariable Long id) {
		Customer customer = customerDAO.findById(id).get();
		List<Orders> list = customer.getOrders();
		Collections.sort(list, (s1, s2) -> {
			return s1.getUpdateDate().compareTo(s2.getUpdateDate());
		});
		Collections.reverse(list);
		return list;
	}

	@GetMapping("total-customers")
	public Integer totalCustomer() {
		return customerDAO.getTotalCustomer();
	}

	@GetMapping("customers/exportxlsx")
	public ResponseEntity<Object> downloadFile() throws IOException {
		XlsxHandler handler = new XlsxHandler();
		CustomerService service = new CustomerService();
		service.setHandler(handler);
		service.setCustomerDAO(customerDAO);

		InputStreamResource resource = new InputStreamResource(new FileInputStream(service.fileExport()));
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", service.fileExport().getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(service.fileExport().length()).contentType(MediaType.parseMediaType("application/txt"))
				.body(resource);
		Utilities.log("Download completed");
		return responseEntity;

	}

	@GetMapping("customer-by-group/{id}")
	public List<Customer> getCustomerByGroup(@PathVariable Long id,
			@RequestParam(value = "staff", required = false) Long staff) {
		List<Customer> list = new ArrayList<Customer>();
		if (staff == null) {
			list = customerGroupDAO.findById(id).get().getCustomers();
		} else
			list = customerDAO.getCustomerByGroup(staff, id);
		Collections.sort(list, (s1, s2) -> {
			return s1.getUpdateDate().compareTo(s2.getUpdateDate());
		});
		Collections.reverse(list);
		return list;
	}

}
