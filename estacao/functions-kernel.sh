#!/bin/bash

rio_kernel() {

  host=$1
  prefix=$2

  echo "Atualizando kernel $1"
  mount /boot
  tar cf - -C / boot | ssh $host "tar xf - -C $prefix/"
  
  umount /boot

  echo "Atualizando /usr/src $1"
  tar cf - -C /usr src | ssh $host "tar xf - -C $prefix/usr"

  echo "Atualizando /lib/modules $1"
  tar cf - -C /lib modules | ssh $host "tar xf - -C $prefix/lib"

}
