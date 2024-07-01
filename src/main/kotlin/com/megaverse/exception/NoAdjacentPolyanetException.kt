package com.megaverse.exception

import com.megaverse.model.Soloons

data class NoAdjacentPolyanetException(val soloon: Soloons) :
    RuntimeException("No polyanet for Soloon: $soloon")

object NoGoalFound : RuntimeException("No Goal Found") {
    private fun readResolve(): Any = NoGoalFound
}