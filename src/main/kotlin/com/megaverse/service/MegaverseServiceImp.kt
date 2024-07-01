package com.megaverse.service

import com.megaverse.model.Comeths
import com.megaverse.model.Megaverse
import com.megaverse.model.Polyanets
import com.megaverse.model.Soloons
import com.megaverse.request.toRequest
import com.megaverse.response.GoalResponse
import com.megaverse.response.toMegaverse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class MegaverseServiceImp(
    @Value("\${metaverse.base.url}") private val baseUrl: String,
    private val restTemplate: RestTemplate = RestTemplate()
): MegaverseService {
    private val soloonsEndpoint = "$baseUrl/soloons"
    private val polyanetsEndpoint = "$baseUrl/polyanets"
    private val comethsEndpoint = "$baseUrl/comeths"

    override fun createPolyanet(candidateId: String, polyanet: Polyanets): Boolean =
        executePostRequest(polyanetsEndpoint, polyanet.toRequest(candidateId))

    override fun deletePolyanet(candidateId: String, polyanet: Polyanets): Boolean =
        executeDeleteRequest(polyanetsEndpoint, polyanet.toRequest(candidateId))

    override fun createSoloon(candidateId: String, soloon: Soloons): Boolean =
        executePostRequest(soloonsEndpoint, soloon.toRequest(candidateId))

    override fun deleteSoloon(candidateId: String, soloon: Soloons): Boolean =
        executeDeleteRequest(soloonsEndpoint, soloon.toRequest(candidateId))

    override fun createCometh(candidateId: String, cometh: Comeths): Boolean =
        executePostRequest(comethsEndpoint, cometh.toRequest(candidateId))

    override fun deleteCometh(candidateId: String, cometh: Comeths): Boolean =
        executeDeleteRequest(comethsEndpoint, cometh.toRequest(candidateId))

    override fun getGoalMap(candidateId: String): Megaverse? {
        val url = UriComponentsBuilder.fromHttpUrl("$baseUrl/map/{candidateId}/goal")
            .buildAndExpand(candidateId)
            .toUriString()

        val response: ResponseEntity<GoalResponse> = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            GoalResponse::class.java
        )

        val goalResponse: GoalResponse? = response.body

        return goalResponse?.toMegaverse()
    }

    private fun <A> executePostRequest(url: String, body: A): Boolean =
        restTemplate.postForEntity(url, body.toHttpEntity(), String::class.java)
            .statusCode.is2xxSuccessful

    private fun <A> executeDeleteRequest(url: String, body: A): Boolean =
        restTemplate.exchange(url, HttpMethod.DELETE, body.toHttpEntity(), String::class.java)
            .statusCode.is2xxSuccessful

    private fun <A> A.toHttpEntity(): HttpEntity<A> {
        val headers = org.springframework.http.HttpHeaders().apply { contentType = MediaType.APPLICATION_JSON }
        return HttpEntity(this, headers)
    }
}