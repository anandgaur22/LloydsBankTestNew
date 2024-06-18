
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
The Application class is the base class for maintaining global application state. It is instantiated
before any other class when the process for your application is created.

- **di/**
    - `AppModule.kt`: Defines application-level dependencies for Dagger Hilt.

- **ui/**
    - `MainActivity.kt`: The main activity that sets up the initial UI using Jetpack Compose.

- **MainApplication.kt**: The application class that initializes Dagger Hilt.

### core Module
The Core Layer contains common utilities, constants, and base classes that can be shared across different modules of the application. 
This layer should not depend on any other layer and should have minimal dependencies to avoid introducing tight coupling

- **utils/**
  - `Constants.kt`: Contains application-wide constants such as the API base URL and API key.

### domain Module
The Domain Layer contains the business logic of the application. It is the core of the application 
where all the important data and operations are defined. It is independent of any external frameworks or libraries.

- **model/**
    - `Fixture.kt`: The domain model representing a fixture.

- **repository/**
    - `FixtureRepository.kt`: The repository interface defining methods for fetching fixtures.

### data Module
The Data Layer handles data management and is responsible for accessing and providing data to the domain layer.
It can interact with various data sources such as databases, network APIs, or local storage.

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
The Presentation Layer is responsible for displaying data to the user and handling user interactions. 
It uses ViewModels to manage UI-related data in a lifecycle-conscious way, and Composables or XML to define the UI components.

- **ui/**
    - `FixtureViewModel.kt`: ViewModel for managing UI-related data for the fixture screen.
    - `FixtureScreen.kt`: Composable function that renders the UI for the fixtures screen.



## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



