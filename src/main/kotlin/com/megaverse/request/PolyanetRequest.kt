package com.megaverse.request

import com.megaverse.model.Comeths
import com.megaverse.model.Polyanets
import com.megaverse.model.Soloons

data class PolyanetRequest(
    val candidateId: String,
    val row: Int,
    val column: Int
)

fun Polyanets.toRequest(candidateId: String): PolyanetRequest = PolyanetRequest(
    candidateId = candidateId,
    row = x,
    column = y
)

data class SoloonRequest(
    val candidateId: String,
    val row: Int,
    val column: Int,
    val color: String
)

fun Soloons.toRequest(candidateId: String): SoloonRequest = SoloonRequest(
    candidateId = candidateId,
    row = x,
    column = y,
    color = color.toString()
)

data class ComethRequest(
    val candidateId: String,
    val row: Int,
    val column: Int,
    val direction: String
)

fun Comeths.toRequest(candidateId: String): ComethRequest = ComethRequest(
    candidateId = candidateId,
    row = x,
    column = y,
    direction = direction.toString()
)