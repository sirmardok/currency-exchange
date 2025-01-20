package com.exchange.currency_exchange.utilities;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {
	
	public static void info(String format, Object object){
        log.info(format, object);
    }

    public static void error(String format, Object object){
        log.error(format, object);
    }

}
