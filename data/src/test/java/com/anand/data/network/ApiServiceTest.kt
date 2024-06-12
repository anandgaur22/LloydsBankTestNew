package com.anand.data.network

// Add these imports at the top of your file
import com.anand.domain.model.Fixture
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

// Unit test class for ApiService
class ApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: ApiService

    @Before
    fun setup() {
        // Start the MockWebServer
        mockWebServer = MockWebServer()
        mockWebServer.start()

        // Initialize Retrofit with MockWebServer base URL
        val retrofit = Retrofit.Builder().baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create()).build()

        // Create an instance of ApiService using Retrofit
        apiService = retrofit.create(ApiService::class.java)
    }

    @After
    fun tearDown() {
        // Shutdown the MockWebServer after the test
        mockWebServer.shutdown()
    }

    @Test
    fun testGetFixturesAPICall():Unit = runBlocking {
        // Test code

        // Prepare mock response data
        val mockFixture = Fixture(
            id = 1, name = "Fixture 1", resultInfo = "Win", startingAt = "2024-06-11T12:00:00Z"
        )
        val mockApiResponse = ApiResponseTest(fixtures = listOf(mockFixture))
        val mockResponseBody = Gson().toJson(mockApiResponse)

        // Enqueue the mock response
        val mockResponse = MockResponse().setResponseCode(200).setBody(mockResponseBody)
        mockWebServer.enqueue(mockResponse)

        // Call the API method
        val apiResponse = apiService.getFixtures("api_token")

// Print the response body for debugging
        println(apiResponse)

        assertNotNull(apiResponse)

// Access properties of the response body only if it's not null
        apiResponse.data?.first()?.let { fixture ->
            // Assert that the fixture data matches the expected values
            assertEquals(1, fixture.id)
            assertEquals("Fixture 1", fixture.name)
            assertEquals("Win", fixture.result_info)
            assertEquals("2024-06-11T12:00:00Z", fixture.starting_at)
        }
    }
}
