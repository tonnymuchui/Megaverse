package com.megaverse.exception

class AstralObjectException (private val notFound: String) : RuntimeException("Astral Not Found: $notFound")