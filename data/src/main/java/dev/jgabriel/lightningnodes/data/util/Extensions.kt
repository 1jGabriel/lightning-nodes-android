package dev.jgabriel.lightningnodes.data.util

inline fun <reified T> handleApi(
    noinline errorHandling: ((throwable: Throwable) -> T)? = { throwable -> throw throwable },
    callHandling: () -> T,
): T =
    try {
        callHandling.invoke()
    } catch (throwable: Throwable) {
        errorHandling?.invoke(throwable) ?: throwable as T
    } ?: throw Exception()