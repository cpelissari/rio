#!/bin/bash

# Copia um arquivo via scp para uma estação de trabalho
# $1 = arquivo
# $2 = estação destino
# $3 = (opcional) prefixo
scp_copy() {

  file=$1
  dest=$2
  prefix=$3

  echo "Copiando '$file' para '$dest'"
  cat $file | ssh $dest "sudo sh -c \"cat > $prefix$file\""

}
