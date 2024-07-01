package com.megaverse.common
import com.megaverse.exception.DirectionException

enum class Direction(val vector: Position) {
    UP_LEFT(Position(-1, -1)),
    UP(Position(-1, 0)),
    UP_RIGHT(Position(-1, 1)),
    LEFT(Position(0, -1)),
    RIGHT(Position(0, 1)),
    DOWN_LEFT(Position(1, -1)),
    DOWN(Position(1, 0)),
    DOWN_RIGHT(Position(1, 1));

    override fun toString(): String = name.lowercase()

    companion object {
        fun fromString(direction: String): Direction = try {
            valueOf(direction.uppercase())
        } catch (e: IllegalArgumentException) {
            throw DirectionException(direction)
        }
    }
}