package com.exchange.currency_exchange.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvertionParameters {
    private String base;
    private BigDecimal amount;
    private String from;
    private String to;
    private String startDate;
    private String endDate;

    public boolean equalCurrency(){
        return from.equals(to);
    }


}
