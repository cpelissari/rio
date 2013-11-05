/*
 * MainTest.java criado em 01/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.comuns.cli.Executor;
import br.com.objectos.rio.KdoInitOptions;
import br.com.objectos.rio.RioTestModule;

import com.beust.jcommander.JCommander;
import com.google.inject.Inject;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class MainTest {

  private static RioKdo rio;

  private final Executor executor;

  @Inject
  public MainTest(RioKdo rio, Executor executor) {
    this.rio = rio;
    this.executor = executor;
  }

  public static void main(String[] args) {
    JCommander jc = new JCommander();
    KdoInitOptions options = new KdoInitOptions();
    jc.addCommand("--git", options.getOptionGit());
    jc.parse(args[0]);
    rio.criaInstancia(args);

    System.out.println("classe retornada com sucesso" + "Parâmetro = " + jc.getParsedCommand());
  }

}