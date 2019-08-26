package com.sapo.team03.MCRM.Controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.OrderDAO;
import com.sapo.team03.MCRM.DAO.OrderDetailDAO;
import com.sapo.team03.MCRM.DAO.ProductDAO;
import com.sapo.team03.MCRM.DAO.StaffDAO;
import com.sapo.team03.MCRM.Sale.Model.OrderDetail;
import com.sapo.team03.MCRM.Sale.Model.Orders;
import com.sapo.team03.MCRM.Sale.Model.Product;

@CrossOrigin(origins="*")
@RestController
public class OrderController {
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	OrderDetailDAO orderDetailDAO;
	@Autowired
	StaffDAO staffDAO;
	
	@GetMapping("orders/list")
	public List<Orders> getOrderList(){
		return orderDAO.findAll(Sort.by(Sort.Direction.DESC, "updateDate"));
	}
	@GetMapping("orders/list/{id}")
	public Set<Orders> getOrderByaStaff(@PathVariable Long id){
		return staffDAO.findById(id).get().getOrders();
	}
	@GetMapping("orderdetails/{id}")
	public List<OrderDetail> getOrderDetails(@PathVariable Long id){
		return orderDetailDAO.findAllByOrderId(id);
	}
	@PostMapping("orders/add")
	public Orders addAllDetails(@RequestBody Orders orders) {
		if(orders.getOrderDetails() == null) throw new RuntimeException("Khong gui duoc chi tiet don hang");
		Set<OrderDetail> details = orders.getOrderDetails();
		if(details.isEmpty()) throw new RuntimeException("Chi tiet don hang trong");
		if(orders.getTotalMoney()== null) orders.setTotalMoney(0.0);
		orders.setDateOrder(new Date());
		orders.setUpdateDate(new Date());
		orders.setOrderDetails(null);
		Orders returned = orderDAO.save(orders);
		Long id = returned.getId();
		System.out.println("id = "+id);
		for (OrderDetail orderDetail : details) {
			if(orderDetail.getProductOrder() == null) throw new RuntimeException("hang hoa null");
			Product tmp = productDAO.findById(orderDetail.getProductOrder().getId()).get();
			if(tmp.getQuantity() < orderDetail.getQuantity()) {
				orderDAO.deleteById(id);
				throw new RuntimeException(orderDetail.getIdProduct() + " khong co du so luong");
			}
			orderDetail.setIdProduct(orderDetail.getProductOrder().getId());
			orderDetail.setIdOrder(id);
			if(orderDetail.getDiscount() ==null) orderDetail.setDiscount(0);
			int n = orderDetail.getQuantity();
	//		System.out.println("n = " + n);
			if(n>10) orderDetail.setUnitPrice(orderDetail.getProductOrder().getWholesalePrice());
			else orderDetail.setUnitPrice(orderDetail.getProductOrder().getRetailPrice());
			orderDetail.setFinalPrice(n*orderDetail.getUnitPrice()*(100-orderDetail.getDiscount())/100);
			orderDetailDAO.save(orderDetail);
			returned.setTotalMoney(returned.getTotalMoney()+orderDetail.getFinalPrice());
		}
		returned.setTotalMoney(returned.getTotalMoney()*(100-returned.getDiscount())/100 + returned.getCostShip());
		return orderDAO.save(returned);
	}
	
	@PutMapping("orders/{id}")
	public Orders editStatus(@RequestBody Orders orders, @PathVariable Long id) {
		Orders temp = orderDAO.findById(id).get();
		temp.setState(orders.getState());
		temp.setUpdateDate(new Date());
		return orderDAO.save(temp);
	}
}
