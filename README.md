![Cross-Platform Continuous Integration](https://github.com/saurabmish/EagleEye/workflows/Cross-Platform%20Continuous%20Integration/badge.svg)
[![codecov](https://codecov.io/gh/saurabmish/EagleEye/branch/master/graph/badge.svg?token=qBJn7OI9QM)](https://codecov.io/gh/saurabmish/EagleEye)
[![Maintainability](https://api.codeclimate.com/v1/badges/81662c65bf00619a8762/maintainability)](https://codeclimate.com/github/saurabmish/EagleEye/maintainability)

# EagleEye

From "Spring Microservices in Action":

> Eagle- Eye provides an enterprise-grade software asset management application. It provides coverage for all the critical elements: inventory, software delivery, license management, compliance, cost, and resource management. Its primary goal is to enable organizations to gain an accurate point-in-time picture of its software assets.

This is going to be a cloud-native application once complete. 

I'm following "Spring Microservices in Action" for the most part. One thing that's missing in this book is testing. I'm going to be adding unit and integration tests, code coverage, continuous integration, and documentation. 

This is something that I've been doing with all of my projects. I want this project be comprehensive because Java is enterprise-y!

## Execution

At this point this project is an API. It can be tested in the following manner:

+ Verify build environment (Maven):

  `./mvnw clean verify`

+ Install dependencies:

  `./mvnw clean install`

+ Execute the application:

  `./mvnw spring-boot:run`

+ Open a new terminal tab and check API response:

  `curl localhost:8080`

+ Stop the application (executed from the first tab)

+ Run all (unit and integration) tests:
  
  (**NOTE**: This generates coverage (and other) reports in `./target/site/jacoco/`)

  `./mvnw test`

+ View soure code and test coverage on shell (using previously generated report):

  ```
  awk -F, \
      '{ instructions += $4 + $5; covered += $5 } END \
      { print covered, "/", instructions, "instructions covered"; \
      print 100*covered/instructions, "% covered" }' \
      target/site/jacoco/jacoco.csv
  ```