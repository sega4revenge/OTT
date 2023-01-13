package com.sega.module.manager

import io.github.aakira.napier.Antilog
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.LogLevel
import io.github.aakira.napier.Napier

object LogManager {
    fun log(msg: String, level: LogLevel = LogLevel.DEBUG) {
        Napier.log(level, message = msg)
    }

    fun debugBuild() {
        Napier.base(DebugAntilog())
    }

    fun releaseBuild(antilog: Antilog) {
        Napier.base(antilog)
    }
}