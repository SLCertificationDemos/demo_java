#!/bin/sh

DEBUG=-Dsl.httpDebugLog=yes
LOGGING=-Dsl.log.toConsole=true
PACKAGES="i0.sealights.demo.calculator*"
java -Dsl.token="$SL_TOKEN" \
    -Dsl.labId="$SL_LAB_ID" \
    -Dsl.appName="$CALC_APPNAME" \
    -Dsl.branchName="$CALC_BRANCH_NAME" \
    -Dsl.buildName="$CALC_BUILD_NAME" \
    -Dsl.includes="$PACKAGES" \
    -javaagent:./sl-cd-agent.jar \
    -jar $1