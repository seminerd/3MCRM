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
import org.springframework.web.bind.annotation.RestController;

import com.sapo.team03.MCRM.DAO.CategoryProductDAO;
import com.sapo.team03.MCRM.DAO.ProductDAO;
import com.sapo.team03.MCRM.Model.CategoryProduct;
import com.sapo.team03.MCRM.Model.Product;

@CrossOrigin(origins="*")
@RestController
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryProductDAO categoryProductDAO;

	@GetMapping("category/list")
	public List<CategoryProduct> getCategory(){
		return categoryProductDAO.findAll();
	}
	@GetMapping("category/{id}")
	public CategoryProduct getCateById(@PathVariable Long id) {
		return categoryProductDAO.findById(id).get();
	}
	@GetMapping("products/list")
	public List<Product> getProductList(){
		List<Product> prod = new ArrayList<>();
		for (Product product : productDAO.findAll()) {
			if(product.getCategoryProduct()!= null) {
				product.setCatName(product.getCategoryProduct().getName());
			}
			prod.add(product);
		}
		return prod;
	}
	@GetMapping("products/{id}")
	public Product getProductById(@PathVariable Long id) {
		Product prod =  productDAO.findById(id).get();
		if(prod.getCategoryProduct()!= null) {
			prod.setCatName(prod.getCategoryProduct().getName());
		}
		return prod;
	}
	@PostMapping("products/add")
	public Product addProduct(@RequestBody Product product) {
		List<Product> hh = productDAO.findAll();
		for (Product prod : hh) {
			if(prod.equals(product)) throw new RuntimeException("Product existed");
		}
		if(product.getCategoryProduct()==null && product.getCatName()!= null) {
			String catName = product.getCatName();
			CategoryProduct cat = categoryProductDAO.findCatByName(catName);
			if(cat == null) {
				CategoryProduct temp = new CategoryProduct();
				temp.setName(catName);
				categoryProductDAO.save(temp);
				temp = categoryProductDAO.findCatByName(catName);
				product.setCategoryProduct(temp);
			}
			else product.setCategoryProduct(cat);
		}
		if(product.getSoldQuantity()==null) product.setSoldQuantity(0);
		return productDAO.save(product);
	}
	@PutMapping("products/{id}")
	public Product editProduct(@PathVariable Long id, @RequestBody Product hh) {
		Product product = productDAO.findById(id).get();
		if(hh.getName()!=null) product.setName(hh.getName());
		if(hh.getOrigin()!= null) product.setOrigin(hh.getOrigin());
		if(hh.getBrand()!=null) product.setBrand(hh.getBrand());
		if(hh.getQuantity()!= null) product.setQuantity(hh.getQuantity());
		if(hh.getSoldQuantity()!= null) product.setSoldQuantity(hh.getSoldQuantity());
		if(hh.getPurchasePrice()!= null) product.setPurchasePrice(hh.getPurchasePrice());
		if(hh.getWholesalePrice()!= null) product.setWholesalePrice(hh.getWholesalePrice());
		if(hh.getRetailPrice()!= null) product.setRetailPrice(hh.getRetailPrice());
		if(hh.getTax()!= null) product.setTax(hh.getTax());
		if(hh.getDescription()!= null) product.setDescription(hh.getDescription());
		if(hh.getImage()!= null) product.setImage(hh.getImage());
		if(hh.getUnit()!= null) product.setUnit(hh.getUnit());
		if(hh.getCategoryProduct()!= null) product.setCategoryProduct(hh.getCategoryProduct());
		if(hh.getCategoryProduct()==null &&  hh.getCatName()!= null) {
			String temp = hh.getCatName();
			if(categoryProductDAO.findCatByName(temp)==null) {
				CategoryProduct c = new CategoryProduct(temp);
				categoryProductDAO.save(c);
			}
			CategoryProduct cat = categoryProductDAO.findCatByName(temp);
			product.setCategoryProduct(cat);
			product.setCatName(temp);
		}
		productDAO.save(product);
		return productDAO.findById(id).get();
	}
	@DeleteMapping("products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productDAO.deleteById(id);
	}
}
