package com.exchange.currency_exchange.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exchange.currency_exchange.dto.Convertion;
import com.exchange.currency_exchange.dto.ConvertionParameters;
import com.exchange.currency_exchange.dto.ConvertionRates;
import com.exchange.currency_exchange.utilities.ConvertOperations;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import static java.math.BigDecimal.ONE;

@RequiredArgsConstructor
@AllArgsConstructor
public class ConvertionService {
	
	@Autowired
	ExchangeApiService exchangeApiService;

    @Autowired
    ProcessConvertionService processConvertionService;

    public ConvertionRates latest(String base) {
        return exchangeApiService.getLatest(base);
    }    
   
    public Convertion process(ConvertionParameters convertionParameters) {

        if (convertionParameters.equalCurrency()) {
            return getCurrencyConvertion(convertionParameters);
        }

        return processConvertionService.process(
        		ExchangeApiService.getLatest(convertionParameters.getFrom()),
            convertionParameters);
    }   

    private Convertion getCurrencyConvertion(ConvertionParameters convertionParameters) {
        return Convertion.builder()
                                 .date(ConvertOperations.getYesterdayDateString())
                                 .fromAmount(convertionParameters.getAmount())
                                 .fromCurrency(convertionParameters.getFrom())
                                 .toCurrency(convertionParameters.getTo())
                                 .toAmount(
                                	ConvertOperations.getMultiplyOperation(ONE,
                                    		 convertionParameters.getAmount()))
                                 .build();
    }

}
