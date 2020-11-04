package org.fxytry.contoller;

import javax.annotation.Resource;

import org.fxytry.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trycloud.entity.Product;

@RestController
@RequestMapping("/prodcut")
public class ProductController {
	@Resource
    private ProductService productService;

    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.productService.get(id) ;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.productService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }
}
