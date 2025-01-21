package com.exchange.currency_exchange.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.currency_exchange.dto.ConvertionParameters;
import com.exchange.currency_exchange.dto.ConvertionResponse;
import com.exchange.currency_exchange.dto.LatestRatesResponse;
import com.exchange.currency_exchange.service.ConvertionService;

import lombok.AllArgsConstructor;

/**
 * 
 * @autor Miguel Garces
 * @version 1.0
 *  
 */


@RestController
@Validated
@AllArgsConstructor
public class ConvertionController {
	
	/**
	 * --- Ejemplo de documentación ---
	 * 
	 * Controlador principal contiene dos endpoints:
	 * 		l. /latest: Devuelve el listado total de monedas con su correspondiente valor a EUR
	 * 		2. /convert: Endpoint GET que recibe 3 parámetros y devuelve un json con la conversión de moneda 
	 */
	
	private final String validationMsg = "El tipo de moneda debe ser de tres(3) caracteres";
	private ConvertionService convertionService;
	
	@Cacheable(value = "latest")
    @RequestMapping("/latest")
    @GetMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public LatestRatesResponse latest(
        @RequestParam(value = "base", defaultValue = "EUR") @Size(max = 3, message = validationMsg) String base) {

        return LatestRatesResponse.from(
        		convertionService.latest(base));
    }

    @Cacheable(value = "convert")
    @RequestMapping("/convert")
    @GetMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ConvertionResponse convert(
        @RequestParam(value = "fromamount", defaultValue = "1") BigDecimal fromAmount,
        @RequestParam(value = "from") @Size(min = 3, max = 3, message = validationMsg) String fromCurrency,
        @RequestParam(value = "to") @Size(min = 3, max = 3, message = validationMsg) String toCurrency) {

        return ConvertionResponse.from(
        		convertionService.process(
        					ConvertionParameters.builder()
                              .amount(fromAmount)
                              .from(fromCurrency)
                              .to(toCurrency)
                              .build()));
	    }
    
    @RequestMapping("/health")
    @GetMapping()
    public String healthCheck() {
        return "currency-exchange - Funcionando OK";
    }

}
