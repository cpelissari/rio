# /etc/skel/.bashrc
#
# This file is sourced by all *interactive* bash shells on startup,
# including some apparently interactive shells such as scp and rcp
# that can't tolerate any output.  So make sure this doesn't display
# anything or bad things will happen !


# Test for an interactive shell.  There is no need to set anything
# past this point for scp and rcp, and it's important to refrain from
# outputting anything in those cases.
if [[ $- != *i* ]] ; then
        # Shell is non-interactive.  Be done now!
        return
fi


# Put your fun stuff here.
alias mvn-ci="mvn -DskipTests=true clean install"
alias mvn-ci-with-tests="mvn clean install"
alias mvn-jetty="mvn clean compile jetty:run"

export MAVEN_OPTS="-Xmx1024m -Xms1024m -XX:MaxPermSize=256m"