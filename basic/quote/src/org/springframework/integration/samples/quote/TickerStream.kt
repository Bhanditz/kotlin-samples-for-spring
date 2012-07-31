package org.springframework.integration.samples.quote

import java.util.Random

class TickerStream() {
    public fun nextTicker(): String {
        val chars = CharArray(3)
        for (i in 0..3 - 1) {
            chars[i] = ((Random().nextInt(25) + 65).toChar())
        }
        return String(chars)
    }


}
