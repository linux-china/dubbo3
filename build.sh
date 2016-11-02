#!/usr/bin/env bash

mvn -DskipTests clean package

mvn -pl dubbo clean install
