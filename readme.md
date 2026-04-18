[![CI](https://github.com/mugilravi18/mugil-toys-test/actions/workflows/maven.yml/badge.svg)](https://github.com/mugilravi18/mugil-toys-test/actions)

# UI Test Automation – Jupiter Toys

This project is a UI automation framework built using to validate key user journeys on the Jupiter Toys website.

It demonstrates building a **scalable UI automation framework with Continuous Integration (CI)**.

---

## Application Under Test
http://jupiter.cloud.planittesting.com

---

## Tech Stack
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Page Object Model (POM)  

---

## Framework Design
- Page Object Model (POM) to separate UI logic from test logic  
- `BaseTest` handles WebDriver setup and teardown  
- Supports both local execution and headless execution for CI environments  

---

## Test Coverage
- Contact form validation (error messages & mandatory fields)  
- Successful submission flow  
- Cart functionality (add items and verify cart)  

---

## Project Structure

```
.github/workflows #github actions
src/test/java/com/automation
├── base        # WebDriver setup
├── pages       # Page Object classes
└── tests       # Test classes

jenkins-screenshots/
Jenkinsfile
pom.xml
testng.xml
README.md
```

---

## Running in Local Environment

Run locally:

mvn clean test


Run in headless mode (used in CI):

mvn clean test -Dheadless=true

---

## Continuous Integration

This project demonstrates CI integration using both **GitHub Actions** and **Jenkins**.

### GitHub Actions
- Cloud-based CI pipeline configured via `.github/workflows/maven.yml`
- Automatically runs on:
  - Every push to `main`
  - Every pull request targeting `main`
- Executes tests in headless mode using Maven on a clean runner
- Provides instant feedback via build status and logs

### Jenkins
- Local Jenkins pipeline configured for the same project
- Runs the same Maven command:
- Demonstrates integration with traditional CI/CD tools

### CI Objective
- Ensure tests run automatically on every code change  
- Validate functionality before merging code  
- Maintain consistency across local and CI environments  

---

## CI Flow
```
Developer → Push Code → GitHub → GitHub Actions / Jenkins → Run Tests → Test Results
```

---

## Version Control
- Git is used for source control with a clean repository structure  
- `.gitignore` excludes build artifacts such as:
  - `/target/` (compiled classes and reports)  
  - log files and temporary files  
- Ensures only relevant source code is tracked  
- Keeps the repository lightweight and CI-friendly  

---

## Author
**Mugil Ravi**
