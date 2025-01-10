# Wikipedia_Mini_Project

This is a mini project that automates the user interface (UI) of Wikipedia. It contains a single test case designed to ensure the functionality of the Wikipedia UI. The project makes use of **data-driven testing** to execute multiple test scenarios with varying input data. Additionally, **BrowserStack** is employed to perform **cross-browser testing** to ensure compatibility across different browsers. Docker and Jenkins  are used for containerization and Continuous Integration (CI).

## Features

- **UI Automation**: Automates interactions with Wikipedia’s UI to perform actions like searching, navigating through menus, and downloading content, validating the expected behavior at each step.
- **Page Object Model (POM) Design**: Implements the Page Object Model (POM) design pattern to separate UI interactions from test logic, improving maintainability and reusability of test scripts.
- **Data-Driven Testing**: Utilizes different input data sets to test the same functionality in various scenarios.
- **Cross-Browser Testing**: Tests the Wikipedia UI on multiple browsers using BrowserStack, ensuring cross-browser compatibility.
- **Containerization**: The project is containerized using Docker to provide a consistent development environment.
- **Continuous Integration (CI)**: Automated testing is integrated into Jenkins for continuous testing.


## Test Steps:
#### Test Case Name: **Wikipedia UI Test**
1. **Visit Wikipedia URL**:
    - Navigate to [https://www.wikipedia.org](https://www.wikipedia.org).
    - Ensure that the main page loads successfully.

2. **Input Search Term and Click Search**:
    - In the search box, input "input string".
    - Click the "Search" button.

3. **Click Tools Menu**:
    - In the sidebar, locate and click the "Tools" menu.

4. **Click Download as PDF Option**:
    - From the dropdown menu, click "Download as PDF".

5. **Download PDF File**:
    - Click the "Download" button.
    - Verify that the file downloaded contains the same name as the article or page that was previously displayed.

## Libraries and Technologies Used

- **Selenium WebDriver**: For automating browser actions and UI interactions.
- **Aquality Automation Framework**: For creating and managing the UI automation tests in a structured manner, providing support for Selenium WebDriver and integrations with other tools.
- **Maven**: For managing project dependencies, building the project, and handling the test execution lifecycle.
- **TestNG**: For organizing tests, providing annotations, and structuring the test suite.
- **Data-Driven Testing**: Implemented using TestNG’s data providers to execute the same tests with different sets of data.
- **Gson**: For serializing Java objects into JSON format and deserializing JSON responses, useful for data handling in tests.
- **Lombok**: For reducing boilerplate code, such as getters, setters, and constructors, mainly in model classes.
- **Allure**: For generating detailed and interactive test reports to track test results and logs.
- **BrowserStack**: To run tests across different browsers and devices in the cloud, ensuring cross-browser compatibility.
- **Docker**: For containerizing the project, ensuring consistent environments across different machines, and simplifying test execution.
- **Jenkins**: For setting up Continuous Integration (CI) pipelines that automatically trigger test execution on code changes.


## Project Setup

### Prerequisites

1. **Java**: Ensure that Java is installed on your system.
2. **Maven**: For managing project dependencies.
3. **BrowserStack Account**: A BrowserStack account to access cross-browser testing.
4. **Docker**: Install Docker to containerize the project and run tests in a controlled environment.
5. **Jenkins**: A Jenkins server to trigger automated test runs.
6. **IDE (Optional)**: An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse for development.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/Wikipedia_Mini_Project.git
    cd Wikipedia_Mini_Project
    ```

2. Open the project in your preferred IDE.

3. Install project dependencies by running:

    ```bash
    mvn install
    ```

4. Configure BrowserStack credentials in your test code (BrowserStack username and access key).


### Running the Tests Locally

1. Clean the projects using Maven:

    ```bash
    mvn clean
    ```

2. Run the test using Maven:

    ```bash
    mvn test -DbrowserstackUsername="Your browserstack username " -DbrowserstackAccessKey=" Your browserstack accessKey"
   ```

### Generating the Allure Report

1. Navigate to the `target` directory:

    ```bash
    cd target
    ```

2. Serve the Allure report:

    ```bash
    allure serve 
    ```

### Running Tests in Docker

1. Build the Docker image with the following command:

    ```bash
    docker build -t wikipedia-mini-project .
    ```

2. Run the container in interactive mode, mapping port 9090 (or another port of your choice):

    ```bash
    docker run -it -p 9090:9090 wikipedia-mini-project bash
    ```

3. This above command will open a Bash shell inside the Docker container. Once inside the container, clean the project using Maven:

    ```bash
    mvn clean
    ```

   Run the tests with the necessary BrowserStack credentials:

    ```bash
    mvn test -DbrowserstackUsername="Your browserstack username" -DbrowserstackAccessKey="Your browserstack accessKey"
    ```

4. After the tests have completed, navigate to the `target` directory:

    ```bash
    cd target
    ```
   Then, serve the Allure report:

    ```bash
    allure serve --port 9090
    ```


5. Open `http://localhost:9090` in your web browser to view the Allure report.

## Conclusion

This project demonstrates the automation of Wikipedia's user interface with cross-browser testing, data-driven testing, and continuous integration using tools like Selenium, BrowserStack, Docker, and Jenkins. The setup ensures consistent testing across different browsers and provides detailed insights into test execution through Allure reports, promoting a robust and scalable automation framework.

   