package com.anand.presentation.ui


import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anand.domain.model.Fixture
import com.anand.domain.repository.FixtureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@RunWith(AndroidJUnit4::class)
class FixtureScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockFixtures = listOf(
        Fixture(1, "Fixture 1", "Result 1", "2023-06-11"),
        Fixture(2, "Fixture 2", "Result 2", "2023-06-12")
    )

    @Mock
    private lateinit var fixtureRepository: FixtureRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        setupMockRepository()
    }

    private fun setupMockRepository() {
        val flow = flow { emit(mockFixtures) }
        whenever(fixtureRepository.getFixtures()).thenReturn(flow)
    }

    @Test
    fun fixtureScreen_loadingState_displaysLoadingIndicator() {
        val isLoadingFlow = MutableStateFlow(true)
        val fixturesFlow = MutableStateFlow(emptyList<Fixture>())

       /* val fakeViewModel = object : FixtureViewModel(fixtureRepository) {
            override val isLoading: StateFlow<Boolean> = isLoadingFlow
            override val fixtures: StateFlow<List<Fixture>> = fixturesFlow
        }

        composeTestRule.setContent {
            FixtureScreen(viewModel = fakeViewModel)
        }*/

       // composeTestRule.onNodeWithText("Loading").assertExists()
    }

    @Test
    fun fixtureScreen_fixturesLoaded_displaysFixtures() {
        val isLoadingFlow = MutableStateFlow(false)
        val fixturesFlow = MutableStateFlow(mockFixtures)

       /* val fakeViewModel = object : FixtureViewModel(fixtureRepository) {
            override val isLoading: StateFlow<Boolean> = isLoadingFlow
            override val fixtures: StateFlow<List<Fixture>> = fixturesFlow
        }

        composeTestRule.setContent {
            FixtureScreen(viewModel = fakeViewModel)
        }*/

        composeTestRule.onNodeWithText("Fixture 1").assertExists()
        composeTestRule.onNodeWithText("Fixture 2").assertExists()
    }

    @Test
    fun fixtureItem_displaysCorrectInfo() {
        val fixture = Fixture(1, "Fixture 1", "Result 1", "2023-06-11")

        composeTestRule.setContent {
            FixtureItem(fixture = fixture)
        }

        composeTestRule.onNodeWithText("Fixture 1").assertExists()
        composeTestRule.onNodeWithText("Result 1").assertExists()
        composeTestRule.onNodeWithText("2023-06-11").assertExists()
    }
}
