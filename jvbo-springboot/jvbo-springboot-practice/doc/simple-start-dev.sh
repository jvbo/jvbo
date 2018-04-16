#/bin/sh

if [ $(lsof -t -i:8088) ]; then
kill -9 $(lsof -t -i:8088)
else
echo "no 8088"
fi

mv jvbo-springboot-practice-0.0.1-SNAPSHOT.war jvbo-springboot-practice-0.0.1-SNAPSHOT.war`date '+%Y-%m-%d-%H%M%S'`

mv packages/jvbo-springboot-practice-0.0.1-SNAPSHOT.war .

java -jar jvbo-springboot-practice-0.0.1-SNAPSHOT.war --spring.profiles.active=dev >/dev/null 2>&1 &