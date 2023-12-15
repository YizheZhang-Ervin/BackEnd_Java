#!/bin/bash
image_tag=ervin/k8s-app-portal:1.0
mvn package -D skipTests
docker build . -t $image_tag
docker push $image_tag
