# My repo for data-processing labs

It's my first project-repo for data-processing lessons.

## 1 lab

In my first lab, firstly, i've downloaded:
- JDK
- IntelliJ IDEA Community Edition
- Apache Maven
- Apache Tomcat

After that, i made a created new project in IntelliJ IDEA with type "Maven" and named it HelloServletProject.
Maven automatically created new folders and files.

After that i added dependency to work with servlets in pom.xml:

```xml
<dependencies>
   <dependency>
       <groupId>jakarta.servlet</groupId>
       <artifactId>jakarta.servlet-api</artifactId>
       <version>5.0.0</version>
       <scope>provided</scope>
   </dependency>
</dependencies>
```
and also added these line of code, so our compiled project will be "HelloServletProject.war":

```xml
<build>
    <finalName>HelloServletProject</finalName>
</build>
<packaging>war</packaging>
```
, so now my pom.xml looks like this:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <build>
        <finalName>HelloServletProject</finalName>
   </build>


   <groupId>org.example</groupId>
   <artifactId>HelloServlet</artifactId>
   <version>1.0-SNAPSHOT</version>
   <packaging>war</packaging>




   <properties>
       <maven.compiler.source>23</maven.compiler.source>
       <maven.compiler.target>23</maven.compiler.target>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
   </properties>


   <dependencies>
       <dependency>
           <groupId>jakarta.servlet</groupId>
           <artifactId>jakarta.servlet-api</artifactId>
           <version>5.0.0</version>
           <scope>provided</scope>
       </dependency>
   </dependencies>


</project>

```

then i synchronized Maven by clicking on "Reload Maven Project".

After that i tried to load apache tomcat.

To check its work i passed this link:

> http://localhost:8080

Then I made new Java-class in src/main/java/.

I created new package "com.example.servletdemo" and there java-class file "HelloServlet".

simple servlet:

```java
package com.example.servletdemo;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


public class HelloServlet extends HttpServlet {


   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {


       response.setContentType("text/html;charset=UTF-8");
       response.getWriter().write("<h1>Hello from HelloServlet!</h1>");
   }
}
```
then i created web.xml file in directory src/main/webapp/WEB-INF.

web.xml:
```xml
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                            https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
        version="5.0">


   <servlet>
       <servlet-name>helloServlet</servlet-name>
       <servlet-class>com.example.servletdemo.HelloServlet</servlet-class>
   </servlet>


   <servlet-mapping>
       <servlet-name>helloServlet</servlet-name>
       <url-pattern>/hello</url-pattern>
   </servlet-mapping>


</web-app>
```

**interesting to read: https://javarush.com/ua/quests/lectures/ua.questservlets.level11.lecture07**

; after that, i executed this command in terminal to compile the project:

```zsh
mvn clean package
```

Then I had to copy that HelloServletProject.war in target to tomcat's webapps folder.

After reloading tomcat, i passed this link:

> http://localhost:8080/HelloServletProject/hello

so that's it:

![image](https://github.com/user-attachments/assets/2edc0b6e-802c-457c-822a-462d15c9adce)

and that's was lab 1!
