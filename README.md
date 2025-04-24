# Introduction to Software Development (ISD)

This repo contains source code for the IoTBay case study website solution. The solution uses the following stack:
- JSP, CSS, JS frontend
- Java Jetty server backend
- SQLite database

## Running the project locally

To Run The Project:

In a terminal, run:
`mvn package`

Then, in the same terminal, run the following & leave it open for as long as you are developing:
`mvn jetty:run`

Then, open a web browser & visit: `http://localhost:8080`

To run unit tests: `mvn test`

## Building project to a WAR file

To build the project to a .war file, open a terminal in VsCode and run:

`mvn clean package`

The .war file can be found under `IoTBay-Project/target/IotBay.war`

## Project structure

A Servlet-based web application requires a specific directory structure (e.g., src/main/webapp for web resources like HTML, JSP, and WEB-INF).

```
images/ # Images for README.md (this file)
src/
  main/
    java/       # Java source files (e.g., Servlets) - these will be where our Java classes go, such as controllers and models
    db/  # Files relating to the SQLite database (e.g. table definitions, .db file, default values)
    webapp/     # Web resources (e.g., HTML, JSP, CSS, JS)
      WEB-INF/  # Configuration files (e.g., web.xml)
```

## Using SQLite
SQLite uses a .db file (for this project, src/main/db/iotbay.db) to store data. To view this file, do the following:
1. Install the following two VSCode extensions:
    - [SQLite extension](https://marketplace.visualstudio.com/items/?itemName=alexcvzz.vscode-sqlite)
    - [SQLite Viewer](https://marketplace.visualstudio.com/items/?itemName=qwtel.sqlite-viewer)
2. Click to open the .db file, which should open the following view of the database:
![Alt text](images/sqliteviewer.png?raw=true 'SQLite Viewer')

### Running queries
Queries should be written in a .sql file, and stored in src/main/db. To run a query, do the following:
1. Open a .sql file
2. Press Ctrl + Shift + P to open VSCode's command palette
3. Search for "SQLite: Run Query" and run it

# ***Everything below here is from the template. It can be ignored for now***

## Installing dependencies

Make sure you first install:

- Java JDK (https://www.oracle.com/au/java/technologies/downloads/)
    - Choose the JDK 23
    - For Windows, choose x64 Installer
    - For Mac, choose DMG installer (ARM64 or x64 depending on your laptop)
- Maven (https://maven.apache.org/download.cgi) Select the **Binary zip archive** under **Link**
    - Choose version 3.9.9 (latest)

### Install Maven

#### Mac Users

Macos Users will need to edit their bash_profile file in ~/.bash_profile

Please add the following (Update the path to be wherever you downloaded the maven folder):

```
export M2_HOME="/Users/YOURUSERNAMEHERE/Downloads/apache-maven-3.9.9"
PATH="${M2_HOME}/bin:${PATH}"
export PATH
```

You can confirm maven was succesfully installed by running `mvn` in your terminal.

#### Windows Users

After installing Maven, search for environment variables in windows. This will open a dialogue like so:

![Alt text](images/env.PNG?raw=true 'Environment Variables')

Click the new button under system variables & add one called MAVEN_HOME with a link to the downloaded zip file:

![Alt text](images/systemvar.PNG?raw=true 'Environment Variables')

Find the PATH Variable under user variables & click edit. On the next screen, add a new entry with the value `%MAVEN_HOME%\bin`:

![Alt text](images/uservar.PNG?raw=true 'User Variables')

Close all the menus, reload your terminal window/Visual Studio Code & you can confirm Maven was successfully installed by running `mvn` in your terminal.

## Enable Servlets in a Maven project

### Add the Servlet API dependency

Servlets rely on the Java Servlet API, which is not part of the standard Java SE library. You need to include the Servlet API as a dependency in your Maven project.

```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

### Set up a Servlet container

Servlets run inside a Servlet container (e.g., Apache Tomcat, Jetty). You need to configure your project to work with a Servlet container for deployment and testing. Add the below code in your pom.xml.

```
<plugin>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-maven-plugin</artifactId>
    <version>${jettyVersion}</version>
    <configuration>
        <httpConnector>
            <port>8080</port>
        </httpConnector>
    </configuration>
</plugin>
```

### Write and configure Servlets

Create Servlet classes and configure them according to the workshop materials on Canvas.