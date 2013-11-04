/*
 * KdoFileCommandEclipse.java criado em 05/09/2012
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;


/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
/*@Test
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

}*/