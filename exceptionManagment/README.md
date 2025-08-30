# Exception Management - Spring Boot Project

A Spring Boot application designed for centralized exception handling and management in Java applications.

## 🚀 Features

- **Global Exception Handling**: Centralized exception management framework
- **Java 21 Support**: Built with modern Java features
- **Lombok Integration**: Reduced boilerplate code with proper Java 21 compatibility
- **Spring Boot 3.3.5**: Latest stable version with enhanced performance
- **Maven Build**: Easy project management and dependency handling

## 🛠️ Technologies

- **Java 21**: Modern Java with enhanced features
- **Spring Boot 3.3.5**: Latest Spring Boot framework
- **Lombok 1.18.34**: Code generation library with Java 21 compatibility
- **Maven**: Build automation and dependency management

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6+
- IDE with Spring Boot support (IntelliJ IDEA, Eclipse STS, VS Code, etc.)

## 🔧 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/hakanngul/SpringBootProjectsEdu.git
   cd SpringBootProjectsEdu/exceptionManagment
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   Or run the JAR file:
   ```bash
   mvn clean package
   java -jar target/exceptionManagment-1.0-SNAPSHOT.jar
   ```

## 🏃‍♂️ Running the Application

The application will start on port 8080 by default.

- **Application URL**: http://localhost:8080
- **Health Check**: http://localhost:8080/actuator/health (if actuator is enabled)

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/hakangul/
│   │       ├── model/          # Entity classes
│   │       │   ├── Employee.java
│   │       │   └── Department.java
│   │       └── starter/        # Main application class
│   │           └── ExceptionManagmentStarter.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/                   # Test classes
```

## 🔧 Configuration

### Maven Configuration Highlights

- **Java 21 Compatibility**: Properly configured Maven compiler plugin
- **Lombok Integration**: Enhanced annotation processing for Java 21
- **Spring Boot Plugin**: Configured with correct main class

### Key Dependencies

- `spring-boot-starter-web`: Web application support
- `spring-boot-starter-validation`: Validation framework
- `lombok`: Code generation (Java 21 compatible)
- `spring-boot-devtools`: Development tools

## 🐛 Exception Management Features

This project focuses on:

- Global exception handling patterns
- Custom exception types
- Centralized error responses
- Logging and monitoring integration
- Validation error handling

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is part of educational Spring Boot projects collection.

## 📧 Contact

- GitHub: [@hakanngul](https://github.com/hakanngul)
- Repository: [SpringBootProjectsEdu](https://github.com/hakanngul/SpringBootProjectsEdu)

---

**Note**: This project was developed as part of Spring Boot learning series and demonstrates best practices for exception management in enterprise applications.