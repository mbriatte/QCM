FROM tomcat
MAINTAINER mbriatte@gmail.com

ADD /target/QCM-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]
