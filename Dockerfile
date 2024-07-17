FROM openjdk:23-ea-17-jdk

COPY /target/Blog-System.jar /app/Blog-System.jar

WORKDIR /app

EXPOSE 8085

# 修改mysql连接地址，让容器内能够连接上宿主机的mysql
ENTRYPOINT ["java","-jar","Blog-System.jar",
"--spring.datasource.url=jdbc:mysql://host.docker.internal:3306/blog_system?useSSL=false&serverTimezone=UTC"]