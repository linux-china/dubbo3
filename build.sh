#!/usr/bin/env bash

./mvnw clean

./mvnw -DskipTests clean package

./mvnw -pl dubbo clean install
