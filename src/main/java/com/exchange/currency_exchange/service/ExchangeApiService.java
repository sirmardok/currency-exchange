package com.exchange.currency_exchange.service;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

import com.exchange.currency_exchange.adapter.RestInterface;
import com.exchange.currency_exchange.dto.ConvertionRates;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
public class ExchangeApiService {
	
	private RestInterface restInterface;
    private String BASE_URL;
    private String ACCESS_KEY;    

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
