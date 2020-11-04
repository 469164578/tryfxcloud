package org.trycloud.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.trycloud.entity.Product;

import feign.hystrix.FallbackFactory;
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<ProductFeignService>{

	@Override
	public ProductFeignService create(Throwable throwable) {
		return new ProductFeignService() {
			
			@Override
			public List<Product> list() {
				return null;
			}
			
			@Override
			public Product get(long id) {
				Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return  product;
			}
			
			@Override
			public boolean add(Product product) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
