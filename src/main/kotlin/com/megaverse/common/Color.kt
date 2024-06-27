package com.megaverse.common

import com.megaverse.exception.ColorException

enum class Color{
    BLUE, RED, PURPLE, WHITE;

    override fun toString(): String = super.toString().lowercase()

    companion object {
        fun fromString(color: String): Color = try {
            Color.valueOf(color.uppercase())
        } catch (e: IllegalArgumentException) {
            throw ColorException(color)
        }
    }
}