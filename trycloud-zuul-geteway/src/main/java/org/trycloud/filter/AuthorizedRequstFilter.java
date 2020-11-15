package org.trycloud.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthorizedRequstFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext() ;
		String authinfo = "fxy:123456";
		byte[] encodedAuth = Base64.getEncoder()
                .encode(authinfo.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic "+new String(encodedAuth);
		currentContext.addZuulRequestHeader("Authorization", authHeader);
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
