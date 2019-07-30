package com.sapo.team03.MCRM.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CtDonhangDAO;
import com.sapo.team03.MCRM.DAO.DonhangDAO;
import com.sapo.team03.MCRM.Model.CTDonHang;
import com.sapo.team03.MCRM.Model.DonHang;

@CrossOrigin(origins="*")
@RestController
public class DonhangController {
	@Autowired
	DonhangDAO donhangDAO;
	@Autowired
	CtDonhangDAO ctDonhangDAO;
	
	@GetMapping("orders/list")
	public List<DonHang> getOrderList(){
		return donhangDAO.findAll();
	}
	@GetMapping("orderdetails/{id}")
	public List<CTDonHang> getOrderDetails(@PathVariable Long id){
		return ctDonhangDAO.findAllByOrderId(id);
	}
	@PostMapping("orderdetails/add")
	public void addOrderDetails(@RequestBody List<CTDonHang> list) {
		for (CTDonHang ctDonHang : list) {
			if(ctDonHang.getChietKhau()==null) ctDonHang.setChietKhau(0);
			ctDonHang.setThanhTien(0.0);
			ctDonhangDAO.save(ctDonHang);
		}
	}
	@PostMapping("orders/add")
	public void addOrder(@RequestBody DonHang donhang) {
		if(donhang.getTong_tien() == null) donhang.setTong_tien(0.0);
		donhangDAO.save(donhang);
	}
	@PostMapping("orders/add-all")
	public void addAllDetails(@RequestBody DonHang order) {
		Set<CTDonHang> details = order.getCtDonhang();
		if(order.getTong_tien() == null) order.setTong_tien(0.0);
		order.setCtDonhang(null);
		DonHang returned = donhangDAO.save(order);
		for (CTDonHang ctDonHang : details) {
			ctDonHang.setIdDonhang(returned.getId());
			if(ctDonHang.getChietKhau()==null) ctDonHang.setChietKhau(0);
			ctDonHang.setThanhTien(0.0);
			ctDonhangDAO.save(ctDonHang);
		}
	}

}
