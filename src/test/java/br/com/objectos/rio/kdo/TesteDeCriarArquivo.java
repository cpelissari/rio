/*
 * TesteDeCriarArquivo.java criado em 08/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
public class TesteDeCriarArquivo {

  public void verifica_criacao_arquivo() throws IOException, URISyntaxException {
    String dir = "/home/cpelissari/kdo/projetos/rio/src/test/resources/kdo/git/gitProva10";

    File file = criarArquivo(dir);
    assertTrue(file.exists());
  }

  private File criarArquivo(String dir) throws IOException,
      URISyntaxException {

    File fakeFile = new File(dir);
    fakeFile.createNewFile();

    return fakeFile;
  }

}