
# Fitness Monolith

A Spring Boot application for fitness tracking and management.

## Description

This is a monolithic fitness application built with Spring Boot that provides functionality for tracking user activities, managing user profiles, and generating fitness recommendations.

## Technologies Used

- **Java 25**
- **Spring Boot 4.0.1**
- **Spring Data JPA**
- **Spring Web MVC**
- **MySQL Database**
- **Lombok**
- **Maven**

## Project Structure

```
src/main/java/com/project/fitness/
├── FitnessMonolithApplication.java  # Main Spring Boot application
└── model/
    ├── User.java                    # User entity model
    ├── Activity.java                # Activity entity model
    └── Recommendation.java          # Recommendation entity model
```

## Prerequisites

- Java 25 or higher
- Maven 3.6+
- MySQL Database

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/mohammadsameer1999/fitness-monolith.git
   cd fitness-monolith
   ```

2. **Configure Database**
   - Create a MySQL database for the application
   - Update database configuration in `src/main/resources/application.properties` or `application.yml`

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   Or run the JAR file:
   ```bash
   java -jar target/fitness-monolith-0.0.1-SNAPSHOT.jar
   ```

## Features

- User management and profiles
- Activity tracking and logging
- Fitness recommendations system
- RESTful API endpoints
- Database persistence with JPA

## API Endpoints

The application provides RESTful APIs for:
- User management
- Activity tracking
- Recommendations

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

Mohammad Sameer