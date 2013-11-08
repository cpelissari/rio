/*
 * TesteDeCriarArquivoConteudoVariavel.java criado em 08/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;

import org.testng.annotations.Test;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
public class TesteDeCriarArquivoConteudoVariavel {

  public void verifica_criacao_arquivo() throws IOException, URISyntaxException {
    String nome = "user_A";
    String email = "user@a.objectos.com.br";
    String dir = "/home/cpelissari/kdo/projetos/rio/src/test/resources/kdo/git/gitProva1";

    File file = criarArquivo(nome, email, dir);
    assertTrue(file.isFile());
  }

  private File criarArquivo(String nome, String email, String dir) throws IOException,
      URISyntaxException {

    File fakeFile = new File(dir);
    fakeFile.createNewFile();
    Formatter formato = new Formatter();

    formato.format("[user]\n", nome, email);

    BufferedWriter br = new BufferedWriter(new FileWriter(fakeFile));
    br.write(nome + email);

    them
    br.close();

    return fakeFile;
  }
}