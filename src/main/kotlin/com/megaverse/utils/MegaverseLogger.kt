package com.megaverse.utils

import java.util.logging.Level
import java.util.logging.Logger

object MegaverseLogger {
    val logger: Logger = Logger.getLogger("megaverse-logs")
}

fun Logger.severe(message: String?, e: Exception) {
    log(Level.SEVERE, message, e)
}
