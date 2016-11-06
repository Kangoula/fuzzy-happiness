#!/bin/sh

npm install
gulp install
bower update
bower install

./mvnw clean package -Dmaven.test.skip=true

cp target/bibal-denis-0.0.1-SNAPSHOT.war src/main/docker/app.war
cd src/main/docker

docker-compose up
