/*
 * KdoDotFileEscapeCharacter.java criado em 05/09/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.cli.kdo;

import static br.com.objectos.comuns.etc.EtcFiles.readAllLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.mvel2.CompileException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.comuns.etc.EtcFiles;
import br.com.objectos.comuns.etc.io.BaseDirFileFilter;
import br.com.objectos.comuns.etc.io.Templates;
import br.com.objectos.comuns.etc.model.Dir;
import br.com.objectos.comuns.etc.model.Dirs;
import br.com.objectos.comuns.etc.model.FakeGlobals;
import br.com.objectos.comuns.etc.model.Global;
import br.com.objectos.rio.RioTestModule;

import com.google.common.io.Resources;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class KdoDotFilesEscapeCharacterTest {

  private Global global;
  private Dirs dirs;

  @BeforeClass
  public void setUp() {
    global = FakeGlobals.GLOBAL_USER_A;
    dirs = global.getDirs();
  }

  @Test(expectedExceptions = CompileException.class)
  public void command_should_throw_exception_when_accessing_non_existent_field()
      throws IOException, URISyntaxException {
    Dir userDir = dirs.getUserHome();
    File userHome = userDir.getFile();

    EtcFiles.rm_rf(userHome);

    BaseDirFileFilter filter = new BaseDirFileFilter(userHome);

    Templates
        .foundAtBaseDir(templateBaseDir("/fake-templates/escape/error"))
        .filterFilesWith(filter)
        .withModel(global)
        .build()
        .parseAll();

    assertThat(readAllLines("/fake-templates/escape/expected"), equalTo(readAllLines(userHome)));
  }

  public void command_should_use_escape_character() throws IOException,
      URISyntaxException {
    Dir userDir = dirs.getUserHome();
    File userHome = userDir.getFile();

    EtcFiles.rm_rf(userHome);

    parse();

    assertThat(readAllLines("/fake-templates/escape/expected"), equalTo(readAllLines(userHome)));
  }

  private void parse() throws URISyntaxException {
    Dir userDir = dirs.getUserHome();
    File userHome = userDir.getFile();

    BaseDirFileFilter filter = new BaseDirFileFilter(userHome);

    Templates
        .foundAtBaseDir(templateBaseDir("/fake-templates/escape/correct"))
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