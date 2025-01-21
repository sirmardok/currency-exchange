package com.exchange.currency_exchange.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.exchange.currency_exchange.utilities.Log;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestRatesResponse implements Serializable{
	
	private String base;
    @JsonInclude(NON_NULL)
    private String date;
    private Map<String, BigDecimal> rates;

    public static LatestRatesResponse from(ConvertionRates exchangeRates) {
        Log.info("ExchangeRates: {}", exchangeRates);
        return LatestRatesResponse
            .builder()
            .base(exchangeRates.getBase())
            .date(exchangeRates.getDate())
            .rates(exchangeRates.getRates())
            .build();
    }
	

}
