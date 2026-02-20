# 🛴 Scooter API Automation Framework

![Java](https://img.shields.io/badge/Java-11-orange?logo=java)
![JUnit](https://img.shields.io/badge/JUnit-4.13.2-brightgreen)
![RestAssured](https://img.shields.io/badge/RestAssured-4.4.0-blue)
![Allure](https://img.shields.io/badge/Allure-2.24.0-purple?logo=allure)
![Maven](https://img.shields.io/badge/Maven-Build-red?logo=apachemaven)
![API Testing](https://img.shields.io/badge/API-Automation-success)

---

## 📌 Project Overview

Automation framework for testing the API of the educational service  
**Yandex Scooter**.

The project demonstrates:

- Clean test architecture
- Separation of test logic and API clients
- Parameterized tests
- Test data generation
- Negative scenario validation
- Allure reporting integration

---

## 🎯 Test Coverage

### 🚚 Courier API

#### `POST /courier`
✔ Successful courier creation  
✔ Duplicate courier validation (409 Conflict)  
✔ Required fields validation  
✔ Error when login is missing  
✔ Error when password is missing

#### `POST /courier/login`
✔ Successful authorization  
✔ Response returns `id`  
✔ Wrong login  
✔ Wrong password  
✔ Missing required fields  
✔ Non-existing user

---

### 🛴 Orders API

#### `POST /orders`
Parameterized testing of color field:

- BLACK
- GREY
- BLACK + GREY
- No color

✔ Response contains `track`

#### `GET /orders`
✔ Response body contains list of `orders`

---

## 🏗 Architecture

The project follows a layered structure:

```
src
├── main
│   ├── base          → Base configuration (RequestSpecification)
│   ├── client        → API Clients (CourierClient, OrderClient)
│   └── model         → POJOs + Test Data Generator
│
└── test
    ├── courier       → Courier tests
    └── order         → Order tests
```

---

## 🔹 Design Decisions

- API interaction logic separated from tests
- Reusable `RequestSpecification`
- POJO-based request bodies
- Random test data via Faker
- Cleanup via `@After`
- Parameterized JUnit tests
- Allure `@Step` annotations

---

## 🧪 Tech Stack

| Tool | Purpose |
|------|----------|
| Java 11 | Core language |
| JUnit 4 | Test framework |
| Rest Assured | HTTP client for API testing |
| Allure | Reporting |
| Lombok | Boilerplate reduction |
| Java Faker | Random test data |
| Maven | Build & dependency management |

---

## ▶ How to Run Tests

Run all tests:

```
mvn clean test
```

---

## 📊 Allure Report

Generate interactive
```
mvn allure:serve
```

The report includes:

- Detailed steps
- Request/response logs
- Test execution timeline
- Failure analysis

---

## ⚠ Handling Unstable API Behavior

The test environment may return `504 Gateway Timeout`  
for some negative scenarios.

To avoid false negatives:

```
Assume.assumeTrue(response.statusCode() != 504);
```

This ensures infrastructure issues do not break the test suite.

---

## 📈 What This Project Demonstrates

- Understanding of REST API testing
- Knowledge of HTTP status codes
- Negative and edge case validation
- Clean code principles
- Maintainable test architecture
- Practical experience with reporting tools

---

## 👨‍💻 Author

Nikita Makoveev  