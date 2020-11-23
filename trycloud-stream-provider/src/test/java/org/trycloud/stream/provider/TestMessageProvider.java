package org.trycloud.stream.provider;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.trycloud.entity.Product;
import org.trycloud.stream.provider.service.MessageProvider;

@SpringBootTest(classes = StreamProviderApp.class)
@RunWith(SpringRunner.class)
public class TestMessageProvider {
	@Resource
    private MessageProvider messageProvider;

    @Test
    public void testSend() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("messageName");
        product.setProductDesc("desc");
        messageProvider.send(product);
    }
}
