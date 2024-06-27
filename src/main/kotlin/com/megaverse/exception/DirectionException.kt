package com.megaverse.exception

data class DirectionException(val direction: String) : RuntimeException("$direction Not FOUND")
