#!/bin/bash
. functions.sh

estacao=$1
files=`cat etc/portage-files | grep -v ^#`

for f in $files
do
  scp_copy $f $estacao "/mnt/gentoo"
done

#echo "Atualizando /var/lib/portage/world"
#cat /var/lib/portage/world | ssh $ESTACAO "sudo sh -c \"cat > /var/lib/portage/world\""
# comm -3 /var/lib/portage/world world.estacao.remove | ssh $ESTACAO "sudo sh -c \"cat > /var/lib/portage/world\""

echo "Montando /mnt/portage/packages"
ssh_mount "$estacao" "servidor010.rio.objectos.com.br:/srv/portage/distfiles" "/mnt/portage/distfiles" "/mnt/gentoo"
ssh_mount "$estacao" "servidor010.rio.objectos.com.br:/srv/portage/packages/estacao" "/mnt/portage/packages" "/mnt/gentoo"

echo "Copiando script install-portage-chroot.sh"
scp install-portage-chroot.sh $estacao:/
scp install-portage-make.sh $estacao:/mnt/gentoo

echo "Para continuar o processo:"
echo "# ssh $estacao"
echo "# /install-portage-chroot.sh"
echo "# ./install-portage-make.sh"
