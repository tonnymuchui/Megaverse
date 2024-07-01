package com.megaverse.usecase

import com.megaverse.model.Megaverse
import com.megaverse.service.MegaverseService
import com.megaverse.utils.MegaverseLogger.logger
import org.springframework.stereotype.Service

@Service
class GetMegaverseGoalUseCase(private val megaverseService: MegaverseService) {

    operator fun invoke(candidateId: String): Megaverse? {
        return try {
            val goal = megaverseService.getGoalMap(candidateId)
            if (goal == null) {
                logger.severe("No goal found for User: $candidateId")
            }
            goal
        } catch (e: Exception) {
            logger.severe("Error fetching goal: ${e.message}")
            e.printStackTrace()
            null
        }
    }
}
