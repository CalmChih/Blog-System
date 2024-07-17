FROM openjdk:23-ea-17-jdk

COPY /target/Blog-System.jar /app/Blog-System.jar

WORKDIR /app

EXPOSE 8085

ENTRYPOINT ["java","-jar","Blog-System.jar", "--spring.datasource.url=jdbc:mysql://host.docker.internal:3306/blog_system?useSSL=false&serverTimezone=UTC"]