package org.trycloud.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.trycloud.entity.Product;

import feign.hystrix.FallbackFactory;
@Component
public class ProductClientServiceFallbackFactory implements FallbackFactory<ProductFeignService> {

	@Override
	public ProductFeignService create(Throwable throwable) {
		return new ProductFeignService() {
			
			@Override
			public List<Product> list() {
				return null;
			}
			
			@Override
			public Product get(@PathVariable("id")  long id) {
				Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return  product;
			}
			
			@Override
			public boolean add(Product product) {
				return false;
			}
		};
	}

}
