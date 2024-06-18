package com.anand.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anand.domain.model.Fixture
import com.anand.domain.usecase.GetFixturesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val getFixturesUseCase: GetFixturesUseCase
) : ViewModel() {
    private val _fixtures = MutableStateFlow<List<Fixture>>(emptyList())
    val fixtures: StateFlow<List<Fixture>> = _fixtures

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadFixtures()
    }

    private fun loadFixtures() {
        viewModelScope.launch {
            _isLoading.value = true
            getFixturesUseCase.execute().collect {
                _fixtures.value = it
                _isLoading.value = false
            }
        }
    }
}

