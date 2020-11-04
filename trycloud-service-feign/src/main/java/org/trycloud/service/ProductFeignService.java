package org.trycloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.trycloud.config.FeignClientConfig;
import org.trycloud.entity.Product;

@FeignClient(name="TRYCLOUD-PROVIDER-PRODUCT",configuration=FeignClientConfig.class,
fallbackFactory=IProductClientServiceFallbackFactory.class)
public interface ProductFeignService {
	@RequestMapping(value="/prodcut/get/{id}")
    public Product get(@PathVariable("id") long id);
	
	@RequestMapping("/prodcut/list")
    public  List<Product> list() ;

    @RequestMapping("/prodcut/add")
    public boolean add(Product product) ;
}
