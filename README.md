# WeatherApp README

## Code Numbers
I calculated the number of code manually, there are totally 994 lines(less than 1000) inside main and test package.


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

## JSON Library AND JUnit Library

The project utilizes a JSON library for handling JSON data. Make sure to include the necessary
JSON jar in your classpath.I attached JSON jar in MarkUs Submittion, you can either download it from the MarkUs Submittion or through this link:https://mvnrepository.com/artifact/org.json/json/20140107
add it through Intellj IDEA->File->Project Structure->Modules->Dependencies->click"+", apply the JSON jar.

The project also utilizes a JUnit library for handling Test data. Make sure to include the necessary
JUnit jar in your classpath.
Right-click your project and choose "Open Module Settings" or hit F4. 
(Alternatively, File > Project Structure, Ctrl-Alt-Shift-S is probably the "right" way to do this)
Go to the "Libraries" group, click the little green plus (look up), and choose "From Maven...".
Search for "junit" -- you're looking for something like "junit:junit:4.11".
Check whichever boxes you want (Sources, JavaDocs) then hit OK.
Keep hitting OK until you're back to the code.

If this still not working, to download the jar from: https://jar-download.com/artifacts/org.junit.jupiter/junit-jupiter-api
(Download version5.8.1)And add the jar through Intellj IDEA->File->Project Structure->Modules->Dependencies->click"+", 
apply the junit.jar, junit-jupiter-api-5.8.1.jar,junit-platform-commons-1.8.1.jar.


---
For detailed implementation and code discussions, refer to the conversation log.

