package com.megaverse.service

import com.megaverse.common.Color
import com.megaverse.common.Direction
import com.megaverse.model.*

interface AstralObjectService {
    fun parseAstralObject(astralObject: String, row: Int, column: Int): AstralObject?
}
class PolynetService : AstralObjectService {
    companion object {
        private const val POLYANET = "POLYANET"
    }

    override fun parseAstralObject(astralObject: String, row: Int, column: Int): AstralObject? =
        if (astralObject == POLYANET) Polyanets(row, column) else null
}
class ComethService : AstralObjectService {
    companion object {
        private const val COMETH = "COMETH"
    }

    override fun parseAstralObject(astralObject: String, row: Int, column: Int): AstralObject? =
        if (astralObject.endsWith(COMETH)) {
            val direction = Direction.fromString(astralObject.substringBefore("_"))
           Comeths(direction, row, column)
        } else {
            null
        }
}

class EmptySpaceService : AstralObjectService {

    override fun parseAstralObject(astralObject: String, row: Int, column: Int): AstralObject? {
        return if (astralObject == EMPTY_SPACE) {
            EmptySpace(row, column)
        } else {
            null
        }
    }
    companion object {
        private const val EMPTY_SPACE = "SPACE"
    }
}
class SoloonService : AstralObjectService {
    companion object {
        private const val SOLOON = "SOLOON"
    }

    override fun parseAstralObject(astralObject: String, row: Int, column: Int): AstralObject? =
        if (astralObject.endsWith(SOLOON)) {
            val color = Color.fromString(astralObject.substringBefore("_"))
            Soloons(color, row, column)
        } else {
            null
        }
}