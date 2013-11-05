/*
 * RioModule.java criado em 05/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.rio;

import com.google.inject.AbstractModule;

/**
 * @author cristiane.pelissari@objectos.com.br (Cristiane Iope Pelissari)
 */
class RioModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new RioCliModule());
  }

}