package com.exchange.currency_exchange.dto;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;

@Data
public class ConvertionRates {
	
    private String base;
    private String date;
    private Map<String, BigDecimal> rates;
    
}
