#!/usr/bin/env bash
#设置变量：摘取pom文件project.name,project.version
NAME=`mvn help:evaluate -Dexpression=project.artifactId | grep "^[^\[]"`
VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`
echo "JAR NAME : ${NAME}-${VERSION}.jar"

#杀死已存在进程：if [ -n "$xxx" ]用于判断xxx变量非空  fi为if语句的结束,相当于end if
pid=`ps -ef | grep ${NAME}-${VERSION}.jar|grep -v grep|awk '{print $2}'`
if [ -n "$pid" ]
then
  kill -9 $pid
  echo "${NAME}-${VERSION}.jar pid = ${pid} has been Killed"
fi


#设置JENKINS_SERVER_COOKIE：由于pipeline退出时候会kill掉其子进程，遵循规则——kill process only in case if JENKINS_NODE_COOKIE and BUILD_ID are unchanged
echo "before modification:  BUILD_ID = ${BUILD_ID}  JENKINS_SERVER_COOKIE = ${JENKINS_NODE_COOKIE}"
#BUILD_ID=keepmealive ps:针对自由风格项目而非pipeline的项目可通过修改此变量，防止被ProcessTreeKiller kill掉
JENKINS_NODE_COOKIE=keepmealive
echo "after modification:   BUILD_ID = ${BUILD_ID}  JENKINS_SERVER_COOKIE = ${JENKINS_NODE_COOKIE}"

#后台jar包启动,并将日志输出到application.log 文件
nohup java -Xms800m -Xmx800m -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m -XX:MaxNewSize=512m -jar ./target/${NAME}-${VERSION}.jar 1>/var/lib/jenkins/workspace/application.log 2>&1 &

#打印启动成功日志
echo "${NAME}-${VERSION}.jar start successful"