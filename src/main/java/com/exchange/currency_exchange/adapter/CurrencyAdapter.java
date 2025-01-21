package com.exchange.currency_exchange.adapter;

import java.net.URI;

import org.springframework.lang.Nullable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.Value;


@Value
@RequiredArgsConstructor
public class CurrencyAdapter implements RestInterface {
	
    private RestTemplate restTemplate;    

	@Nullable
    public <T> T getCurrencyInfo(URI url, Class<T> responseType) throws RestClientException {

        return restTemplate.getForObject(url, responseType);
    }

}
