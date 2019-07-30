package com.sapo.team03.MCRM.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CategoryHanghoaDAO;
import com.sapo.team03.MCRM.DAO.HanghoaDAO;
import com.sapo.team03.MCRM.Model.CategoryHangHoa;
import com.sapo.team03.MCRM.Model.HangHoa;

@CrossOrigin(origins="*")
@RestController
public class HanghoaController {
	@Autowired
	HanghoaDAO hanghoaDAO;
	@Autowired
	CategoryHanghoaDAO categoryDAO;
	@GetMapping("products/list")
	public List<HangHoa> getProductList(){
		List<HangHoa> hh = new ArrayList<>();
		for (HangHoa hangHoa : hanghoaDAO.findAll()) {
			if(hangHoa.getCategoryHangHoa()!= null) {
				hangHoa.setCatName(hangHoa.getCategoryHangHoa().getTen());
			}
			hh.add(hangHoa);
		}
		return hh;
	}
	@GetMapping("products/{id}")
	public HangHoa getProductById(@PathVariable Long id) {
		HangHoa hh =  hanghoaDAO.findById(id).get();
		if(hh.getCategoryHangHoa()!= null) {
			hh.setCatName(hh.getCategoryHangHoa().getTen());
		}
		return hh;
	}
	@PostMapping("products/add")
	public HangHoa addProduct(@RequestBody HangHoa hanghoa) {
		List<HangHoa> hh = hanghoaDAO.findAll();
		for (HangHoa hangHoa2 : hh) {
			if(hangHoa2.equals(hanghoa)) throw new RuntimeException("Product existed");
		}
		if(hanghoa.getCategoryHangHoa()==null && hanghoa.getCatName()!= null) {
			String catName = hanghoa.getCatName();
			CategoryHangHoa cat = categoryDAO.findCatByName(catName);
			if(cat == null) {
				CategoryHangHoa temp = new CategoryHangHoa();
				temp.setTen(catName);
				categoryDAO.save(temp);
				temp = categoryDAO.findCatByName(catName);
				hanghoa.setCategoryHangHoa(temp);
			}
			else hanghoa.setCategoryHangHoa(cat);
		}
		return hanghoaDAO.save(hanghoa);
	}
	@PutMapping("products/{id}")
	public HangHoa editProduct(@PathVariable Long id, @RequestBody HangHoa hh) {
		HangHoa hanghoa = hanghoaDAO.findById(id).get();
		if(hh.getTen()!=null) hanghoa.setTen(hh.getTen());
		if(hh.getXuat_su()!= null) hanghoa.setXuat_su(hh.getXuat_su());
		if(hh.getHang_sx()!=null) hanghoa.setHang_sx(hh.getHang_sx());
		if(hh.getSo_luong()!= null) hanghoa.setSo_luong(hh.getSo_luong());
		if(hh.getSoluong_daban()!= null) hanghoa.setSoluong_daban(hh.getSoluong_daban());
		if(hh.getGia_nhap()!= null) hanghoa.setGia_nhap(hh.getGia_nhap());
		if(hh.getGia_xuatbuon()!= null) hanghoa.setGia_xuatbuon(hh.getGia_xuatbuon());
		if(hh.getGia_xuatle()!= null) hanghoa.setGia_xuatle(hh.getGia_xuatle());
		if(hh.getThue()!= null) hanghoa.setThue(hh.getThue());
		if(hh.getMo_ta()!= null) hanghoa.setMo_ta(hh.getMo_ta());
		if(hh.getHinh_anh()!= null) hanghoa.setHinh_anh(hh.getHinh_anh());
		if(hh.getDon_vi()!= null) hanghoa.setDon_vi(hh.getDon_vi());
		if(hh.getCategoryHangHoa()!= null) hanghoa.setCategoryHangHoa(hh.getCategoryHangHoa());
		if(hh.getCategoryHangHoa()==null &&  hh.getCatName()!= null) {
			String temp = hh.getCatName();
			if(categoryDAO.findCatByName(temp)==null) {
				CategoryHangHoa c = new CategoryHangHoa(temp);
				categoryDAO.save(c);
			}
			CategoryHangHoa cat = categoryDAO.findCatByName(temp);
			hanghoa.setCategoryHangHoa(cat);
			hanghoa.setCatName(temp);
		}
		hanghoaDAO.save(hanghoa);
		return hanghoaDAO.findById(id).get();
	}
	@DeleteMapping("products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		hanghoaDAO.deleteById(id);
	}
	
	@GetMapping("category/list")
	public List<CategoryHangHoa> getCategory(){
		return categoryDAO.findAll();
	}
	@GetMapping("category/{id}")
	public CategoryHangHoa getCateById(@PathVariable Long id) {
		return categoryDAO.findById(id).get();
	}
	@PostMapping("category/add")
	CategoryHangHoa addCategory(@RequestBody CategoryHangHoa c) {
		return categoryDAO.save(c);
	}
	@RequestMapping("addCat/{name}")
	public void addCat(@PathVariable String name) {
		categoryDAO.addCatByName(name);
	}
	
}
