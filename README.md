# Overall Instructions

In order to build this repository you will need maven installed. 

You can find more information about this here:
https://maven.apache.org/install.html

# Student Application

To build the student application you will run the following command from the `DeskApp` directory: 

`mvn -f stud.xml install`

This will create an executable located at `target/StudentApp.jar`

You can run this executable by clicking on it or running the following command:

`java -jar target/StudentApp.jar`

# Professor Application

To build the professor application you will run the following command from the `DeskApp` directory: 

`mvn -f prof.xml install`

This will create an executable located at `target/ProfessorApp.jar`

You can run this executable by clicking on it or running the following command:

`java -jar target/ProfessorApp.jar`
