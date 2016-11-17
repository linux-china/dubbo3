#!/usr/bin/env bash

./mvnw clean

rm -rf ~/.m2/repository/com/alibaba/dubbo*

./mvnw -DskipTests clean source:jar package install
