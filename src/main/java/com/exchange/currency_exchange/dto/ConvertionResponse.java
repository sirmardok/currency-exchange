package com.exchange.currency_exchange.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvertionResponse implements Serializable{
	@JsonInclude(NON_NULL)
    private String date;
    private BigDecimal fromAmount;
    private String from;
    private BigDecimal toAmount;
    private String to;


    public static ConvertionResponse from(Convertion convertion) {
        Log.info("CurrencyConvertion: {}", convertion);
        return ConvertionResponse
            .builder()
            .date(Convertion.getDate())
            .fromAmount(Convertion.getFromAmount())
            .from(Convertion.getFromCurrency())
            .toAmount(Convertion.getToAmount())
            .to(Convertion.getToCurrency())
            .build();
    }

}
