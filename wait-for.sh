#!/usr/bin/env bash

CMD_NAME=${0##*/}

usage()
{
    cat << USAGE >&2
Usage:
    $CMD_NAME host:port [-- command args]
    -- COMMAND ARGS             Execute command with args after the test finishes
USAGE
    exit 1
}

wait_for()
{
    HOST=$1
    PORT=$2
    START_TIMESTAMP=$(date +%s)
    while :
    do
        nc -z $HOST $PORT
        if [[ $? -eq 0 ]]; then
            break
        fi
        sleep 1
    done
}

while [ $# -gt 0 ]
do
  case "$1" in
    *:* )
    HOST=$(printf "%s\n" "$1"| cut -d : -f 1)
    PORT=$(printf "%s\n" "$1"| cut -d : -f 2)
    shift 1
    ;;
    --)
    shift
    CLI="$@"
    break
    ;;
    *)
    usage
    ;;
  esac
done

wait_for $HOST $PORT
eval $CLI