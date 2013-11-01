/*
 * RioKdoTeste.java criado em 31/10/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio.kdo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.rio.RioTestModule;

import com.google.inject.Inject;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class RioKdoTeste {

  @Inject
  private RioKdo rioKdo;

  // teste -> verificar se está vazio? help(HelpCommand)?, instanciou a classe
  // correta?

  public void deve_instanciar_classe_correta() {
    String command = "kdo";
    String arg0 = "dots";
    String arg1 = "git";

    String[] args = new String[] { command, arg0, arg1 };

    KdoDotFileCommandGit prova = new KdoDotFileCommandGit();
    Object res = rioKdo.CriaInstancia(args);

    assertTrue(res.getClass().equals(KdoDotFileCommandGit.class));
  }

}