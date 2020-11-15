package org.trycloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.trycloud.config.FeignClientConfig;
import org.trycloud.entity.Product;
import org.trycloud.entity.Users;

@FeignClient(name = "TRYCLOUD-ZULL-GATEWAY",configuration = FeignClientConfig.class,
fallbackFactory=ZuulClientServiceFallbackFactory.class)
public interface ZuulFeignService {
	@RequestMapping(value="/trycloud/product-proxy/prodcut/get/{id}")
    public Product get(@PathVariable("id") long id);
	
	@RequestMapping("/trycloud/product-proxy/prodcut/list")
    public  List<Product> list() ;

    @RequestMapping("/trycloud/product-proxy/prodcut/add")
    public boolean add(Product product) ;
    
    @RequestMapping("/trycloud/users-proxy/users/get/{name}")
    public Users getUsers(@PathVariable("name")String name);
}
