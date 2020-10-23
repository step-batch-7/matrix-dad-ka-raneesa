# /bin/sh

set -eu;

./compile.sh

TESTNAMES=`find test -name "*Test.java" | sed "s/test\///" | sed "s/.java//" | tr "/" "."`

echo "Running tests...\n"
java -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar org.junit.runner.JUnitCore $TESTNAMES