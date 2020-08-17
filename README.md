# Objective

The main objective of this application is to calculate the net payable amount for a bill amount given, based on the type of customer and the products he/she purchases.

# Technology requisites

Application utilizes the below tech stack.
	- Java 1.8
	- Maven 3.6.3
	- Junit 4
	- Jacoco plugin 0.8.5
	
# Execution

Clone the application from GitHub and navigate to the root path and execute below command to build a distributable jar

	mvn clean install 
	
For executing the tests and code coverage, execute below command,

	mvn clean test
	
Code coverage results in html format can be found under the path,

	<Root>/target/jacoco-report/index.html
	
# Assumptions

1. When discounts are applicable, the percentage discount will be applied first on total bill, then the discount based on amount is applied and net payable is calculated.
2. Snapshot of the test code coverage and UML diagram is provided under the Root path for your reference.