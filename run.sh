set -eu;

sh compile.sh

echo "Running tests...\n"
java -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar org.junit.runner.JUnitCore $1