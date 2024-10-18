Here's a `README.md` template for your **saucedemoPOM** project:

```markdown
# saucedemoPOM

This is a Page Object Model (POM) based test automation framework for the **SauceDemo** website, built using Selenium and Java. The framework automates the following test scenarios:

1. **Invalid Login**: Verifies that login fails with incorrect credentials.
2. **Account Locked**: Verifies that the user receives an error message when the account is locked.
3. **Valid Login**: Validates that a user can log in successfully with valid credentials.
4. **Complete Order**: Simulates the entire process of logging in, adding items to the cart, checking out, and completing the order.

## Project Structure

```bash
saucedemoPOM/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pages/        # Page Object classes for each page
│   │   │   └── utils/        # Utility classes for configuration, drivers, etc.
│   ├── test/
│   │   └── java/
│   │       └── tests/        # Test classes for each scenario
├── pom.xml                   # Maven dependencies
├── README.md                 # Project documentation
└── testng.xml                # TestNG configuration file for running tests
```

## Features

- **POM Implementation**: Each webpage (Login, Product, Checkout, etc.) is represented by a separate class that contains elements and methods for interactions.
- **TestNG Integration**: Uses TestNG for test execution and reporting.
- **Parallel Execution**: Tests can be run in parallel to save time.
- **Cross-Browser Support**: Compatible with different browsers (Chrome, Firefox).

## Prerequisites

- Java 8 or higher
- Maven
- TestNG
- ChromeDriver or GeckoDriver (for Firefox)





## Test Scenarios

### 1. Invalid Login
- **Description**: Verifies that the user cannot log in with invalid credentials.
- **Steps**:
  - Navigate to the login page.
  - Enter an invalid username and password.
  - Verify that the error message is displayed.

### 2. Account Locked
- **Description**: Verifies the error message for a locked-out user.
- **Steps**:
  - Navigate to the login page.
  - Enter valid credentials for a locked-out user.
  - Verify that the appropriate error message is displayed.

### 3. Valid Login
- **Description**: Verifies that the user can log in with valid credentials.
- **Steps**:
  - Navigate to the login page.
  - Enter valid username and password.
  - Verify successful login by checking the products page.

### 4. Complete Order
- **Description**: Simulates the full order process after login.
- **Steps**:
  - Log in with valid credentials.
  - Add items to the cart.
  - Proceed to checkout.
  - Complete the order and verify success.
  - Redirect to Products page then Logout

## Reporting

Test results will be available in the `test-outputs/allure-results/` folder after running the tests.






**Clone the repository**
   ```bash
   git clone https://github.com/MahmoudKhalilx/saucedemoPOM.git
   ```
