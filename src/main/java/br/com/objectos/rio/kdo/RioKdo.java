/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.rio.kdo;

import br.com.objectos.comuns.cli.Executor;
import br.com.objectos.rio.RioCliModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class RioKdo {

  private final Executor executor;

  @Inject
  public RioKdo(Executor command) {
    this.executor = command;
  }

  // método que será executado na classe principal
  // Cria injeções para o módulo
  // recebe a instância da classe com injeção de dependências pronta
  // essa instancia chama o método run passando um array de strings como
  // parâmetro
  // o execute é implementado pelo ExecutorGuice que transforma o parâmetro num
  // Arg(ImmutableList)
  // verificar defaultMainCommandKey e o código de ExecutorGuice para criar o
  // teste -> verificar se está vazio? help(HelpCommand)?, instanciou a classe
  // correta?
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new RioCliModule());
    RioKdo instance = injector.getInstance(RioKdo.class);
    instance.run(args);
  }

  private void run(String[] args) {
    executor.execute(args);
  }

}