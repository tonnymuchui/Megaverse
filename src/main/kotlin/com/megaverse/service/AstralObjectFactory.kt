package com.megaverse.service

import com.megaverse.exception.AstralObjectException
import com.megaverse.model.AstralObject

object AstralObjectFactory {

    private val astralObjectProcessors = listOf(
        EmptySpaceService(),
        PolynetService(),
        SoloonService(),
        ComethService()
    )

    fun createFromRaw(astralObjectName: String, row: Int, column: Int): AstralObject =
        astralObjectProcessors.firstNotNullOfOrNull { processor ->
            processor.parseAstralObject(astralObjectName, row, column)
        } ?: throw AstralObjectException(astralObjectName)
}
