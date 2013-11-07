/*
 * RioKdoTesteArquivo.java criado em 06/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.rio.RioTestModule;

import com.google.common.io.Resources;
import com.google.inject.Inject;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class RioKdoTesteArquivo {

  @Inject
  private RioKdoArquivo rioKdoArquivo;

  public void deve_criar_arquivo() throws IOException, URISyntaxException {
    String nome = "user_A";
    String email = "user@a.objectos.com.br";
    String dir = "/tmp/usera/arquivoGit";

    File res = rioKdoArquivo.criarArquivo(nome, email, dir);

    boolean sucesso = res.createNewFile();
    assertTrue(sucesso);

    assertTrue(res.exists());

    String provaFile = "/kdo/git/gitTeste";

    String provaConteudo = extraiConteudo(provaFile);
    String resConteudo = extraiConteudo(res);

    assertThat(provaConteudo, equalTo(resConteudo));

    String resNome = res.getAbsoluteFile().getName();

    assertThat(resNome, equalTo("giiittt"));

    assertThat(res.getPath(), equalTo(dir));
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
    URL url = Resources.getResource(getClass(), provaFile);

    BufferedReader br = new BufferedReader(new FileReader(url.toString()));
    String conteudo = null;

    while (br.ready()) {
      conteudo = br.readLine();
    }
    br.close();
    return conteudo;
  }

}
