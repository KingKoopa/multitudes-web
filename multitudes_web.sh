#!/bin/bash
#
PROJECT_NAME=multitudes-0.0.1-SNAPSHOT
PROJECT_HOME=/home/ec2-user/multitudes_web
LOG=logs/multitudes_web-0.0.1.log
JVM_OPTS="-Xmx128m -Xms128m"

getpid() {
    pid=`pgrep -f "java.*$PROJECT_NAME"`
}

start() {
    getpid
    if [ -n "$pid" ]; then
        echo "$PROJECT_NAME (pid $pid) is already running"
        exit 1
    fi

    nohup java $JVM_OPTS -jar $PROJECT_HOME/target/$PROJECT_NAME.jar > $PROJECT_HOME/$LOG 2>&1 &

    echo -ne "Starting process"
    for i in {1..10}; do
        if ! [ -n "$pid" ]; then
            echo -ne "."
            sleep 1
            getpid
        fi
    done
    echo

    if [ -n "$pid" ]
        then status
        else echo "Error during $PROJECT_NAME starting, see log for details."
    fi
}

stop() {
    status
    if [ -n "$pid" ]
    then
        echo -ne "Stopping process"
        kill $pid
        res=$?
        for i in {1..10}; do
            if [ -n "$pid" ]; then
                echo -ne "."
                sleep 1
                getpid
            fi
        done
        echo
        if ! [ -n "$pid" ]
            then echo "$PROJECT_NAME has been successfully stopped."
            else echo "Error during $PROJECT_NAME stopping... $res"
        fi
    fi
}

status() {
    getpid
    if [ -n "$pid" ]
        then echo "$PROJECT_NAME (pid $pid) is running..."
        else echo "$PROJECT_NAME is NOT running"
    fi
}

case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    status)
        status
        ;;
    restart)
        stop
        start
        ;;
    *)
        echo $"Usage: $0 {start|stop|restart|status}"
        exit 1
esac

exit 0
