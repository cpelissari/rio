/*
 * KdoInitCommand.java criado em 05/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import br.com.objectos.comuns.cli.AbstractCommand;
import br.com.objectos.rio.KdoInitOptions;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
class KdoInitCommand extends AbstractCommand<KdoInitOptions> {

  /*  private final Command comando;

    private final KdoDotFileCommandGit git;

    private final KdoDotFilesCommandMaven maven;*/

  @Override
  public String getName() {
    return Kdo.INIT.getName();
  }

  @Override
  protected void executeWithOptions(KdoInitOptions options) {

  }
  @Override
  protected KdoInitOptions getNewOptions() {
    return null;
  }

}