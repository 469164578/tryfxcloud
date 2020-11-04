package org.fxytry.service;

import java.util.List;

import org.trycloud.entity.Product;

public interface ProductService {
	Product get(long id);
	boolean add(Product product);
	List<Product> list();
}
