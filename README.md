# viewer

use tomcat 
add in /conf/context.xml

    <Resource name="jdbc/viewer" auth="Container"
          type="javax.sql.DataSource" driverClassName="org.postgresql.Driver"
          url="jdbc:postgresql://localhost:5432/viewer"
          username="postgres" password="admin"
          maxTotal="10" maxIdle="5" maxWaitMillis="-1"/>

add in /lib file postgresql-42.1.4.jar (https://jdbc.postgresql.org/download.html)

use Postgres SQL
<br> <code>CREATE DATABASE viewer;<code>

<pre>in app 
module viewer-service - application.properties
 param: documents.dir= add your path to .dbf files

 param: runTask= update file every time at start -> true/false

-- no sql scripts - tables generate from code;
</pre>
