#!/bin/bash

# Copia um arquivo via scp para uma estação de trabalho
# $1 = arquivo
# $2 = estação destino
# $3 = (opcional) prefixo
scp_copy() {

  file=$1
  host=$2
  prefix=$3
  dest="$prefix$file"

  echo "Copiando '$file' para '$host:$dest'"
  cat $file | ssh $host "cat > $dest"

}

ssh_mount() {

  host=$1
  device=$2
  dir=$3
  prefix=$4

  ssh $host "mkdir -p $prefix$dir && mount -t nfs $device $prefix$dir"

}

ssh_umount() {

  host=$1
  dir=$2
  prefix=$3

  ssh $host "umount $prefix$dir"

}
