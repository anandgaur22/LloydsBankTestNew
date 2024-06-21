package com.anand.data.repository


import com.anand.core.utils.Constants.Companion.API_KEY
import com.anand.data.network.ApiService
import com.anand.data.mapper.toDomain
import com.anand.domain.model.Fixture
import com.anand.domain.repository.FixtureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FixtureRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : FixtureRepository {
    override fun getFixtures(): Flow<List<Fixture>> = flow {
        val response = apiService.getFixtures(API_KEY)
        emit(response.data.map { it.toDomain() })
    }
}
