#!/bin/bash

lines=`docker image ls amazoncorretto:11 | wc -l`

if [ $lines -ne "2" ];
then
	docker pull amazoncorretto:11;
fi

docker run -it -v "$(pwd)":/class amazoncorretto:11
