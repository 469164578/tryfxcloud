package org.trycloud.stream.consumer.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.trycloud.channel.DefaultProcess;
import org.trycloud.entity.Product;
@Component
@EnableBinding(DefaultProcess.class)
public class MessageListener {
	@StreamListener(DefaultProcess.INPUT)
    public void input(Message<Product> message) {
        System.err.println("【*** 消息接收 ***】" + message.getPayload());
    }
}
