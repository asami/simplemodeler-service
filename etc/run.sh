#!/bin/sh

MAIN_LIB=target/scala-2.9.1

LIB=target/war.lib

LIBS=

java -jar $MAIN_LIB/g3-simplemodeler_2.9.1-1.0.jar -classpath $LIBS -g3.server
