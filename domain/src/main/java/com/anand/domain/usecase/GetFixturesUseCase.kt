package com.anand.domain.usecase


import com.anand.domain.model.Fixture
import com.anand.domain.repository.FixtureRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFixturesUseCase @Inject constructor(
    private val fixtureRepository: FixtureRepository
) {
    fun execute(): Flow<List<Fixture>> {
        return fixtureRepository.getFixtures()
    }
}
