#!/bin/sh

VERSION='0.0.1'

cd ..
./gradlew clean build -x test
SHELL_PATH=`pwd -P`
echo "SHELL_PATH is ${SHELL_PATH}"

echo "API Image Build..."
cd $SHELL_PATH/api && docker build -t api:$VERSION .
echo "API Image Build... Done"

echo "CONSUMER Image Build..."
cd $SHELL_PATH/consumer && docker build -t consumer:$VERSION .
echo "CONSUMER Image Build... Done"

echo "CSS Image Build..."
cd $SHELL_PATH/css && docker build -t css:$VERSION .
echo "CSS Image Build... Done"

echo "nginx Image Build"
cd $SHELL_PATH/gateway && docker build -t proxy:$VERSION .
echo "nginx Image Build... Done"