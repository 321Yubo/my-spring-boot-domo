# Introduction
Based on spring boot a simple Java WEB pay , integrated with some basic simple functions .

## Quickstart
1、Import ppdsp-0.1.0-SNAPSHOT-standalone.jar into the maven repository
 ```
 mvn install:install-file -Dfile="ppdsp-0.1.0-SNAPSHOT-standalone.jar" -DgroupId=com.ppdsp -DartifactId=noise.addition.variations -Dversion=0.1.0-SNAPSHOT -Dpackaging=jar

 ```
 2、Building Java WEB server
And building jar(demo-0.0.1-SNAPSHOT.jar)
```
   mvn  -DskipTests=true package
   ```
   or

   idea build
   Lifecycle =>package
   
   
 3、 Start web server

   3.1 server

  
       ```
       Java -jar  demo-0.0.1-SNAPSHOT.jar
        ```
        
   3.2 
idea
  
run

SpringBootDemoApplication
## Dependencies
Java (>= 1.8.0)

Spring-boot (>= 2.0.5.RELEASE)

maven (>= 3.8.6)
