package com.anand.data.di

import com.anand.data.repository.FixtureRepositoryImpl
import com.anand.domain.repository.FixtureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindFixtureRepository(
        fixtureRepositoryImpl: FixtureRepositoryImpl
    ): FixtureRepository
}
