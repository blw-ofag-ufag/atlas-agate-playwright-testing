# Playwright E2E Tests (Java)

This repository contains end-to-end UI tests built with **Playwright (Java)** and **JUnit 5**.
The focus is on clean test architecture, maintainability, and accessibility-aware selectors.

---

## Project Structure
``` 
src/test/java
├─ base # Test setup (browser, context, validation)
├─ config # Runtime configuration (BASE_URL, ENV, credentials access)
├─ model # Test data models (e.g. TestUser)
├─ testdata # Concrete test users (Java constants)
├─ pages # Page Objects (UI interactions & assertions)
├─ selectors # Page-specific locator factories that encapsulate UI text and selector logic
├─ workflow # Business flows (e.g. LoginWorkflow)
└─ tests # Test classes (orchestration only)
``` 

---

##  Test Design Principles

- **All assertions live in Page Objects**
- **Business flows (e.g. login) are centralized in workflows**
- **Test data is defined as typed Java objects**


---

##  Test Users

Test users are defined as **Java constants** for type safety and refactoring support.

Example:
```java
TestUser user = TestUsers.STANDARD_USER;
userDataPage.assertPersonalDataSection(user);
userDataPage.assertContactSection(user);
```


## Credentials & Configuration

Credentials are **not stored in the repository**.

They must be provided via:

- **IntelliJ Run Configuration** (Environment Variables)
- or **system environment variables**

### Required variables
```java
LOGIN_EMAIL
LOGIN_PASSWORD
```

Runtime configuration is handled via `TestConfig`:

- `BASE_URL`
- `ENV`

Validation happens centrally in `BaseTest`.

---

## Running Tests

Run a single test:
```bash
mvn -Dtest=VerifyUserData test
```

Run all tests:
```bash
mvn test
```
## Accessibility & Selectors

Selectors are written with an accessibility-first mindset:

- Prefer getByRole and visible text
- Avoid brittle global selectors
- Structured data (e.g. definition lists) is accessed semantically
