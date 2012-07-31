package org.springframework.integration.samples.quote

import java.math.BigDecimal

class Quote(val ticker: String, val price: BigDecimal) {
    public fun toString(): String? {
        return ticker + ": " + price
    }
}
