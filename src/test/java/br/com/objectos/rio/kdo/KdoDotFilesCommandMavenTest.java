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

import static br.com.objectos.comuns.etc.EtcFiles.readAllLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.inject.Inject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.comuns.etc.EtcFiles;
import br.com.objectos.comuns.etc.model.Dirs;
import br.com.objectos.comuns.etc.model.FakeGlobals;
import br.com.objectos.comuns.etc.model.Global;
import br.com.objectos.rio.RioTestModule;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class KdoDotFilesCommandMavenTest {

  @Inject
  private KdoDotFilesCommandMaven command;

  private Global global;
  private Dirs dirs;

  @BeforeClass
  public void setUp() {
    global = FakeGlobals.GLOBAL_USER_A;
    dirs = global.getDirs();
  }

  public void command_should_create_dot_files() throws IOException, URISyntaxException {
    File userHome = dirs.getUserHome().getFile();

    EtcFiles.rm_rf(userHome);

    command.execute(global);

    assertThat(readAllLines("/kdo/maven"), equalTo(readAllLines(userHome)));
  }

}