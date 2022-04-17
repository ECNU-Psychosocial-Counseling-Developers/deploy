#!/bin/sh

NAME="Psychosocial-Counseling"
echo $NAME
# shellcheck disable=SC2006
# shellcheck disable=SC2009
ID=`ps -ef | grep "$NAME" | grep -v "$0" | grep -v "grep" | awk '{print $2}'`
echo "Previous Project Process ID: $ID"
echo "---------------"
for id in $ID
do
  kill -9 "$id"
  echo "$id Has Been Killed"
done
echo "Redeploy..."
git clone git@github.com:ECNU-Psychosocial-Counseling-Developers/backend.git
# shellcheck disable=SC2164
cd backend
git pull
mvn clean
mvn install
nohup java -jar target/Psychosocial-Counseling-0.0.1-SNAPSHOT.jar 1>platform_run.out 2>platform_error.out &

