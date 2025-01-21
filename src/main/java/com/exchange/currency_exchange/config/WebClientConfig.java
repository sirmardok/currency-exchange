package com.exchange.currency_exchange.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.exchange.currency_exchange.adapter.CurrencyAdapter;
import com.exchange.currency_exchange.service.ConvertionService;
import com.exchange.currency_exchange.service.ExchangeApiService;
import com.exchange.currency_exchange.service.ProcessConvertionService;


@ComponentScan("com.exchange.currency_exchange")
@Configuration
public class WebClientConfig {
	
	@Value("${provider.rates}")
	private String URL_BASE;
	
	@Value("${provider.access_key}")
	private String ACCESS_KEY;
	
    @Bean
    ExchangeApiService exchangeRestCalls() {
        return new ExchangeApiService(new CurrencyAdapter(new RestTemplate()), URL_BASE, ACCESS_KEY);
    }

    @Bean
    ProcessConvertionService ConvertionService() {
        return new ProcessConvertionService();
    }

    @Bean
    ConvertionService ConvertionFacadeService() {
        return new ConvertionService();
    }

	}
	

