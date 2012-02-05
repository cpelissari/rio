#!/bin/bash
# Exemplo: ./upgrade-kdo.sh estacao003 kdo-1.3.0
ESTACAO=$1
KDO_VERSION=$2

echo "Atualizando '$1' com '$2'"

echo "Copiando arquivos"
sudo cat /opt/$2.tar.gz | ssh $ESTACAO "sudo tar xzf - -C /opt"

echo "Atualizando link simbólico"
ssh $ESTACAO "sudo rm /opt/kdo && sudo ln -s /opt/$2 /opt/kdo"
