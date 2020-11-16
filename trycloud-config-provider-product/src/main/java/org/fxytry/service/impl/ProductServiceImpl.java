package org.fxytry.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.fxytry.mapper.ProductMapper;
import org.fxytry.service.ProductService;
import org.springframework.stereotype.Service;
import org.trycloud.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Resource
    private ProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }

}
