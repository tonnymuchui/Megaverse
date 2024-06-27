package com.megaverse.common
import com.megaverse.exception.DirectionException

enum class Direction {
    UP, DOWN, RIGHT, LEFT;

    override fun toString(): String = name.lowercase()

    companion object {
        fun fromString(direction: String): Direction = try {
            valueOf(direction.uppercase())
        } catch (e: IllegalArgumentException) {
            throw DirectionException(direction)
        }
    }
}