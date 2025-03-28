# Test Automation Demo Project

## 1. Project Description
This is a **demo test automation project** created using **Selenide** and **Java**. The purpose of this project is to showcase an example of setting up and running automated UI tests for a web application. The project follows the **Page Object Model** design pattern and utilizes **Cucumber** for defining test scenarios.

---

## 2. Environment
The following environment was used to create and test this project:
- **Java**: Java SDK 21
- **Gradle**: Gradle 8.3

---

## 3. Frameworks and Libraries
This project utilizes the following frameworks and libraries:
- **Selenide**: UI testing framework for browser automation  
  Version: `6.12.3`
- **JUnit**: Unit testing framework utilized for assertions  
  Version: `5.10.0`
- **Cucumber**: BDD framework for defining feature files and step definitions  
  Version: `7.14.0`

---

## 4. How to Use
To clone and use this project locally, you can use `git clone` with the following command:

```bash
git clone https://github.com/AlinaLipaka/TA-Demo-Project.git
```

---

## 5. Run Tests

You can execute the test cases in multiple ways:

### a) Using Gradle:
Run the following command in your terminal to execute all tests using Gradle:
```bash
./gradlew clean test
```

To run with specific tags using Gradle:
```bash
./gradlew clean test -Dcucumber.filter.tags="@tagName"
```

### b) Using Cucumber Runner:
Run tests by executing the `CucumberRunner` class in **IntelliJ IDEA**. Ensure that the correct `main` or test configuration is selected in your IDE.

### c) Using Feature File:
You can also run specific scenarios or feature files directly in IntelliJ IDEA:
1. Open the desired `.feature` file located in `src/test/resources/features`.
2. Right-click on the file and select **Run Feature**.

---
