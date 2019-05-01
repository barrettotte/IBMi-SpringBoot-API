# IBMi-SpringBoot-API


A Spring Boot API to easily expose IBMi information as JSON via REST endpoints.


## Dependencies
* Java 8
* JUnit 5.4.2
* Spring Boot 2.1.4
  * Actuator
  * DevTools
  * Security
  * Web
* [JTOpen 9.8](http://jt400.sourceforge.net/)


## Endpoints


## Configuration
```properties
# application.properties

```

## Examples


## Development
* Build ```gradlew build``` or ```dev/gradle-scripts/gradle-build.bat```
* Test ```gradlew test``` or ```dev/gradle-scripts/gradle-test.bat```
* Run ```gradlew bootRun``` or ```dev/gradle-scripts/gradle-run.bat``` at http://127.0.0.1:8080
* Refresh Dependencies ```gradlew build --refresh-dependencies``` or ```dev/gradle-scripts/gradle-refresh.bat```


## Visual Studio Code
* Gradle Tasks ```.vscode/tasks.json```
  * ['gradlew build', 'gradlew test', 'gradlew bootRun']
  * ['gradlew clean build', 'gradlew clean test', 'gradlew dep-refresh']
* HTTP Testing ```dev/test.http```
* Extensions
  * Gradle Language Support - Naco Siren
  * Java Extension Pack - Microsoft
  * REST Client - Huachao Mao
  * Spring Boot Extension Pack - Pivotal
  * Spring Boot Tools - Pivotal


## References
* Encrypt application.properties with [Jasypt](https://www.ricston.com/blog/encrypting-properties-in-spring-boot-with-jasypt-spring-boot/)
* Generated project using [Spring Initializr](https://start.spring.io/)
* [Gradle Docs](https://docs.gradle.org/current/userguide/userguide.html)
* Java and AS400 
  * [IBM Knowledge Center](https://www.ibm.com/support/knowledgecenter/ssw_ibm_i_71/rzahh/page1.htm)
  * [Code Examples](https://www.programcreek.com/java-api-examples/?api=com.ibm.as400.access.AS400)
* [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
* [MvnRepository](https://mvnrepository.com/)
* I used a lot of my coworker's boilerplate code for AS400 + Spring Boot
* [Toolbox for Java and JTOpen](https://developer.ibm.com/articles/i-javatoolbox/#toolbox-for-java-introduction)

