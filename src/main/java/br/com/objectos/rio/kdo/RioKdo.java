/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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

import br.com.objectos.rio.KdoInitOptions;

import com.beust.jcommander.JCommander;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
public class RioKdo {

  /*  private final KdoDotFileCommandGit commandGit;

    private final KdoDotFilesCommandMaven commandMaven;

    @Inject
    public RioKdo(KdoDotFileCommandGit commandGit, KdoDotFilesCommandMaven commandMaven) {
      this.commandGit = commandGit;
      this.commandMaven = commandMaven;
    }
  */

  public static void main(String[] args) {
    System.out.println(args.length);
    // kdo dots --git
    JCommander jc = new JCommander();
    KdoInitOptions options = new KdoInitOptions();
    jc.addCommand("--git", options.getOptionGit());

    jc.parse(args[0]);

    // , args[1], args[2], args[3]
    System.out.println("classe retornada com sucesso" + "Parâmetro = " + jc.getParsedCommand());

    Object classeretornada = CriaInstancia(args);
  }

  public static Object CriaInstancia(String[] args) {
    Object classe = new Object();

    if (args[0] == "--git") {
      classe = new KdoDotFileCommandGit();
    }
    else if (args[0] == "--maven") {
      classe = new KdoDotFilesCommandMaven();
    }
    return classe;
  }

}