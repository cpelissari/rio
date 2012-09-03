/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class KdoDotFilesCommandMaven {

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
        .foundAtBaseDir(templateBaseDir("/templates/kdo/maven"))
        .filterFilesWith(filter)
        .withModel(global)
        .build()
        .parseAll();
  }

  private File templateBaseDir(String resource) throws URISyntaxException {
    URL url = Resources.getResource(getClass(), resource);
    return new File(url.toURI());
  }

}