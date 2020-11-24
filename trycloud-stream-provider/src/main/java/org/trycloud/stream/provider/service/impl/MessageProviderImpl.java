package org.trycloud.stream.provider.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.trycloud.channel.DefaultProcess;
import org.trycloud.entity.Product;
import org.trycloud.stream.provider.service.MessageProvider;
@EnableBinding(DefaultProcess.class)
public class MessageProviderImpl implements MessageProvider {
	@Resource
    @Qualifier("try_output")
    private MessageChannel output;  // 消息的发送管道
	@Override	
	public void send(Product product) {
		output.send(MessageBuilder.withPayload(product).build());
	}

}
