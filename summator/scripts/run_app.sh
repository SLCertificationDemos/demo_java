#!/bin/sh

## The variables are set in the docker-compose file. You can run in as well calling the
## docker run --env-file=FILE ...
# SL_TOKEN=token
# SL_LAB_ID=a
# SL_BRANCH_NAME=c

DEBUG=-Dsl.httpDebugLog=yes
LOGGING=-Dsl.log.toConsole=true
PACKAGES="i0.sealights.demo.summator*"

java -jar $1