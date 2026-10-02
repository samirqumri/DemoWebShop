# Demo Web Shop Automation Project

A Java-based Selenium WebDriver testing framework designed to validate both positive and negative workflows on the Demo Web Shop e-commerce platform. This project utilizes the **Page Object Model (POM)** architectural pattern and **TestNG** to ensure modular, readable, and highly maintainable test suites.

## 📁 Core Project Capabilities

### 1. Test Automation Suites (`com.demoshop.tests`)
- **`PositiveFlowTest`**: Fully automates a sequential end-to-end user purchasing lifecycle.
  - Verifies home page availability and triggers user authentication.
  - Searches for products, verifies descriptions, and utilizes dynamic partial CSS selectors (`input[id^='add-to-cart-button']`) to cleanly interact with target elements.
  - Modifies cart quantities, recalculates pricing sub-totals (`"6360"` checks), and handles clean cart removals.
- **`NegativeFlowTest`**: Explicitly handles platform constraints and input edge cases.
  - **TestNG DataProvider Optimization**: Replaced multiple repetitive login methods with a structured `@DataProvider` matrix, testing blank fields, wrong email formats, missing attributes, and bad passwords under one assertion loop.
  - **Dynamic Qty Boundary Testing**: Validates cart reactions when inputting extreme bulk values (`"100000"` quantity updates).
  - **Error Interception**: Validates terms of service warning modals and catches structural formatting failures for coupon application codes.

### 2. Page Objects & Component Sync (`com.demoshop.pages`)
- Separates locator strategies (`By` objects) cleanly away from execution assertions.
- **Viewport Scroll Synchronization**: Implements standardized helper routines (`scrolldown()` and `scrollup()`) using `JavascriptExecutor` to prevent element blocking during fast clicks.

## 🛠️ Tech Stack & Dependencies
- **Language:** Java 17
- **Automation Engine:** Selenium WebDriver 4
- **Testing Runner:** TestNG Framework
- **Build Automation:** Apache Maven
