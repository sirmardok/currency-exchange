package com.exchange.currency_exchange.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exchange.currency_exchange.dto.Convertion;
import com.exchange.currency_exchange.dto.ConvertionParameters;
import com.exchange.currency_exchange.dto.ConvertionRates;
import com.exchange.currency_exchange.utilities.ConvertOperations;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import static java.math.BigDecimal.ONE;

/**
 * 
 * @autor Miguel Garces
 * @version 1.0
 *  
 */

@RequiredArgsConstructor
@AllArgsConstructor
public class ConvertionService {
	/**
	 * --- Ejemplo de documentación ---
	 * Servicio que realiza las dos operaciones detalladas en el controlador
	 */
	@Autowired
	ExchangeApiService exchangeApiService;

    @Autowired
    ProcessConvertionService processConvertionService;
    
    /**
     * 
     * @param base
     * @return ConvertionRates
     * 
     */
    public ConvertionRates latest(String base) {
        return exchangeApiService.getLatest(base);
    }    
   
    /**
     * 
     * @param convertionParameters
     * @return Convertion
     */
    public Convertion process(ConvertionParameters convertionParameters) {

        if (convertionParameters.equalCurrency()) {
            return getCurrencyConvertion(convertionParameters);
        }

        return processConvertionService.process(
        		exchangeApiService.getLatest(convertionParameters.getFrom()),
            convertionParameters);
    }   
    
    /**
     * 
     * @param convertionParameters
     * @return Convertion
     */

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
