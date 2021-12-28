# Aly automated testing
project using TestNG framework using java and selenium, for the automation of tests on Aly's website, which runs on Google Chrome.

## Requirements

- It is recommended to have the latest JDK version installed
- Java environment variables setting correctly
- Maven should be installed
- Intellij recommended as a default IDE

## Running the tests

If the IDE to be used is Intellij, a specific test class can be executed by pressing the "Ejecutar" button in the menu. We need to take in account that the corresponding values of credentials and OTP must be entered, before run the test. It is also possible to run the tests by means of the command
      "mvn -Dtest=NameClasstest"
But because the login has not been automated yet, the corresponding credentials and OTP must be entered before running the test, which have not added the parameters to be passed to run it through the command line
