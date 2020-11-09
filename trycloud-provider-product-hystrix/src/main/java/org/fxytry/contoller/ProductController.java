package org.fxytry.contoller;

import javax.annotation.Resource;

import org.fxytry.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trycloud.entity.Product;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/prodcut")
public class ProductController {
	@Resource
    private ProductService productService;

    @RequestMapping(value="/get/{id}")
    @HystrixCommand(fallbackMethod="hystrixErrorMethod")
    public Object get(@PathVariable("id") long id) {
        Product product = this.productService.get(id) ;
        if(product == null) {
        	throw new RuntimeException("商品不存在");
        }
        return product;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.productService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }
    
    public Object hystrixErrorMethod(@PathVariable("id") long id) {
    	 Product product = new Product();
         product.setProductName("HystrixName");
         product.setProductDesc("HystrixDesc");
         product.setProductId(0L);
         return product;
    }
}
