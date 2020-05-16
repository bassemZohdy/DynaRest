FROM bzohdy/java
WORKDIR /app
COPY ./target/dynarest-0.0.1-SNAPSHOT.jar .
COPY ./wait-for.sh .
EXPOSE 8080
ENTRYPOINT ["./wait-for.sh","mysql:3306","--","./wait-for.sh","mongo:27017","--","java -jar ./dynarest-0.0.1-SNAPSHOT.jar"]