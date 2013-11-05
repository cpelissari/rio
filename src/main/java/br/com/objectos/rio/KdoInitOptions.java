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
package br.com.objectos.rio;

import br.com.objectos.comuns.cli.Options;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Parameters(separators = "=")
public class KdoInitOptions implements Options {
  @Parameter(names = "--git", description = "testando")
  private final String optionGit = "git";

  @Parameter(names = "--maven")
  private final String optionMaven = "maven";

  @Parameter(names = "--eclipse")
  private final String optionEclipse = "eclipse";

  public String getOptionGit() {
    return optionGit;
  }

  public String getOptionMaven() {
    return optionMaven;
  }

  public String getOptionEclipse() {
    return optionEclipse;
  }

}