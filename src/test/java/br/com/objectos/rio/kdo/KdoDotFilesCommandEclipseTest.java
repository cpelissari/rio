/*
 * KdoFileCommandEclipse.java criado em 05/09/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import static br.com.objectos.comuns.etc.EtcFiles.readAllLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

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
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class KdoDotFilesCommandEclipseTest {

  @Inject
  private KdoDotFilesCommandEclipse command;

  private Global global;
  private Dirs dirs;

  @BeforeClass
  public void setUp() {
    global = FakeGlobals.GLOBAL_USER_A;
    dirs = global.getDirs();
  }

  public void command_should_create_eclipse_file() throws IOException, URISyntaxException {
    File userHome = dirs.getUserHome().getFile();

    EtcFiles.rm_rf(userHome);

    command.execute(global);

    String res = readAllLines(userHome);

    assertThat(res, not(equalTo("[]")));
    assertThat(res, equalTo("/kdo/eclipse"));
  }

}