#!/bin/bash

# profile=4 : desktop/gnome
profile=4

echo "Atualizando ambiente"
env-update
source /etc/profile
export PS1="(chroot) $PS1"

echo "Sincronizando portage"
emerge --sync
eselect profile set $profile

locale-gen

echo "Emerging"
emerge -ukDN world && emerge --depclean && revdep-rebuild
