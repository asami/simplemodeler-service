#! /bin/sh

(cd etc;sh -x reload.sh)
rm -rf lib_managed
sbt update
ant
