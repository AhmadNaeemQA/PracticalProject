# PracticalProject
coverage: 80.05%

Utility tool allowing users to creeate and log into account to add tasks to their daily to do list and keep track of incomplete tasks with all data hosted on GCP.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
JDK - to develop java code. To download JDK: https://www.oracle.com/uk/java/technologies/javase-downloads.html
JRE - run time environment for java program. Comes with JDK on link above
Maven - to manage all the dependencies. To get maven: https://maven.apache.org/download.cgi
Spring Tool - framework to run server and handle requests.
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Clone the folder from git hub using this link: https://github.com/AhmadNaeemQA/PracticalProject.git
go into projectJava/SpringBoot and open that folder in your spring tool suit.
Go into src/main/resources/application.properties and change line 3 to match the IP address of the server: spring.datasource.url=jdbc:mysql://[IP address]:3306/toDoApp?serverTimezone=UTC
Change MYSQL_URL = "34.105.231.76:3306"; to the ip address of the database and port number
Open src/main/java/com.example.demo/application.java
Run as Spring Boot application
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests


### Unit Tests 


```
Junit tests tests the resulting values from methods against whats expected. It also gives coverage percentage of code that is being tested.
To run the junit tests:
1) Right click on src/test/jave/com.example and click coverage as Junit 4 test.
```

### Integration Tests 


```
Integration test uses Selenium and cuke to run automated test on application front end.
To run the integration tests:
1) Right click on src/test/jave/cukeTest and click run as Junit 4
```

```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

* [Git] (http://github.com) for versioning.

## Authors

* **Ahmadzeya Naeem* - (https://github.com/AhmadNaeemQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 


## Acknowledgments

* Thanks to the trainers at QA who tought me all the knowledge I needed to go away and crete this application from scratch.

