# 🚀 Trello API Automation Framework

This project is a **test automation framework** for interacting with the **Trello API**. It is built using **Java**, **Rest-Assured**, **TestNG**, and **Log4j2**. The framework follows the **Page Object Model (POM)** design pattern to ensure modularity, reusability, and maintainability.

---

## ✨ Features

- 🛠️ **Board Management**: Create, retrieve, update, and delete Trello boards.
- 🗂️ **Card Management**: Create, retrieve, update, and delete Trello cards.
- 🔄 **Workflow Automation**: Automates end-to-end scenarios such as creating boards, adding cards, updating cards, and cleaning up resources.
- 📜 **Logging**: Integrated with **Log4j2** for detailed logging of test execution.
- ✅ **Assertions**: Uses **TestNG** for validating API responses.

---

## 📂 Project Structure

```
src
├── main
│   └── resources
│       └── log4j2.xml          # Log4j2 configuration file
├── test
│   ├── java
│   │   ├── com.trelloapi.base
│   │   │   └── BaseTest.java   # Base class for common setup
│   │   ├── com.trelloapi.endpoints
│   │   │   └── TrelloEndpoints.java # Centralized API endpoint definitions
│   │   ├── com.trelloapi.pages
│   │   │   ├── BoardPage.java  # Page class for board-related operations
│   │   │   └── CardPage.java   # Page class for card-related operations
│   │   └── com.trelloapi.tests
│   │       └── TrelloWorkflowTest.java # Test class for end-to-end workflow
│   └── resources
│       └── (empty or additional test resources)
```

---

## 🛠️ Prerequisites

- **Java 17**: Ensure Java 17 is installed and configured.
- **Maven**: Install Maven for dependency management.
- **Trello API Key and Token**: Obtain your API key and token from the [Trello Developer Portal](https://developer.atlassian.com/cloud/trello/guides/rest-api/api-introduction/).

---

## ⚙️ Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd trello-api-automation
---

## 📋 Logging

The project uses **Log4j2** for logging. Logs are written to both the **console** and a **file** (`logs/app.log`). The logging configuration can be modified in `src/main/resources/log4j2.xml`.

---

## 🗝️ Key Classes

### 🔧 `BaseTest.java`
- Sets up the base URI for **Rest-Assured**.
- Contains API key and token for authentication.

### 🌐 `TrelloEndpoints.java`
- Centralized class for managing API endpoint paths.

### 📄 `BoardPage.java` and `CardPage.java`
- Implements methods for interacting with Trello boards and cards.

### 🧪 `TrelloWorkflowTest.java`
- Contains an **end-to-end test scenario**:
    1. Create a board.
    2. Add two cards to the board.
    3. Update one card randomly.
    4. Delete the cards.
    5. Delete the board.

---

## 📦 Dependencies

The project uses the following dependencies:

- **Rest-Assured**: For API testing.
- **TestNG**: For test execution and assertions.
- **Log4j2**: For logging.
- **Jackson**: For JSON parsing.

Dependencies are managed in the `pom.xml` file.

---

## 🧪 Example Test Workflow

The `TrelloWorkflowTest` class automates the following steps:

1. 🛠️ **Create a Trello board**.
2. 🗂️ **Add two cards** to the board.
3. 🔄 **Randomly update one of the cards**.
4. 🗑️ **Delete the created cards**.
5. 🗑️ **Delete the created board**.