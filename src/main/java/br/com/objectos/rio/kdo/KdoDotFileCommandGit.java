/*
 * KdoDotFilesCommandGit.java criado em 05/09/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import br.com.objectos.comuns.etc.io.BaseDirFileFilter;
import br.com.objectos.comuns.etc.io.Templates;
import br.com.objectos.comuns.etc.model.Dir;
import br.com.objectos.comuns.etc.model.Dirs;
import br.com.objectos.comuns.etc.model.Global;

import com.google.common.io.Resources;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
class KdoDotFileCommandGit implements RioCommand {

  public void execute(Global global) {
    try {
      tryToExecute(global);

    } catch (URISyntaxException e) {
      throw new KdoCommandException(e);

    } catch (IOException e) {
      throw new KdoCommandException(e);

    }
  }

  private void tryToExecute(Global global) throws URISyntaxException, IOException {
    Dirs dirs = global.getDirs();
    Dir userHome = dirs.getUserHome();

    BaseDirFileFilter filter = new BaseDirFileFilter(userHome.getFile());

    Templates
        .foundAtBaseDir(templateBaseDir("/templates/kdo/git"))
        .filterFilesWith(filter)
        .withModel(global)
        .build()
        .parseAll();
  }

  private File templateBaseDir(String resource) throws URISyntaxException {
    URL url = Resources.getResource(getClass(), resource);
    return new File(url.toURI());
  }

  @Override
  public void execute() {
  }

}