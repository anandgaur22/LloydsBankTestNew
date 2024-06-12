package com.anand.domain.repository

import com.anand.domain.model.Fixture
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {
    fun getFixtures(): Flow<List<Fixture>>
}
