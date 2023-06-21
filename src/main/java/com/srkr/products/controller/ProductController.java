package com.srkr.products.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srkr.products.entity.Product;
import com.srkr.products.service.ProductService;

@RestController
@RequestMapping("/products/api/")
public class ProductController {

	private ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public List<Product> getProducts() {
		return service.products();
	}

	@PostMapping("/save")
	public Product add(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@PutMapping("/update/{pId}")
	public Product update(@PathVariable Integer pId, @RequestBody Product product) {
		return service.updateProduct(pId, product);
	}

	@GetMapping("/getbyid/{pId}")
	public Product findById(@PathVariable Integer pId) {
		return service.findProductById(pId);
	}

	@DeleteMapping("/delete/{pId}")
	public void delete(@PathVariable Integer pId) {
		service.deleteProduct(pId);
	}
}
