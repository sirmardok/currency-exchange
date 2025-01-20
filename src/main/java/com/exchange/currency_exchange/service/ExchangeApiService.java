package com.exchange.currency_exchange.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import com.exchange.currency_exchange.dto.ConvertionRates;
import com.exchange.currency_exchange.adapter.RestInterface;


@RequiredArgsConstructor
@AllArgsConstructor
public class ExchangeApiService {
	
	private RestInterface restInterface;
    private String BASE_URL;
    private String ACCESS_KEY;
    
    public ExchangeApiService() {
    	
    }
    
    public ExchangeApiService(RestInterface restInterface, String base_url, String access_key) {
    	this.restInterface = restInterface;
    	this.BASE_URL = base_url;
    	this.ACCESS_KEY = access_key;
    	
    }
    public ConvertionRates getLatest(String base) {

        URI targetUrl = UriComponentsBuilder.fromUriString(BASE_URL)
                                            .path("/v1/latest?access_key=" + ACCESS_KEY)
                                            .queryParam("base", base)
                                            .build()
                                            .encode()
                                            .toUri();

        return restInterface.getCurrencyInfo(targetUrl, ConvertionRates.class);
    }


   

}
