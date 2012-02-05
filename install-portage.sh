#!/bin/bash
ESTACAO=$1

ARQs=""
ARQs="$ARQs /etc/make.conf"
ARQs="$ARQs /etc/portage/package.keywords"
ARQs="$ARQs /etc/portage/package.mask"
ARQs="$ARQs /etc/portage/package.use"

for ARQ in $ARQs
do
   echo "Copiando '$ARQ'"
   cat $ARQ | ssh $ESTACAO "sudo sh -c \"cat > $ARQ\""
done

echo "Atualizando /var/lib/portage/world"
cat /var/lib/portage/world | ssh $ESTACAO "sudo sh -c \"cat > /var/lib/portage/world\""

echo "Chamando eix-sync"
ssh $ESTACAO "sudo sh -c \"eix-sync\""

echo "Montando /mnt/portage/packages"
ssh $ESTACAO "sudo sh -c \"/etc/init.d/netmount start\""

echo "Emerging"
ssh $ESTACAO "sudo sh -c \"emerge -ukDN world && emerge --depclean && revdep-rebuild\""

echo "(Des)montando /mnt/portage/packages"
ssh $ESTACAO "sudo sh -c \"/etc/init.d/netmount stop\""
