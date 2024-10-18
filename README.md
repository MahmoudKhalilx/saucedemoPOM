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

