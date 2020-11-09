package org.fxytry.mapper;

import java.util.List;

import org.trycloud.entity.Product;

public interface ProductMapper {
	 boolean create(Product product);
	 public Product findById(Long id);
	 public List<Product> findAll();
}
