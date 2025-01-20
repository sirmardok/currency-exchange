package com.exchange.currency_exchange.adapter;

import java.net.URI;

import org.springframework.lang.Nullable;
import org.springframework.web.client.RestClientException;

public interface RestInterface {
	
	@Nullable
	<T> T getCurrencyInfo(URI url, Class<T> responseType) throws RestClientException;

}


