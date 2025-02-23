package dev.jgabriel.lightningnodes.data.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

inline fun <reified T> handleApi(
    noinline errorHandling: ((throwable: Throwable) -> T)? = { throwable -> throw throwable },
    callHandling: () -> T,
): T =
    try {
        callHandling.invoke()
    } catch (throwable: Throwable) {
        errorHandling?.invoke(throwable) ?: throwable as T
    } ?: throw Exception()


/*
* solution from
* https://stackoverflow.com/questions/51482169/how-to-parse-unix-timestamp-to-date-string-in-kotlin
* */
fun Long.fromUnixToDate(): String {
    val instant = Instant.ofEpochSecond(this)
    val dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("America/Sao_Paulo"))
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    return dateTime.format(formatter)
}

fun Long.fromSatToBtc() = this / 100000000.0