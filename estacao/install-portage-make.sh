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

echo "locale-gen: utf-8"
locale-gen

echo "Alguns pacotes não instalam sem o kernel..."
emerge -k gentoo-sources

cd /usr/src/linux
make defconfig
make modules_prepare
cd /

echo "Emerging"
emerge -ukDN world && emerge --depclean && revdep-rebuild
