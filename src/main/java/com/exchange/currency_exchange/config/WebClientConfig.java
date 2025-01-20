package com.exchange.currency_exchange.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.exchange.currency_exchange.adapter.CurrencyAdapter;
import com.exchange.currency_exchange.service.ExchangeApiService;


@ComponentScan("com.exchange.currency_exchange")
@Configuration
public class WebClientConfig {
	
	@Value("${provider.rates}")
	private String URL_BASE;
	
	@Value("${provider.access_key}")
	private String ACCESS_KEY;
	
    @Bean
    public ExchangeApiService exchangeRestCalls() {
        return new ExchangeApiService(new CurrencyAdapter(new RestTemplate()), URL_BASE, ACCESS_KEY);
    }

    @Bean
    public ExchangeComputationService exchangeService() {
        return new ExchangeComputationService();
    }

    @Bean
    public ExchangeService exchangeFacadeService() {
        return new ExchangeService();
    }

	}
	
}
