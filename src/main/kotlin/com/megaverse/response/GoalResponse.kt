package com.megaverse.response

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.megaverse.model.EmptySpace
import com.megaverse.model.Megaverse
import com.megaverse.service.AstralObjectFactory

data class GoalResponse @JsonCreator constructor(
    @JsonProperty("goal") val goal: Array<Array<String>>
)


fun GoalResponse.toMegaverse(): Megaverse {
    val astralObjectGrid = goal.mapIndexed { rowIndex, row ->
        row.mapIndexed { colIndex, element ->
            AstralObjectFactory.createFromRaw(element, rowIndex, colIndex) ?: EmptySpace(rowIndex, colIndex)
        }.toTypedArray()
    }.toTypedArray()

    return Megaverse(astralObjectGrid)
}