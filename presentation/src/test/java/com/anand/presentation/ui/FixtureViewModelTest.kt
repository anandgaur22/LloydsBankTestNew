package com.anand.presentation.ui

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.anand.domain.model.Fixture
import com.anand.domain.repository.FixtureRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class FixtureViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var fixtureRepository: FixtureRepository

    private lateinit var fixtureViewModel: FixtureViewModel

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)

        val mockFixtures = listOf(
            Fixture(1, "Fixture 1", "Result 1", "2023-06-11"),
            Fixture(2, "Fixture 2", "Result 2", "2023-06-12")
        )

        Mockito.`when`(fixtureRepository.getFixtures()).thenReturn(flow { emit(mockFixtures) })

       fixtureViewModel = FixtureViewModel(fixtureRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetFixtures() = testScope.runTest {
        val job = launch {
            fixtureViewModel.fixtures.collect { fixtures ->
                Assert.assertEquals(2, fixtures.size)
                Assert.assertEquals("Fixture 1", fixtures[0].name)
                Assert.assertEquals("Fixture 2", fixtures[1].name)
            }
        }
        job.cancel()
    }

    @Test
    fun testLoadingState() = testScope.runTest {
        val loadingStates = mutableListOf<Boolean>()
        val job = launch {
            fixtureViewModel.isLoading.collect { isLoading ->
                loadingStates.add(isLoading)
            }
        }

        // Allow some time for loading states to be updated
        advanceUntilIdle()

        // Initially, loading should be true, then false after loading
        Assert.assertEquals(listOf(false), loadingStates)

        job.cancel()
    }
}
