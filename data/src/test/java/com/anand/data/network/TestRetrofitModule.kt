package com.anand.data.network

import com.anand.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestRetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        // Mock the Retrofit instance
        return mock(Retrofit::class.java)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        // Mock the ApiService instance
        return mock(ApiService::class.java)
    }
}

class RetrofitModuleTest {

    @Test
    fun testProvideRetrofit() {
        // Create an instance of the TestRetrofitModule
        val module = TestRetrofitModule

        // Call the provideRetrofit method
        val retrofit = module.provideRetrofit()

        // Assert that the provided Retrofit instance is not null
        assertNotNull(retrofit)
    }

    @Test
    fun testProvideApiService() {
        // Create an instance of the TestRetrofitModule
        val module = TestRetrofitModule

        // Call the provideApiService method
        val apiService = module.provideApiService(mock(Retrofit::class.java))

        // Assert that the provided ApiService instance is not null
        assertNotNull(apiService)
    }
}
