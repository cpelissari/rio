#!/bin/bash
mount -t proc none /mnt/gentoo/proc
mount --rbind /dev /mnt/gentoo/dev
chroot /mnt/gentoo /bin/bash
