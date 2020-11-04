package org.fxytry.contoller;

import java.net.URI;

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
	
	public static final String PRODUCT_TOPIC = "MICROCLOUD-PROVIDER-PRODUCT";
    
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
    	ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC) ;
    	System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
    	URI uri = URI.create(String.format("http://%s:%s/prodcut/get/"+id ,
                serviceInstance.getHost(), serviceInstance.getPort()));
    	Product product = restTemplate.exchange(uri,
    			HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return  product;
    }
    
   

}
