/*
 * RioKdoArquivo.java criado em 06/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
public class RioKdoArquivo {

  public File criarArquivo(String nome, String email, String dir) throws IOException,
      URISyntaxException {

    File fakeFile = new File(dir);

    fakeFile.mkdirs();

    return fakeFile;
  }

}