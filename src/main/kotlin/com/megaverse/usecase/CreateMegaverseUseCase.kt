package com.megaverse.usecase

import com.megaverse.utils.Coroutines
import com.megaverse.exception.NoAdjacentPolyanetException
import com.megaverse.model.*
import com.megaverse.service.MegaverseService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger

@Service
class CreateMegaverseUseCase(
    @Qualifier("megaverseService") private val megaverseService: MegaverseService,
    private val coroutines: Coroutines = Coroutines(),
) {

    private val logger = LogManager.getLogger(CreateMegaverseUseCase::class.java)

    suspend operator fun invoke(candidateId: String, megaverse: Megaverse) {
        val requestCounter = AtomicInteger(0)

        megaverse.astralObjects.chunked(coroutines.batchSize).forEach { batch ->
            val jobs = batch.map { astralObject ->
                coroutines.async {
                    createAstralObject(candidateId, megaverse, astralObject)
                }
            }

            jobs.forEach { job ->
                job.await() // Wait for each job to complete
                requestCounter.incrementAndGet()
            }

            logger.info("Creating megaverse....")
            coroutines.delay() // Add delay as needed
        }

        logger.info("Total Astral : $requestCounter")
    }

    private suspend fun createAstralObject(candidateId: String, megaverse: Megaverse, astralObject: AstralObject) {
        when (astralObject) {
            is Comeths -> megaverseService.createCometh(candidateId, astralObject)
            is Polyanets -> megaverseService.createPolyanet(candidateId, astralObject)
            is Soloons -> createSoloon(candidateId, megaverse, astralObject)
            is EmptySpace -> {
            }
        }
    }

    private suspend fun createSoloon(candidateId: String, megaverse: Megaverse, soloon: Soloons): Boolean {
        val hasPOLYanetAdjacent = megaverse.getAdjacentAstralObjects(soloon).any { it is Polyanets }

        if (!hasPOLYanetAdjacent) throw NoAdjacentPolyanetException(soloon)

        return megaverseService.createSoloon(candidateId, soloon)
    }
}
