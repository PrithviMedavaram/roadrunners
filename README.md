# Road Runners

Road Runners is a Java-based Spring Boot command-line application that calculates estimated delivery times (ETA) for packages using available delivery vehicles.

# Prerequisites

Make sure you have the following installed:

- Java 17 or higher  
- Maven

# How to Run
1. Clone the repository:
   ```
   git clone git@github.com:PrithviMedavaram/roadrunners.git
   git checkout master
2. Navigate to the project directory:
   ```
   cd roadrunners
3. Build the project using Maven:
   ```
    mvn clean install
4. Run the application:
   ```
   mvn spring-boot:run

# Test Input
Enter number of packages: 1

Enter package details:
Package ID: PKG1
Weight (kg): 30
Distance (km): 170
Offer Code: OFR001

# Test Output
Estimated Delivery Times:
PKG1 -> 2.43 hours
