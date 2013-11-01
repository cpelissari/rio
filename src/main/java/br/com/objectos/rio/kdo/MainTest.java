/*
 * MainTest.java criado em 01/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import br.com.objectos.rio.KdoInitOptions;

import com.beust.jcommander.JCommander;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
public class MainTest {

  public static void main(String[] args) {
    KdoInitOptions options = new KdoInitOptions();

    JCommander jc = new JCommander(options.getPrefix());
    jc.addCommand("--git", options.getOptionGit());

    jc.parse(args);
    System.out.println(jc.getMainParameterDescription());
  }

}