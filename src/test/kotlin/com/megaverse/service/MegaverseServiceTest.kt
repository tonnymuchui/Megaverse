package com.megaverse.service

import com.megaverse.common.Color
import com.megaverse.common.Direction
import com.megaverse.model.Comeths
import com.megaverse.model.Polyanets
import com.megaverse.model.Soloons
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MegaverseServiceTest {

    companion object {
        private const val BASE_URL = "https://coding-challenge-eosin.vercel.app/api/"
        private const val CANDIDATE_ID = "1fb92cda-2896-4581-8ef2-eac06f758101"
        private val DEFAULT_POLYANET = Polyanets(0, 0)
        private val DEFAULT_SOLOON = Soloons(Color.BLUE, 0, 0)
        private val DEFAULT_COMETH = Comeths(Direction.UP, 0, 0)
    }

    private lateinit var megaverseService: MegaverseService

    @BeforeEach
    fun setUp() {
        megaverseService = MegaverseServiceImp(BASE_URL)
    }

    @Test
    fun `should return the goal Megaverse`() {
        val goal = megaverseService.getGoalMap(CANDIDATE_ID)
        assertNotNull(goal, "Goal should not be null")
    }

    @Test
    fun `should create and delete a polyanet`() {
        val createResponse = megaverseService.createPolyanet(CANDIDATE_ID, DEFAULT_POLYANET)
        assertTrue(createResponse, "Polyanet creation should be successful")

        val deleteResponse = megaverseService.deletePolyanet(CANDIDATE_ID, DEFAULT_POLYANET)
        assertTrue(deleteResponse, "Polyanet deletion should be successful")
    }

    @Test
    fun `should create and delete a soloon`() {
        val createResponse = megaverseService.createSoloon(CANDIDATE_ID, DEFAULT_SOLOON)
        assertTrue(createResponse, "Soloon creation should be successful")

        val deleteResponse = megaverseService.deleteSoloon(CANDIDATE_ID, DEFAULT_SOLOON)
        assertTrue(deleteResponse, "Soloon deletion should be successful")
    }

    @Test
    fun `should create and delete a cometh`() {
        val createResponse = megaverseService.createCometh(CANDIDATE_ID, DEFAULT_COMETH)
        assertTrue(createResponse, "Cometh creation should be successful")

        val deleteResponse = megaverseService.deleteCometh(CANDIDATE_ID, DEFAULT_COMETH)
        assertTrue(deleteResponse, "Cometh deletion should be successful")
    }
}
