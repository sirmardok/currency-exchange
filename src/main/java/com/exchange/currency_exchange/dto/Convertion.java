package com.exchange.currency_exchange.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Convertion {
	
	private String date;
    private BigDecimal fromAmount;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal toAmount;

}
