# IBMi-SpringBoot-API


A Spring Boot API to easily expose IBMi information as JSON via REST endpoints.


## Dependencies
* IBMi running V7R3
* Java 8
* [JTOpen 9.8](http://jt400.sourceforge.net/)
* JUnit 5.4.2
* Spring Boot 2.1.4
  * Actuator
  * DevTools
  * Security
  * Web


## Future Goals
* Endpoint for base IFS /api/v1/ifs
* Endpoint for viewing message queues (QSYSOPR)
* Endpoint for viewing printer queues (QPRINT)


## Endpoints
| Endpoint                  | Description                  |
| ------------------------- | ---------------------------- |
| /api/v1                   |                              |
| /api/v1/qsys              |                              |
| /api/v1/qsys/catalogs     | Get all relational databases |
| ../catalogs/<A>           |                              |
| ../catalogs/<A>/schemas   | Get all libraries            |
| ../schemas/<B>            |                              |
| ../schemas/<B>/tables     | Get all files                |
| ../tables/<C>             |                              |
| ../tables/<C>/paritions   | Get members of file          |
| ../partitions/<D>         | Get all lines of member      |


## Configuration
```properties
# application.properties template
info.app.name = IBMi API Service
server.port = 8044
db.datasource.as400.username = ?
db.datasource.as400.password = ?
db.datasource.as400.url = jdbc:as400://?/;prompt=false;naming=system;*LIBL
db.datasource.as400.driver-class-name = com.ibm.as400.access.AS400JDBCDriver
```


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
* Generated project using [Spring Initializr](https://start.spring.io/)
* [Gradle Docs](https://docs.gradle.org/current/userguide/userguide.html)
* IBMi DB2 SQL
  * [ANS and ISO catalog views](https://www.ibm.com/support/knowledgecenter/SSAE4W_9.1.0/com.ibm.etools.iseries.langref2.doc/rbafzcatalogans.htm)
  * [DB2 for i SQL reference](https://www.ibm.com/support/knowledgecenter/SSAE4W_9.1.0/com.ibm.etools.iseries.langref2.doc/rbafzintro.htm)
  * [IBMi catalog tables and views](https://www.ibm.com/support/knowledgecenter/SSAE4W_9.1.0/com.ibm.etools.iseries.langref2.doc/rbafzcatalogtbls.htm)
  * [ODBC and JDBC catalog views](https://www.ibm.com/support/knowledgecenter/SSAE4W_9.1.0/com.ibm.etools.iseries.langref2.doc/rbafzcatalogodbc.htm)
* [ILE Editor](https://github.com/worksofbarry/ILEditor) - Inspiration for project
* Java and AS400 
  * [IBM Knowledge Center](https://www.ibm.com/support/knowledgecenter/ssw_ibm_i_71/rzahh/page1.htm)
  * [Code Examples](https://www.programcreek.com/java-api-examples/?api=com.ibm.as400.access.AS400)
* [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
* [MvnRepository](https://mvnrepository.com/)


* RPGPGM
  * https://www.rpgpgm.com/2018/01/sql-views-to-list-sql-programs-and.html
  * https://www.rpgpgm.com/2017/11/sql-view-for-information-about-job.html
  * https://www.rpgpgm.com/2017/06/sql-views-for-authorization-lists.html
  * https://www.rpgpgm.com/2017/05/using-sql-for-message-queue-data.html
  * https://www.rpgpgm.com/2016/01/using-sql-for-objects-statistics.html
  * https://www.rpgpgm.com/2015/12/almost-everything-you-wanted-to-know.html
  * https://www.rpgpgm.com/2015/12/output-queue-entries-information-via-sql.html
  * https://www.rpgpgm.com/2015/11/getting-active-jobs-data-using-sql.html
  * https://www.rpgpgm.com/2015/11/getting-information-about-user-profiles.html
  * https://www.rpgpgm.com/2015/10/using-sql-to-get-information-about-job.html
  * https://www.rpgpgm.com/2015/06/using-sql-to-get-information-from-job.html
  * https://www.rpgpgm.com/2015/05/getting-information-about-views-and.html
  * https://www.rpgpgm.com/2014/11/getting-list-of-files-in-ifs-directory.html
  
* [Toolbox for Java and JTOpen](https://developer.ibm.com/articles/i-javatoolbox/#toolbox-for-java-introduction)