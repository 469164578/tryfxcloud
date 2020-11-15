package org.trycloud.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.trycloud.entity.Product;
import org.trycloud.entity.Users;

import feign.hystrix.FallbackFactory;
@Component
public class ZuulClientServiceFallbackFactory implements FallbackFactory<ZuulFeignService> {

	@Override
	public ZuulFeignService create(Throwable throwable) {
		return new ZuulFeignService() {
			@Override
			public List<Product> list() {
				return null;
			}
			
			@Override
			public Users getUsers(String name) {
				Users user = new Users();
                user.setSex("F");
                user.setAge(17);
                user.setName("zuul-fllback："+name);
                return user;
			}
			
			@Override
			public Product get(long id) {
				Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-zuulName");
                product.setProductDesc("feign-zuulDesc");
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
