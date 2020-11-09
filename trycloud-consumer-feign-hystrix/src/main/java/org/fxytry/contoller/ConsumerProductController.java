package org.fxytry.contoller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trycloud.service.ProductFeignService;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
	@Resource
	private ProductFeignService productFeignService; 
	
    @RequestMapping("/product/get")
    public Object getProduct(long id) {
      return productFeignService.get(id);
    }
    

}
