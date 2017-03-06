# ngannsophal-weekend-assignment
NgannSophal RUPP Mite Weekend Assignment
(JDBC servlet + jsp web application)

Note: mockup data with following account (username/pwd)<br>
1 - admin / adminPassword<br>
2 - user-test / userPassword 

#Application features:
-user must login first before using the system.<br>
-list customer page + filter by phone number / email + pagination<br>
-insert new record<br>
-edit record<br>
-delete<br>

# Create MySql database    
```java
=====initial sql schema.sql======== run it mysql console
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;
         
DROP TABLE IF EXISTS td_customer;
CREATE TABLE `td_customer` (
	`cus_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`cus_first_name` VARCHAR(30) NOT NULL,
	`cus_last_name` VARCHAR(30) NOT NULL,
	`cus_gender` VARCHAR(1) NOT NULL COMMENT 'M:Male, F:Female',
	`cus_email_address` VARCHAR(30) NOT NULL,
	`cus_DOB` DATE NOT NULL,
	`cus_address` VARCHAR(300) NOT NULL,
	`cus_phoneNumber` VARCHAR(500) NOT NULL,
	`date_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`date_updated` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`cus_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
 
DELETE FROM `td_customer`;

INSERT INTO `td_customer` (`cus_id`, `cus_first_name`, `cus_last_name`, `cus_gender`, `cus_email_address`, `cus_DOB`, `cus_address`, `cus_phoneNumber`, `date_created`, `date_updated`) VALUES
	(1, 'Sophal', 'Ngann', 'M', 'ngannsophal12@gmail.com', '2011-05-17', ' pp cambodia', ' 324324777', '2017-03-03 12:52:44', '2017-03-04 19:06:24'),
	(5, ' Go', ' Met', 'M', 'mgo@abc.org', '1982-09-29', 'France', '023695847', '2017-03-04 16:45:30', '2017-03-04 22:04:01'),
	(6, 'Kong', ' Kea', 'M', ' kkong@g.com', '1987-06-18', 'pp cambodia', ' 013695874', '2017-03-04 19:09:43', '2017-03-04 19:09:56'),
	(7, 'Chan', 'Tida', 'M', 'tchan@test.com', '1971-03-19', 'Austral', '012584796', '2017-03-04 21:40:27', NULL),
	(8, ' Paul', ' Dave', 'M', ' dpaul@te.test', '1997-08-13', ' English', ' 012695842', '2017-03-04 22:05:30', '2017-03-04 22:08:31'),
	(9, ' Keo', ' Sarat', 'F', ' skeo@avc.test', '1992-10-18', ' Mixico', '017695842', '2017-03-04 22:09:35', NULL),
	(10, 'Donal', ' Try', 'M', ' tdonal@agh.test', '1999-03-23', 'Singapore', ' 012695847', '2017-03-04 22:28:17', NULL),
	(11, ' Obama', ' Ba', 'F', ' bobama@fdsf.test', '2017-03-29', 'USA', ' 023987654', '2017-03-04 22:29:34', NULL),
	(13, 'Davy', ' Sokha', 'F', ' sdavy@gmai.co', '1986-03-26', 'pp cambodia', '012697747', '2017-03-04 22:32:19', NULL),
	(14, ' Samut', ' Sit', 'F', ' ssmut@agt.test', '1998-03-14', ' Malasia', ' 015695847', '2017-03-04 22:33:27', NULL),
	(15, ' Titith', '  Choun', 'M', 'ctirith', '1986-03-16', 'pp cambodia', ' 017695847', '2017-03-04 22:34:43', NULL),
	(16, ' Bopha', ' Chea', 'F', ' cbopha@ty.test', '1999-12-31', 'Lao ', ' 016987456', '2017-03-04 22:36:10', NULL);

==============================================
```
Set DB username: "root" and DB password:empty in pom.xml
```
<profile>
      <id>test</id>
      <properties>
        <database.driver>com.mysql.jdbc.Driver</database.driver>
        <database.url>jdbc:mysql://localhost:3306/test?autoReconnect=true</database.url>
        <database.username>root</database.username>
        <database.password></database.password>
      </properties>
 </profile>
```
# Build project with maven + jetty server
open command Prompt<br>
C:\workspace\ngannsophal-weekend-assignment>mvn clean install

Start jetty server with maven

mvn clean jetty:run

# Client html page
- http://localhost:8080/

#References

https://github.com/sophea/jdbc

http://www.concretepage.com/spring-4/spring-4-mvc-hibernate-4-mysql-maven-crud-integration-using-annotation-and-xml-with-tomcat-8-and-spring-boot-example

http://stackoverflow.com/questions/18257648/get-the-current-date-in-java-sql-date-format

http://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl

http://stackoverflow.com/questions/2400955/how-to-store-java-date-to-mysql-datetime

http://stackoverflow.com/questions/1890438/how-to-get-parameters-from-the-url-with-jsp

https://www.aspsnippets.com/Articles/Change-Browser-URL-without-reloading-refreshing-page-using-HTML5-in-JavaScript-and-jQuery.aspx

http://stackoverflow.com/questions/11460906/how-to-use-cif-in-jsp-file-eclipse-said-it-is-unknown-tag
