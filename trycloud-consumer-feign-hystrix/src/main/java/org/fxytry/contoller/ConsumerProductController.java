package org.fxytry.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trycloud.service.ProductFeignService;
import org.trycloud.service.ZuulFeignService;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
	@Resource
	private ProductFeignService productFeignService; 
	@Resource
	private ZuulFeignService zuulFeignService;
	
    @RequestMapping("/product/get")
    public Object getProduct(long id) {
      return productFeignService.get(id);
    }
    
    @RequestMapping("/product/getProductAndUser")
    public Object getProductAndUser(long id) {
        Map<String,Object> result = new HashMap();
        result.put("product",zuulFeignService.get(id));
        result.put("user",zuulFeignService.getUsers(id+""));
        return  result;
    }
    

}
