package com.exchange.currency_exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import spock.lang.Specification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyExchangeApplicationTests extends Specification {

    @Autowired
    Environment environment;

    /*def "application should start up properly"() {
        expect:
            environment != null
	}*/

}