/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.rio.model;

import br.com.objectos.rio.api.model.Workstation;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class FakeWorkstationBuilder implements Workstation.Builder {

  private String ip;
  private String name;

  @Override
  public Workstation build() {
    return new Workstation(this);
  }

  public FakeWorkstationBuilder ip(String ip) {
    this.ip = ip;
    return this;
  }

  public FakeWorkstationBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String getIp() {
    return ip;
  }

  @Override
  public String getName() {
    return name;
  }

}