package com.megaverse.service

import com.megaverse.model.Comeths
import com.megaverse.model.Megaverse
import com.megaverse.model.Polyanets
import com.megaverse.model.Soloons

interface MegaverseService {
    fun createSoloon(candidateId: String, soloon: Soloons): Boolean
    fun deleteSoloon(candidateId: String, soloon: Soloons): Boolean
    fun createCometh(candidateId: String, cometh: Comeths): Boolean
    fun createPolyanet(candidateId: String, polyanet: Polyanets): Boolean
    fun deletePolyanet(candidateId: String, polyanet: Polyanets): Boolean
    fun deleteCometh(candidateId: String, cometh: Comeths): Boolean
    fun getGoalMap(candidateId: String): Megaverse?

}