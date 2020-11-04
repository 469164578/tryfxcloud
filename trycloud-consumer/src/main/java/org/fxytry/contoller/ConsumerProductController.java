package org.fxytry.contoller;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.trycloud.entity.Product;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
	
	public static final String PRODUCT_GET_URL = "http://TRYCLOUD-PROVIDER-PRODUCT/prodcut/get/";
    public static final String PRODUCT_LIST_URL="http://TRYCLOUD-PROVIDER-PRODUCT/prodcut/list/";
    public static final String PRODUCT_ADD_URL = "http://TRYCLOUD-PROVIDER-PRODUCT/prodcut/add/";
    
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders httpHeaders;
    @Resource
    private LoadBalancerClient loadBalancerClient;
    
    @RequestMapping("/product/get")
    public Object getProduct(long id) {
       // Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
//    	 Product product = restTemplate.exchange(PRODUCT_GET_URL + id, 
//    			 HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
    	ServiceInstance serviceInstance = loadBalancerClient.choose("TRYCLOUD-PROVIDER-PRODUCT");
    	System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
    	Product product = restTemplate.exchange(PRODUCT_GET_URL + id,
    			HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return  product;
    }
    
    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
        return  result;
    }

}
