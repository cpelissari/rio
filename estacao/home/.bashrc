# /etc/skel/.bashrc:
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

# keychain
keychain ~/.ssh/id_dsa
. ~/.keychain/$HOSTNAME-sh
. ~/.keychain/$HOSTNAME-sh-gpg

# maven
alias mvn-ci="mvn -DskipTests=true clean install"
alias mvn-ci-with-tests="mvn clean install"
alias mvn-debug="MAVEN_OPTS=\"-Xdebug -Xnoagent -Xmx1024m -XX:MaxPermSize=256m -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000\" mvn"
alias mvn-jetty="mvn -Pmysql-jetty clean jetty:run"

# Git Aliases
export PS1='\[\033[01;32m\]\u@\h\[\033[01;34m\] \w$(__git_ps1 " (%s)") \$\[\033[00m\] '

# Moe's Bash's History Stuff
export HISTSIZE=50000
export HISTCONTROL="ignoreboth"

# here be dragons... gentoo stuff? can't remember anymore!
# Enable colors for ls, etc.  Prefer ~/.dir_colors #64489
if [[ -f ~/.dir_colors ]]; then
	eval `dircolors -b ~/.dir_colors`
else
	eval `dircolors -b /etc/DIR_COLORS`
fi

# Change the window title of X terminals 
case ${TERM} in
	xterm*|rxvt*|Eterm|aterm|kterm|gnome)
		PROMPT_COMMAND='echo -ne "\033]0;${USER}@${HOSTNAME%%.*}:${PWD/$HOME/~}\007"'
		;;
	screen)
		PROMPT_COMMAND='echo -ne "\033_${USER}@${HOSTNAME%%.*}:${PWD/$HOME/~}\033\\"'
		;;
esac
