#! /bin/sh

(cd etc;sh -x reload.sh)
rm -rf lib_managed
rm -rf target/war.lib
sbt update
sbt compile
ant
