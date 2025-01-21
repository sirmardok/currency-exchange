package com.exchange.currency_exchange.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponentsBuilder;

import com.exchange.currency_exchange.adapter.RestInterface;
import com.exchange.currency_exchange.dto.ConvertionRates;
import com.exchange.currency_exchange.utilities.Log;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Miguel Garces
 * 
 */

@RequiredArgsConstructor
@AllArgsConstructor
public class ExchangeApiService {
	/**
	 * Realiza el consumo del API http://api.exchangeratesapi.io
	 */
	private RestInterface restInterface;
    private String BASE_URL;
    private String ACCESS_KEY;    

    static final Logger logger = LoggerFactory.getLogger(ExchangeApiService.class);
    
    /**
     * 
     * @param base parametro de moneda, por defecto es EUR
     * @return ConvertionRates Objeto DTO para recibir la información de las tasas
     */
    
	public ConvertionRates getLatest(String base) {
		
		/**
		 * --- Ejemplo de documentación ---
		 * 
		 * Utiliza la clase UriComponentsBuilder para crear la dirección URI
		 * 
		 */

        URI targetUrl = UriComponentsBuilder.fromUriString(BASE_URL)
                                            .path("/v1/latest")
                                            .queryParam("base", base)
                                            .queryParam("access_key", ACCESS_KEY)
                                            .build()
                                            .encode()
                                            .toUri();
        
        logger.info("URI: " + targetUrl );
        
        /**
         * --- Ejemplo de documentación ---
         * 
         * Realiza el llamado al metodo gerCurrencyInfo para obtener la información del sitio web 
         * donde está disponible la información de las tasas
         */

        return restInterface.getCurrencyInfo(targetUrl, ConvertionRates.class);
    }


   

}
