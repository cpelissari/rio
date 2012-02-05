#!/bin/bash
ESTACAO=$1

echo "Atualizando kernel $1"
sudo mount /boot
ssh $ESTACAO "sudo mount /boot"
sudo tar cf - -C / boot | ssh $ESTACAO "sudo tar xf - -C /"

sudo umount /boot
ssh $ESTACAO "sudo umount /boot"

echo "Atualizando /usr/src $1"
sudo tar cf - -C /usr src | ssh $ESTACAO "sudo tar xf - -C /usr"

echo "Atualizando /lib/modules $1"
sudo tar cf - -C /lib modules | ssh $ESTACAO "sudo tar xf - -C /lib"
