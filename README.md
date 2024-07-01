# Megaverse Application
#### This project is part of an interview from Try Cactus.

Welcome to the Megaverse application, a Spring Boot application that interacts with the Megaverse API to manage goals and entities in the metaverse.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
    - [Prerequisites](#prerequisites)
    - [Configuration](#configuration)
    - [Building and Running](#building-and-running)
- [Usage](#usage)
- [Contributing](#contributing)
- [Thank You Message to Try Cactus](#Thank-You-Message-to-Try-Cactus)

## Introduction

Megaverse is a Spring Boot application designed to interact with the Megaverse API. It allows users to create, manage, and delete entities such as polyanets, soloons, and comeths in the metaverse environment. The application leverages Spring's capabilities for dependency injection, RESTful web services, and asynchronous processing using Kotlin coroutines.

## Features

- Create, delete, and manage Polyanets, Soloons, and Comeths.
- Retrieve and process goal mappings for candidates.
- Asynchronous processing using Kotlin coroutines for efficient resource management.
- Error handling and logging for improved application reliability.

## Technologies Used

- **Spring Boot:** Web framework for building robust Java/Kotlin applications.
- **Kotlin:** Modern JVM language offering concise syntax and interoperability with Java.
- **Spring Web:** For building RESTful web services.
- **Spring Boot Starter Web Services:** Dependency for integrating with web services.
- **Jackson Module Kotlin:** Serialization/deserialization library for JSON handling.
- **Kotlin Coroutines:** Lightweight concurrency framework for asynchronous programming.
- **JUnit Jupiter & Mockito:** Testing frameworks for unit and integration testing.
- **Gradle:** Build automation tool for managing dependencies and building projects.

## Setup

### Prerequisites

Ensure you have the following installed on your machine:

- Java Development Kit (JDK) 11 or higher
- Kotlin
- Gradle

### Configuration

Ensure you have the following properties configured:

- `candidate.id`: Candidate ID for interacting with the Megaverse API.
- `metaverse.base.url`: Base URL of the Megaverse API.

Example `application.properties`:

## Building and Running

### Clone the repository:

```bash
git clone https://github.com/tonnymuchui/Megaverse.git
cd Megaverse

# Build the project:
./gradlew build

# Run the application:
./gradlew bootRun
```
### Contributing
* Contributions are welcome! Feel free to fork the repository, create pull requests, or open issues for any bugs or feature requests.

## Thank You Message to Try Cactus

Thank you, Try Cactus, for the opportunity to showcase my skills through this project. Your platform provided a challenging and insightful experience, allowing me to demonstrate my capabilities in developing and managing complex applications. I appreciate the chance to participate and look forward to potentially being part of your team.

[Visit Try Cactus](https://www.trycactus.com/) to learn more about their innovation financial technology tools designed for commercial real estate investors.

Sincerely,  
Tonny Muchui
