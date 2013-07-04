#!/bin/bash
usage()
{
cat << EOF
usage: $0 options

This script is designed to build the flockspring database. Please use the following options:

OPTIONS:
   -h      Show this message
   -u      MySql username - required
   -p      Use password for mysql
   -d      Directory to use, default is mysql in current dir
EOF
}

MYSQL_USER=
USE_PASSWD=false
SQL_DIR=
while getopts “ht:r:p:v” OPTION
do
     case $OPTION in
         h)
             usage
             exit 1
             ;;
         u)
             MYSQL_USER=$OPTARG
             ;;
	 p)
	     USE_PASSWD=true
	     ;;
	 d)
	     SQL_DIR=$OPTARG
	     ;;
         ?)
             usage
             exit
             ;;
     esac
done

if [[ -z $TEST ]] || [[ -z $SERVER ]] || [[ -z $PASSWD ]]
then
     usage
     exit 1
fi

if [[ -z SQL_DIR ]]
then
    cd $SQL_DIR
else
    cd mysql
fi

if $USE_PASSWD 
then
     cat *.sql | mysql -u $MYSQL_USER -p
else
     cat *.sql | mysql -u $MYSQL_USER
fi

