package com.megaverse.model

import com.megaverse.common.Direction

typealias Astral = Array<Array<AstralObject>>
class Megaverse(private val astral: Astral) {

    val astralObjects: List<AstralObject>
        get() = astral.flatMap { it.toList() }.filterNot { it is EmptySpace }
    fun getAdjacentAstralObjects(astralObject: AstralObject): List<AstralObject> {
        val adjacentPositions = mutableListOf<AstralObject>()

        for (direction in Direction.entries) {
            val newX = astralObject.x + direction.vector.x
            val newY = astralObject.y + direction.vector.y

            if (newX in astral.indices && newY in astral[newX].indices) {
                adjacentPositions.add(astral[newX][newY])
            }
        }

        return adjacentPositions
    }
}