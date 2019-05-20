# IBMi-SpringBoot-API


A Spring Boot API to easily expose IBMi information. Currently, has endpoints to return lists for libraries, files, and members.

## Dependencies
* IBMi running V7R3
* Java 8
* [JTOpen 9.8](http://jt400.sourceforge.net/)
* JUnit 5.4.2
* Spring Boot 2.1.4
  * Actuator
  * DevTools
  * Web
* Swagger 2 (/swagger-ui.html#/)


## Endpoints
| Endpoint                  | Description                  |
| ------------------------- | ---------------------------- |
| /actuator                 | Actuator                     |
| /v2/api-docs              | Swagger 2 API Docs           |
| /api/v1                   | Base core API (Does nothing) |

[![endpoints](https://github.com/barrettotte/IBMi-SpringBoot-API/blob/master/screenshots/swagger-qsys.PNG)](https://github.com/barrettotte/IBMi-SpringBoot-API/blob/master/screenshots/swagger-qsys.PNG)


## Examples
```curl http://127.0.0.1:8044/api/v1/qsys/catalogs/db/schemas/bolib/tables```
```json
[
  {
    "table_name": "QCLLESRC",
    "table_type": "BASE TABLE"
  },
  {
    "table_name": "QDDSSRC",
    "table_type": "BASE TABLE"
  },
  {
    "table_name": "QRPGLESRC",
    "table_type": "BASE TABLE"
  },
  {
    "table_name": "QRPGSRC",
    "table_type": "BASE TABLE"
  }
]
```

```curl http://127.0.0.1:8044/api/v1/qsys/catalogs/db/schemas/bolib/tables/qrpglesrc/partitions```
```json
[
  {
    "data_size": 1,
    "partition_text": "Fizzbuzz in RPGLE Free",
    "partition_number": 10,
    "create_timestamp": "2019-04-02 11:42:18.0",
    "last_save_timestamp": "2019-05-18 03:41:46.0",
    "number_rows": 16,
    "number_row_pages": 1,
    "source_type": "RPGLE",
    "system_table_member": "FIZZBUZZ "
  },
  // ...
]
```

```curl http://127.0.0.1:8044/api/v1/qsys/catalogs/db/schemas/bolib/tables/qrpglesrc/partitions/fizzbuzz```
```json
[
  {
    "srcdat": 190402,
    "srcseq": 1,
    "srcdta": " /free "
  },
  {
    "srcdat": 190402,
    "srcseq": 2,
    "srcdta": " // The classic fizzbuzz program in RPGLE Free "
  },
  {
    "srcdat": 190402,
    "srcseq": 3,
    "srcdta": " dcl-s num int(10); "
  },
  {
    "srcdat": 190402,
    "srcseq": 4,
    "srcdta": " "
  },
  {
    "srcdat": 190402,
    "srcseq": 5,
    "srcdta": " for num = 1 to 100; "
  },
  {
    "srcdat": 190403,
    "srcseq": 6,
    "srcdta": " if %REM(num:3) = 0 and %REM(num:5) = 0; "
  },
  {
    "srcdat": 190402,
    "srcseq": 7,
    "srcdta": " dsply ('num - ' + %char(num) + ' FIZZBUZZ'); "
  },
  {
    "srcdat": 190402,
    "srcseq": 8,
    "srcdta": " elseif %rem(num:3) = 0; "
  },
  {
    "srcdat": 190402,
    "srcseq": 9,
    "srcdta": " dsply ('num - ' + %char(num) + ' FIZZ'); "
  },
  {
    "srcdat": 190402,
    "srcseq": 10,
    "srcdta": " elseif %rem(num:5) = 0; "
  },
  {
    "srcdat": 190402,
    "srcseq": 11,
    "srcdta": " dsply ('num - ' + %char(num) + ' BUZZ'); "
  },
  {
    "srcdat": 190402,
    "srcseq": 12,
    "srcdta": " else; "
  },
  {
    "srcdat": 190402,
    "srcseq": 13,
    "srcdta": " dsply ('num - ' + %char(num)); "
  },
  {
    "srcdat": 190402,
    "srcseq": 14,
    "srcdta": " endif; "
  },
  {
    "srcdat": 190402,
    "srcseq": 15,
    "srcdta": " endfor; "
  },
  {
    "srcdat": 190402,
    "srcseq": 16,
    "srcdta": " *INLR = *ON; "
  }
]
```


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


## Future Goals
* Sending IBMi credentials in HTTP body
* More information returned in each endpoint
* Endpoints for qsys/catalogs/{catalog}/users and qsys/catalogs/{catalog}/users/{user}
* Endpoint for base IFS /api/v1/ifs
* Endpoint for viewing message queues (QSYSOPR)
* Endpoint for viewing printer queues (QPRINT)


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
* RPGPGM Articles
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