package com.sapo.team03.MCRM.Controller;

import java.util.Date;
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
import com.sapo.team03.MCRM.DAO.HanghoaDAO;
import com.sapo.team03.MCRM.Model.CTDonHang;
import com.sapo.team03.MCRM.Model.DonHang;
import com.sapo.team03.MCRM.Model.HangHoa;

@CrossOrigin(origins="*")
@RestController
public class DonhangController {
	@Autowired
	DonhangDAO donhangDAO;
	@Autowired
	CtDonhangDAO ctDonhangDAO;
	@Autowired
	HanghoaDAO hanghoaDAO;
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
	public DonHang addAllDetails(@RequestBody DonHang order) {
		if(order.getCtDonhang() == null) throw new RuntimeException("Khong gui duoc chi tiet don hang");
		Set<CTDonHang> details = order.getCtDonhang();
		if(details.isEmpty()) throw new RuntimeException("Chi tiet don hang trong");
		if(order.getTong_tien() == null) order.setTong_tien(0.0);
		order.setNgay_dathang(new Date());
		order.setCtDonhang(null);
		DonHang returned = donhangDAO.save(order);
		Long id = returned.getId();
		System.out.println("id = "+id);
		for (CTDonHang ctDonHang : details) {
			if(ctDonHang.getCtHangHoa() == null) throw new RuntimeException("hang hoa null");
			HangHoa tmp = hanghoaDAO.findById(ctDonHang.getCtHangHoa().getId()).get();
			if(tmp.getSo_luong() < ctDonHang.getSoLuong()) {
				donhangDAO.deleteById(id);
				throw new RuntimeException(ctDonHang.getIdHanghoa() + " khong co du so luong");
			}
			ctDonHang.setIdHanghoa(ctDonHang.getCtHangHoa().getId());
			ctDonHang.setIdDonhang(id);
			if(ctDonHang.getIdDonhang() == null) throw new RuntimeException("ID don hang null");
			if(ctDonHang.getIdHanghoa() == null) throw new RuntimeException("ID hang hoa null");
			if(ctDonHang.getChietKhau()==null) ctDonHang.setChietKhau(0);
			ctDonHang.setThanhTien(0.0);
			ctDonhangDAO.save(ctDonHang);
		}
		return returned;
	}	
//	@PostMapping("orderdetails/add/{id}")
//	public void addDetails(@PathVariable Long id, @RequestBody CTDonHang ct) {
//		ct.setIdDonhang(id);
//		ct.setIdHanghoa(ct.getCtHangHoa().getId());
//		ctDonhangDAO.save(ct);
//	}
}
