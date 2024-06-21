package com.anand.data.repository

import com.anand.data.model.FixtureDto
import com.anand.data.network.ApiResponse
import com.anand.data.network.ApiService
import com.anand.data.repository.FixtureRepositoryImpl
import com.anand.domain.model.Fixture
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import kotlin.test.assertEquals

class FixtureRepositoryImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var fixtureRepository: FixtureRepositoryImpl

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        fixtureRepository = FixtureRepositoryImpl(apiService)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `getFixtures should return list of fixtures`() {
        // Given
        val mockFixture = FixtureDto(
            id = 1, name = "Fixture 1", result_info = "Win", starting_at = "2024-06-21T12:00:00Z"
        )
        val mockApiResponse = ApiResponse(listOf(mockFixture))
        val mockResponseBody = Gson().toJson(mockApiResponse)
        mockWebServer.enqueue(MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(mockResponseBody))

        // When
        val flow = fixtureRepository.getFixtures()

        // Then
        runBlocking {
            flow.collect { fixtures ->
                assertEquals(1, fixtures.size)
                assertEquals(1, fixtures[0].id)
                assertEquals("Fixture 1", fixtures[0].name)
                assertEquals("Win", fixtures[0].resultInfo)
                assertEquals("2024-06-21T12:00:00Z", fixtures[0].startingAt)
            }
        }
    }
}
