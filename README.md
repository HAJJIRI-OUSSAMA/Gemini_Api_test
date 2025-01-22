
# Gemini API Test

This project demonstrates a backend service for managing and processing documents using Spring Boot. It includes APIs for document retrieval, embedding generation, and question-answering based on documents.

---

## Table of Contents
- [Directory Structure](#directory-structure)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

---

## Directory Structure
```plaintext
hajjiri-oussama-gemini_api_test/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── oussama/
│   │   │           └── backend/
│   │   │               ├── BackendApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── DocumentController.java
│   │   │               │   └── RagController.java
│   │   │               ├── models/
│   │   │               │   ├── DocumentModel.java
│   │   │               │   └── ScoredDocument.java
│   │   │               ├── repositories/
│   │   │               │   └── DocumentRepository.java
│   │   │               └── service/
│   │   │                   ├── DocumentService.java
│   │   │                   ├── EmbeddingService.java
│   │   │                   ├── GeminiService.java
│   │   │                   ├── PDFProcessingService.java
│   │   │                   └── RagService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── org/
│               └── oussama/
│                   └── backend/
│                       └── BackendApplicationTests.java
└── .mvn/
    └── wrapper/
        └── maven-wrapper.properties
```

---

## Features
- **Document Management**: Create, retrieve, and process documents.
- **Embedding Generation**: Generate embeddings for documents using Gemini Service.
- **PDF Processing**: Handle and process PDFs for further use.
- **Question Answering (RAG)**: Implement retrieval-augmented generation to answer questions based on document content.

---

## Prerequisites
Ensure you have the following installed:
- Java 17 or higher
- Maven 3.8 or higher
- Git

---

## Setup and Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/hajjiri-oussama/gemini_api_test.git
   cd hajjiri-oussama-gemini_api_test
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Configure the application by editing `src/main/resources/application.properties` to match your environment.

---

## Running the Application
1. Start the application:
   ```bash
   ./mvnw spring-boot:run
   ```

2. Access the APIs at:
   - Base URL: `http://localhost:8080`
   - Swagger UI (if configured): `http://localhost:8080/swagger-ui.html`

---

## Testing
Run the test suite using:
```bash
./mvnw test
```

---

## Contributing
1. Fork the repository.
2. Create a new branch for your feature or bugfix:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push to your fork:
   ```bash
   git push origin feature-name
   ```
4. Create a pull request.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
