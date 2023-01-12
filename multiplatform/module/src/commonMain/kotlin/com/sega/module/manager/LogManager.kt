package com.sega.module.manager

import io.github.aakira.napier.LogLevel
import io.github.aakira.napier.Napier

object LogManager {
    fun log(msg: String, level: LogLevel = LogLevel.DEBUG) {
        Napier.log(level, message = msg)
    }
}