/*
 * TesteDeExtrairString.java criado em 07/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
public class TesteDeExtrairString {

  public void verifica_extrair_conteudo_passado_arquivo() throws IOException, URISyntaxException {
    String path = "/home/cpelissari/kdo/projetos/rio/src/test/resources/kdo/git/gitProva";
    File teste = new File(path);

    String res = extraiConteudo(teste);

    assertThat(res, equalTo("[user]"));

    String resName = extraiConteudo(path);
  }

  private String extraiConteudo(File res) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(res));
    String conteudo = null;

    while (br.ready()) {
      conteudo = br.readLine();
    }

    br.close();
    return conteudo;
  }

  private String extraiConteudo(String provaFile) throws IOException, URISyntaxException {

    BufferedReader br = new BufferedReader(new FileReader(provaFile.toString()));
    String conteudo = null;

    while (br.ready()) {
      conteudo = br.readLine();
    }
    br.close();
    return conteudo;
  }

}