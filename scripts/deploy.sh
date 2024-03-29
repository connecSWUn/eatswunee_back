#!/usr/bin/env bash

REPOSITORY=/home/ubuntu/swulab/app
PROJECT_NAME=eatswunee

echo "> Build 파일 복사"
cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 현재 구동 중인 애플리케이션 pid 확인"
CURRENT_PID=$(pgrep -f $PROJECT_NAME)

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]
 then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다"
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR_NAME: $JAR_NAME"
echo "> $JAR_NAME 에 실행권한 추가"
chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"
nohup java -jar \
  -Dspring.config.location=classpath:/application.yml,/home/ubuntu/swulab/application-devdb.yml,/home/ubuntu/swulab/application-fcm-dev.yml,/home/ubuntu/swulab/application-s3.yml,/home/ubuntu/swulab/application-jwt-dev.yml \
  -Dspring.profile.active=dev \
  $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
