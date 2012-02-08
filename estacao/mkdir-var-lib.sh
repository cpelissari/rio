#!/bin/bash

host=$1
dir=$2

echo "Criando diretório $dir em $host"
ssh $host "mkdir -p $dir && chmod 775 $dir && chgrp users $dir"
