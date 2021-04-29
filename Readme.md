<img src="./readmeResources/icon.png" align="right" />

# Documentation of the Project  [![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome#readme)
> A very simple web based note taker app.


<br />
<p align="center">
    <img src="./readmeResources/todo-logo.png" alt="Logo" width="150" height="150">
  </p>

  <h3 align="center">NoteTaker App</h3>



  <!-- TABLE OF CONTENTS -->
  <details open="open">
    <summary>Table of Contents</summary>
    <ol>
      <li>
        <a href="#about-the-project">About The Project</a>
      </li>
      <li><a href="#built-with">Built With</a></li>
      <li><a href="#getting-started">Getting started</a></li>
    </ol>
  </details>


## About the Project

We are gonna make a basic web based ToDo app that will perform basic CRUD operation. We are gonna use hibernate to handle the database and as database we will be using MYSQL. We will also use MVC design-pattern.

## Built With

The project will be built with:

1. Hibernate
2. MYSQL
3. Java Spring
4. Servelet
5. JSP etc

## Getting started

1. First step is to start a maven project for simplicity of injecting dependencies. For archetype we have selected `maven-archetype-webapp`.
2. Then we update the library.

      * first we update the jdk

        ***Right Click on project -> Build path -> Configure Build path -> Add library -> JRE System Library -> next-> Default workstation Library (JDK - 15) -> finish***

        <p align="center">
            <img src="./readmeResources/build-path-configure.png" alt="build-path-configure" width="400" >
              <img src="./readmeResources/add-jdk-library.png" alt="add-jdk-library" width="500" >
          </p>
      * Then we remove the old J2SE-1.5 (default JRE system library)
        Similarly now we add tomcat server to our project.

        ***Right Click on project -> Build path -> Configure Build path -> Add library -> Server Runtime -> next-> Tomcat -> finish***

        But since we did not have tomcat server downloaded we had to download it first and then add it. The installation of tomcat and adding it to eclipse guide can be found [here]( https://www.eclipse.org/webtools/jst/components/ws/1.0/tutorials/InstallTomcat/InstallTomcat.html#:~:text=Start%20the%20Eclipse%20WTP%20workbench,under%20Apache%20(Apache%20Tomcat%20v5. )

        Now we check if our project is working. To do that, we ***right click project -> run as -> run on server -> apahe tomcat -> finish***

        <p align="center">
            <img src="./readmeResources/run-as-run-on-server.png" alt="run-as-run-on-server" width="400" >
              <img src="./readmeResources/select-apache-tomcat.png" alt="select-apache-tomcat" width="400" >
          </p>

        And we see a successful hello world message, which should tell us that our app is good to go.  
        <p align="center">
        <img src="./readmeResources/hello-world-success.png" alt="select-apache-tomcat" height="400" >
        </p>




## Adding Bootstrap

Now we add some bootstrap to our project. We copy & paste the html code from _getting started -> starter template_ from [getbootstrap.com]( https://getbootstrap.com ) to our index.jsp file.

<p align="center">
<img src="./readmeResources/index-jsp-directory.png" alt="index-jsp-directory" height="300" >
</p>

Now we can see our hello world is much more beautiful now.

## Configuring Project

First we need to follow the five step to configure spring MVC project. In this project we will use xml file but we can do it by java coding too.

* ***Add Dependency:*** First we add the maven dependency in our pom.xml file. For this project, we are using 4.3.13 version of the spring MVC.
We can see the jar files added by maven automatically.

<p align="center">
        <img src="./readmeResources/dependency-jars-spring-mvc.png" alt="Dependency jar Files added" height="400" >
</p>

1. ***Specifying Front Controller:*** We need to specify our front controller (Dispatcher Servlet).We first locate the web.xml file.

```bash
├───src
│   ├───main
│   │   ├───java
│   │   ├───resources
│   │   └───webapp
│   │       └───WEB-INF
                └───web.xml
```

We copy-paste the following snippet into it between `<web-app>` tag.

```xml
<servlet>
        <servlet-name>todo</servlet-name>
                <!-- the name of our project-->
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                <!-- Specifying our dispatcher servlet (our front controller)-->
        <load-on-startup>1</load-on-startup>
                  <!-- Don't know what this does -->
</servlet>

<servlet-mapping>
        <servlet-name>todo</servlet-name>
            <!-- the name to our project name-->
        <url-pattern>/todo/*</url-pattern>
            <!-- all the url after with todo prefix will be handled by our front controller-->
            <!--  <url-pattern>/</url-pattern> would mean dispatcher servlet will handle all url-->
</servlet-mapping>
```

2. ***Create and configure servlet xml file:*** We create a `todo-servelet.xml` file in the same directory of `web.xml` file. The `todo` comes from the `<servlet-name>todo</servlet-name>` portion of our `web.xml` file.

Then we paste the following snippet into it.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <mvc:annotation-driven />

</beans>
```

This will enable us to use `@Controller` annotation.

3. ***Create a controller:*** Now we create a controller class name `HomeCtrl` in `com.ctrl` package in the `src\main\java` directory. We add `@Controller` annotation above the class to specify it as a controller. We add a method `home` and add annotation `@RequestMapping("\home")` to specify that when `\home` url is hit this method will handle the request(`GET` request by default) and this method return a string "home" which indicate the name of the view that will be displayed.



4. ***Add a component scanner:*** We need to tell spring to scan `com.ctrl` package to get the controllers. So we add the following snippet in the `todo-servlet.xml` file.

```xml
... ... ...

<context:component-scan base-package="com.ctrl"/>
<mvc:annotation-driven />
```

the we copy the last two lines of the schemaLocation tag and paste it and edit the mvc part to context and also xmlns:mvc tag is copy pasted and edited accordingly.

```xml
... ... ...

  xmlns:mvc="http://www.springframework.org/schema/mvc"
  <!--copy and pasted and edite -->
  xmlns:context="http://www.springframework.org/schema/context"

.... ....

xsi:schemaLocation="
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd

    <!-- copy and edited -->
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd

    ">


<context:component-scan base-package="com.ctrl"/>
<mvc:annotation-driven />
```

5. ***Add a view resolver:*** Now we need to add a view resolver so that spring knows where to look for the views.

So we add the following snippet.

```xml
<context:component-scan base-package="com.ctrl"/>

	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
					<!-- the class name can be found by pressing ctrl+shift+t inside a java class in eclipse and typing internares -->
					<!-- the class name can also be found from interet -->

						<!-- the properties come from inside the viewResolver class -->
					<property name="prefix" value="/WEB-INF/pages/"/>
						<!-- Spring will look for the page in the /WEB-INF/Pages/ directory -->
					<property name="suffix" value=".jsp"/>
						<!-- The webpages will end with .jsp extension -->
	</bean>

    <mvc:annotation-driven />
```

So we create our `home.jsp` file (returned in our home mehtod of the HomeCtrl)
in the `/WEB-INF/Pages` directory.

So we create a `home.jsp` file in the same directory as `index.jsp` file.

```bash
├───src
│   ├───main
│   │   ├───java
│   │   ├───resources
│   │   └───webapp
│   │       └───...
            └───Pages
                └───home.jsp
            └───index.jsp

```

So that should do it. If we run the project we will first see the index page. And if we go to `/home` url we will see the home page which was configured using spring mvc.

***NOTE:*** We faced some hickups due to the bug of eclipse reversing back to java old version. After reconfiguring with the latest java the error was gone.
