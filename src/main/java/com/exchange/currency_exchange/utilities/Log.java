package com.exchange.currency_exchange.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	
	static Logger LOGGER = LoggerFactory.getLogger(Log.class);
	
	public static void info(String format, Object object){
		LOGGER.info(format, object);
    }

    public static void error(String format, Object object){
    	LOGGER.error(format, object);
    }

}
