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


/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
public class RioKdo {

  public static void main(String[] args) {
    RioCommand instancia = criaInstancia(args);
  }

  public static RioCommand criaInstancia(String[] args) {
    RioCommand classe = null;

    if (args[2] == "--git") {
      classe = new KdoDotFileCommandGit();
      return classe;
    }
    else if (args[2] == "--maven") {
      classe = new KdoDotFilesCommandMaven();
      return classe;
    }
    return classe;
  }

}