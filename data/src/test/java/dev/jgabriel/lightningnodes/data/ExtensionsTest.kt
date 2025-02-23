package dev.jgabriel.lightningnodes.data

import dev.jgabriel.lightningnodes.data.util.fromSatToBtc
import dev.jgabriel.lightningnodes.data.util.fromUnixToDate
import junit.framework.TestCase.assertEquals
import org.junit.Test

internal class ExtensionsTest {
    // all the mock date for these test I get from: https://www.vultr.com/resources/unix-time-calculato
    @Test
    fun `fromUnixToDate - valid timestamp - returns formatted date`() {
        val timestamp = 1678886400L
        val expectedDate = "15/03/2023 10:20"

        val actualDate = timestamp.fromUnixToDate()

        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun `fromUnixToDate - zero timestamp - returns epoch date`() {
        val timestamp = 0L
        val expectedDate =
            "31/12/1969 21:00" // Expected date in BRT (adjust for your timezone if needed)

        val actualDate = timestamp.fromUnixToDate()

        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun `fromSatToBtc - valid satoshi value - returns correct btc value`() {
        val satoshi = 150000000L
        val expectedBtc = 1.5

        val actualBtc = satoshi.fromSatToBtc()

        assertEquals(expectedBtc, actualBtc)
    }

    @Test
    fun `fromSatToBtc - zero satoshi value - returns zero btc`() {
        val satoshi = 0L
        val expectedBtc = 0.0

        val actualBtc = satoshi.fromSatToBtc()

        assertEquals(expectedBtc, actualBtc)
    }

    @Test
    fun `fromSatToBtc - large satoshi value - returns correct btc value`() {
        val satoshi = 1234567890123456L
        val expectedBtc = 12345678.90123456

        val actualBtc = satoshi.fromSatToBtc()

        assertEquals(expectedBtc, actualBtc)
    }

    @Test
    fun `fromSatToBtc - fractional satoshi value - returns correct fractional btc value`() {
        val satoshi = 550000L
        val expectedBtc = 0.00550000

        val actualBtc = satoshi.fromSatToBtc()

        assertEquals(expectedBtc, actualBtc)
    }
}