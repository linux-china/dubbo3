#!/usr/bin/env bash

./mvnw -DskipTests clean package

./mvnw -pl dubbo clean install
