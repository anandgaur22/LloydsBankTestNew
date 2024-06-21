// File: AppComponent.kt
package com.anand.data.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    // Function to provide dependencies to dependent components
    // For example, if other modules or components need access to FixtureRepository
    // they can declare functions here to get those dependencies.
}
