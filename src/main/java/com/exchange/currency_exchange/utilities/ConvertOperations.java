package com.exchange.currency_exchange.utilities;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertOperations {
	
	 private static final Integer DECIMAL_PRECISION = 5;	 
	 
	 private static final MathContext MATH_CTX = new MathContext(DECIMAL_PRECISION, RoundingMode.HALF_UP);
	 
	 private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


	 public static BigDecimal getMultiplyOperation(BigDecimal rate, BigDecimal amount) {
		 return rate.multiply(amount, MATH_CTX);
	 }
	 
	 private static Date yesterday() {
		 
		 final Calendar cal = Calendar.getInstance();
	     cal.add(Calendar.DATE, -1);
	     return cal.getTime();
	 }

	 public static String getYesterdayDateString() {
		 
	        return simpleDateFormat.format(yesterday());
	        
	    }
	    
	    

}
