# LambdaTestFramework

 🧪 Framework Explanation
This project is a Hybrid Test Automation Framework built using Selenium WebDriver, Java, and TestNG. It is designed to be flexible, maintainable, and scalable for various testing needs. Here's a breakdown of the key components and flow:

🔧 Framework Capabilities
    Parallel Test Execution using TestNG’s multithreading.
    Cross-Browser Testing support (e.g., Chrome, Firefox).
    Dual Environment Support:
        Local Execution
        Remote Execution on cloud providers like LambdaTest.
    Page Object Model (POM) structure for separating test logic from UI locators.
    Dynamic Environment Control through a central BaseClass.
    Data-Driven Testing:
        Test data (e.g., login credentials) is read from an Excel file using a custom Excel Utility.
    Advanced Reporting using Extent Reports for clear and detailed test results.
    
🔁 Execution Workflow
    The test execution starts by reading configurations from the config.properties file.
    You define the environment (local or remote), browser, and other parameters in this config file.
    Based on the configuration, the BaseClass initializes the WebDriver and sets up the appropriate environment.
    Test data such as login credentials is fetched from Excel files.
    You then run the desired test suite by executing the appropriate TestNG XML file.
    After execution, detailed test reports are generated using Extent Reports.
