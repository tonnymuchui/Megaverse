package com.megaverse

import com.megaverse.exception.NoGoalFound
import com.megaverse.usecase.CreateMegaverseUseCase
import com.megaverse.service.MegaverseService
import com.megaverse.service.MegaverseServiceImp
import com.megaverse.usecase.GetMegaverseGoalUseCase
import com.megaverse.utils.Coroutines
import com.megaverse.utils.MegaverseLogger.logger

class MegaverseApplication(
    private val candidateId: String = ID,
    megaverseService: MegaverseService = MegaverseServiceImp(baseUrl),
    coroutines: Coroutines = Coroutines()
) {

    private val createMegaverseUseCase = CreateMegaverseUseCase(megaverseService, coroutines)
    private val getMegaverseGoalUseCase = GetMegaverseGoalUseCase(megaverseService)

    suspend fun execute() = try {
        val goal = getMegaverseGoalUseCase(candidateId) ?: throw NoGoalFound
        createMegaverseUseCase(candidateId, goal)
    } catch (ex: Exception) {
        logger.severe("ERROR: ${ex.javaClass}: ${ex.message}")
    }

    companion object {
        const val baseUrl = "https://coding-challenge-eosin.vercel.app/api/"
        const val ID = "1fb92cda-2896-4581-8ef2-eac06f758101"
    }
}

suspend fun main(args: Array<String>) {
    logger.info(" Welcome to Megaverse \n")
    MegaverseApplication().execute()

    logger.info("Created megaverse goal")
}
