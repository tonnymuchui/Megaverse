package com.megaverse.exception

data class ColorException(val color: String) : RuntimeException("$color Not Found")
