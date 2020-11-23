package org.trycloud.stream.provider.service;

import org.trycloud.entity.Product;

public interface MessageProvider {
	void send(Product product);
}
