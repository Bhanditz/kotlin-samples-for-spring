package org.springframework.integration.samples.quote

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Random
import org.springframework.integration.annotation.MessageEndpoint
import org.springframework.integration.annotation.ServiceActivator

@MessageEndpoint
class QuoteService() {

    @ServiceActivator(inputChannel="tickers", outputChannel="quotes")
    public fun lookupQuote(ticker: String): Quote {
        val price = BigDecimal(Random().nextDouble() * 100)
        return Quote(ticker, price.setScale(2, RoundingMode.HALF_EVEN)!!)
    }


}
