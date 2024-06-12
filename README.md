
## Project Title
Football Fixtures App

## Description
This Android application displays a list of football fixtures using the SportMonks API. The app is built using the MVVM architecture, Jetpack Compose for UI, 
Retrofit for network operations, and Kotlin Coroutines for asynchronous operations. It demonstrates the usage of modern Android development techniques and Kotlin features.


## Dependencies

This project uses the following main dependencies:

- **Dagger Hilt**: For dependency injection.
- **Retrofit**: For network operations.
- **Jetpack Compose**: For building the UI.
- **Kotlin Coroutines**: For managing background tasks.
- **Lifecycle**: For managing UI-related data in a lifecycle-conscious way.
- **JUnit**: For making unit test case


## Features

- MVVM Architecture
- Jetpack Compose UI
- Coroutines for asynchronous operations
- Retrofit for network calls
- Unit tests
- Displays a list of football fixtures.
- Fetches data from the SportMonks API.
- Uses modern Android development practices including MVVM and Jetpack Compose.
- Handles network operations and asynchronous tasks efficiently with Retrofit and Coroutines.

## API

The app fetches data from the SportMonks API:

- Base URL: `https://api.sportmonks

## Project Structure 

### app Module

- **di/**
    - `AppModule.kt`: Defines application-level dependencies for Dagger Hilt.

- **ui/**
    - `MainActivity.kt`: The main activity that sets up the initial UI using Jetpack Compose.

- **MainApplication.kt**: The application class that initializes Dagger Hilt.

### domain Module

- **model/**
    - `Fixture.kt`: The domain model representing a fixture.

- **repository/**
    - `FixtureRepository.kt`: The repository interface defining methods for fetching fixtures.

### data Module

- **network/**
    - `ApiService.kt`: Retrofit interface for network calls.
    - `ApiResponse.kt`: A generic class for wrapping API responses.
    - `RetrofitModule.kt`: Provides Retrofit-related dependencies for Dagger Hilt.

- **repository/**
    - `FixtureRepositoryImpl.kt`: Implementation of the `FixtureRepository` interface. It fetches data from the network and maps it to the domain model.

- **mapper/**
    - `FixtureMapper.kt`: Converts network DTOs to domain models.

- **model/**
    - `FixtureDto.kt`: Data Transfer Object (DTO) representing the network response for a fixture.

### presentation Module

- **ui/**
    - `FixtureViewModel.kt`: ViewModel for managing UI-related data for the fixture screen.
    - `FixtureScreen.kt`: Composable function that renders the UI for the fixtures screen.



## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



