#!/bin/bash

lines=`docker image ls amazoncorretto:20 | wc -l`

if [ $lines -ne "2" ];
then
	docker pull amazoncorretto:20;
fi

docker run -it -v "$(pwd)":/class amazoncorretto:20
