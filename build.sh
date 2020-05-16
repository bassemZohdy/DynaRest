#!/usr/bin/env bash

docker-compose down
mvn clean package -DskipTests
docker-compose build
docker-compose up