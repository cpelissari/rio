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

import java.lang.annotation.Annotation;

import br.com.objectos.comuns.cli.AbstractMainCommand;

import com.google.inject.Injector;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
// deixar como defaut e colocar no package correto
public class KdoCommand extends AbstractMainCommand {

  public static final String NAME = "kdo";

  public KdoCommand(Injector injector) {
    super(injector);
  }

  @Override
  public Class<? extends Annotation> getAnnotation() {
    return Kdo.class;
  }

  @Override
  public String getName() {
    return NAME;
  }

}