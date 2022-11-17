# 简介
基于spring boot 的一个简单的Java WEB付，集成了一些基本的简单功能。

## Quickstart
1、把ppdsp-0.1.0-SNAPSHOT-standalone.jar 导入maven仓库里
 ```
 mvn install:install-file -Dfile="ppdsp-0.1.0-SNAPSHOT-standalone.jar" -DgroupId=com.ppdsp -DartifactId=noise.addition.variations -Dversion=0.1.0-SNAPSHOT -Dpackaging=jar

 ```
 2、构建Java WEB 服务
并生产jar包(demo-0.0.1-SNAPSHOT.jar)
```
   mvn  -DskipTests=true package
   ```
   或

   idea 构建
   Lifecycle -》package
   
   
 3、 启动web 服务

   3.1 服务器

  
       ```
       Java -jar  demo-0.0.1-SNAPSHOT.jar
        ```
        
   3.2 
idea
  
运行

SpringBootDemoApplication
## Dependencies
Java (>= 1.8.0)

Spring-boot (>= 2.0.5.RELEASE)

maven (>= 3.8.6)
