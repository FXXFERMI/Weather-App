# WeatherApp README

## Summary
WeatherApp is a Java application that displays current weather information,
generates weather-based reminders, and allows users to create and manage daily to-do lists.
It is built with a focus on clean architecture and SOLID principles, providing an extensible and maintainable codebase.

# WeatherApp README

WeatherApp is a Java desktop application that displays weather information, generates reminders based on
weather conditions, and manages a to-do list. It provides a user-friendly interface for users to stay informed
about the weather and organize their daily tasks.

## Use Cases

1. Display Weather: Users can view the current weather temperature and conditions.
2. Generate Reminders: Based on weather conditions, users receive reminders to take appropriate actions.
3. Create Daily Schedule: Users can create a to-do list for their daily tasks and save it.

## User Story

As a user, I want to easily check the weather and receive relevant reminders based on the weather conditions.
I also want to create and manage my daily schedule efficiently.

## Design Patterns

WeatherApp incorporates the following design patterns:

- **Decorator Pattern:** Used to add logging functionality to the weather use case.
- **Strategy Pattern:** Implemented to dynamically generate reminders based on different weather conditions.
- **Dependency Inversion Principle:** Applied to decouple high-level modules from low-level modules,
promoting flexibility and testability.
- **Clean Architecture:** Organizes the codebase into layers for clear separation of concerns.

## Java Version and Testing Framework

- Java version: Java 8 or later
- Testing framework: JUnit

## Code Smells and SOLID Principles

The code has been structured and refactored to minimize code smells and adhere to SOLID principles.
However, some areas were identified for improvement, such as:
- Duplicated code between main.java and WeatherApp (Refactored in later versions).
- Tight coupling between Interactor and Data Provider (Addressed using Dependency Inversion Principle).
- Incomplete application of Dependency Inversion Principle in some parts of the code (Improved in later versions).

## JSON Library

The project utilizes a JSON library for handling JSON data. Make sure to include the necessary
JSON jar in your classpath.

---
I calculated the number of code manually, there are totally 994 lines(less than 1000) inside main and test package.
For detailed implementation and code discussions, refer to the conversation log.

