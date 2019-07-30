package com.sapo.team03.MCRM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.NhomKhachhangDAO;
import com.sapo.team03.MCRM.Model.NhomKhachhang;

@RestController
@CrossOrigin(origins = "*")
public class NhomKhachhangController {
	@Autowired
	NhomKhachhangDAO nhomKhachhangDAO;
	@GetMapping("nhomkhachhang/list")
	public List<NhomKhachhang> getNhomKhachhang(){
		return nhomKhachhangDAO.findAll();
	}
	@GetMapping("nhomkhachhang/{id}")
	public NhomKhachhang getById(@PathVariable Long id) {
		return nhomKhachhangDAO.findById(id).get();
	}
	@PutMapping("nhomkhachhang/{id}")
	public NhomKhachhang editNhomKhachhang(@RequestBody NhomKhachhang nhomKhachhang, @PathVariable Long id) {
		NhomKhachhang tmp = nhomKhachhangDAO.findById(id).orElse(null);
		if(tmp==null) return null; 
		if(nhomKhachhang.getTen()!= null) tmp.setTen(nhomKhachhang.getTen());
		if(nhomKhachhang.getChietkhau()!= null) tmp.setChietkhau(nhomKhachhang.getChietkhau());
		if(nhomKhachhang.getGhichu()!= null) tmp.setGhichu(nhomKhachhang.getGhichu());
		if(nhomKhachhang.getGiaMacdinh()!=null) tmp.setGiaMacdinh(nhomKhachhang.getGiaMacdinh());
		if(nhomKhachhang.getThueMacdinh()!= null) tmp.setThueMacdinh(nhomKhachhang.getThueMacdinh());
		nhomKhachhangDAO.save(tmp);
		return nhomKhachhangDAO.findById(id).get();
	}	
}
