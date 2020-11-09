package org.fxytry.test;

import javax.annotation.Resource;

import org.fxytry.ProductHystrixApp;
import org.fxytry.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.trycloud.entity.Product;

@SpringBootTest(classes = ProductHystrixApp.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {
	
	@Resource
	private ProductService productService;
	
	@Test
    public void testGet() {
        System.out.println(productService.get(1));
    }
    @Test
    public void testAdd() {
        Product dept = new Product() ;
        dept.setProductName("fxy-" + System.currentTimeMillis());
        System.out.println(productService.add(dept));
    }
    @Test
    public void testList() {
        System.out.println(productService.list());
    }
}
