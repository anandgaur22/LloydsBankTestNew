package com.anand.data.repository


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
        val response = apiService.getFixtures("keyEiMaINIuVi3fy3Nz0skrVYS0eVAxfk56Z8YYys56FX6djsd2xqeBzhQd6")
        emit(response.data.map { it.toDomain() })
    }
}
