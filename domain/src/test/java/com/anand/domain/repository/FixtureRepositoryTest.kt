package com.anand.domain.repository

import com.anand.domain.model.Fixture
import com.anand.domain.repository.FixtureRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class FixtureRepositoryTest {

    @Mock
    private lateinit var fixtureRepository: FixtureRepository

    private val sampleFixtures = listOf(
        Fixture(1, "Fixture 1", "Result 1", "2024-06-11"),
        Fixture(2, "Fixture 2", "Result 2", "2024-06-12")
    )

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test getFixtures returns correct data`() = runBlockingTest {
        `when`(fixtureRepository.getFixtures()).thenReturn(flowOf(sampleFixtures))

        val result: Flow<List<Fixture>> = fixtureRepository.getFixtures()

        result.collect { fixtures ->
            assertEquals(2, fixtures.size)
            assertEquals("Fixture 1", fixtures[0].name)
            assertEquals("Fixture 2", fixtures[1].name)
        }

        verify(fixtureRepository, times(1)).getFixtures()
    }
}
