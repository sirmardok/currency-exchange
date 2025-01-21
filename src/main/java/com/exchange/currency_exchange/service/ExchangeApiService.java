package com.exchange.currency_exchange.service;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponentsBuilder;

import com.exchange.currency_exchange.adapter.RestInterface;
import com.exchange.currency_exchange.dto.ConvertionRates;
import com.exchange.currency_exchange.utilities.Log;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
public class ExchangeApiService {
	
	private RestInterface restInterface;
    private String BASE_URL;
    private String ACCESS_KEY;    

    static final Logger logger = LoggerFactory.getLogger(ExchangeApiService.class);
    
	public ConvertionRates getLatest(String base) {
		
		

        URI targetUrl = UriComponentsBuilder.fromUriString(BASE_URL)
                                            .path("/v1/latest")
                                            .queryParam("base", base)
                                            .queryParam("access_key", ACCESS_KEY)
                                            .build()
                                            .encode()
                                            .toUri();
        
        logger.info("URI: " + targetUrl );

        return restInterface.getCurrencyInfo(targetUrl, ConvertionRates.class);
    }


   

}
