#!/bin/bash

if [ $(lsof -t -i:8080) ]; then
kill -9 $(lsof -t -i:8080)
else
echo "no 8080"
fi

cd /opt/env/git/jvbo
git stash
git pull
mvn -DskipTests install
cd /jvbo-springboot/jvbo-springboot-practice

exec_args="jvbo-springboot-practice"
debug_port=5007




function get_pid {
  local exec_args=$1
  ps -ef | grep java | awk -v exec_args="${exec_args}" '$0 ~ exec_args { print $2 }'
}

function check_pid_running {
  local pid=$1
  if [[ "${pid}" == "" ]]; then
    return 1
  fi
  if ps -p ${pid} > /dev/null; then
    return 0
  else
    return 1
  fi
}

function process_command {

  local pid=$1
  local command=$2
  local server_name=$3

  case ${command} in

    status)
      if check_pid_running ${pid}; then
        echo "${server_name} is running (" ${pid} ")"
      else
        echo "${server_name} not running"
      fi
      ;;

    stop)
      if check_pid_running ${pid}; then
        kill -TERM ${pid}
        echo -ne "Stopping ${server_name}"
        not_killed=1
        for i in $( seq 1 30 ); do
          if check_pid_running ${pid}; then
            echo -ne "."
            sleep 1
          else
            not_killed=0
          fi
        done
        echo
        if [[ ${not_killed} == 1 ]]; then
          echo "Cannot kill process " ${pid}
          exit 1
        fi
        echo "${server_name} stopped"
      else
         echo "${server_name} already stopped"
      fi
      ;;

    start)
      if check_pid_running ${pid}; then
        echo "${server_name} already running"
        exit 1
      fi
      start_server
      echo "${server_name} started"
      ;;

    debug)
      if check_pid_running ${pid}; then
        echo "${server_name} already running"
        exit 0
      fi
      start_server_debug
      echo "${server_name} started"
      ;;

    restart)
      $0 stop
      if [[ $? == 1 ]]; then
        exit 1
      fi
      $0 start
      ;;

    log)
      local log_file=$( server_log_file )
      echo ${log_file}
      tail -f ${log_file}
      ;;

    *)
      echo "Usage: $0 {start|stop|restart|debug|status|log}"
      exit 1

  esac
}




pid=$( get_pid ${exec_args} )

# 内置tomcat,jar形式
function start_server {
  nohup mvn spring-boot:run -Dexec.args="${exec_args}" -Dspring.profiles.active=env 2>&1 \
    | nohup cronolog "/opt/env/git/jvbo/${exec_args}/log/%Y%m%d.log" >> /opt/env/log/jvbo/jvbo-springboot/jvbo-springboot-practice/nohup.out 2>&1 &
}

function start_server_debug {
  MAVEN_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=${debug_port},suspend=n \
  -jar /opt/tprofiler/tprofiler-1.0.1.jar -Dprofile.properties=/opt/tprofiler/profile.properties" start_server
}

process_command "${pid}" "$1" "${exec_args}"

exit 0
