package com.srkr.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.srkr.products.entity.Product;
import com.srkr.products.exceptions.ProductNotFoundException;
import com.srkr.products.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> products() {
		return repository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product findProductById(Integer prodId) {

		return repository
				.findById(prodId)
				.orElseThrow(
						() -> new ProductNotFoundException("Product Not Found With ID : "
				+ prodId));
	}

	@Override
	public Product updateProduct(Integer prodId, Product product) {
		Product productById = findProductById(prodId);
		productById.setPname(product.getPname());
		productById.setDescription(product.getDescription());
		productById.setPrice(product.getPrice());

		repository.save(productById);
		return productById;
	}

	@Override
	public void deleteProduct(Integer prodId) {
		Product productById = findProductById(prodId);
		repository.delete(productById);
	}
}
