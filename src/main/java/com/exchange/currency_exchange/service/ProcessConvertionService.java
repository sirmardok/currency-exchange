package com.exchange.currency_exchange.service;

import com.exchange.currency_exchange.dto.Convertion;
import com.exchange.currency_exchange.dto.ConvertionParameters;
import com.exchange.currency_exchange.dto.ConvertionRates;
import com.exchange.currency_exchange.utilities.ConvertOperations;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProcessConvertionService {
	
	Convertion process(ConvertionRates convertionRates, ConvertionParameters convertionParameters) {
        return Convertion.builder()
                                 .date(convertionRates.getDate())
                                 .fromAmount(convertionParameters.getAmount())
                                 .fromCurrency(convertionParameters.getFrom())
                                 .toCurrency(convertionParameters.getTo())
                                 .toAmount(ConvertOperations.getMultiplyOperation(
                                		 convertionRates.getRates().get(convertionParameters.getTo()),
                                		 convertionParameters.getAmount()))
                                 .build();
    }

}
