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
package br.com.objectos.rio.api.model;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Workstation {

  public static interface Builder extends br.com.objectos.comuns.base.Builder<Workstation> {

    String getIp();
    String getName();

  }

  private String ip;
  private String name;

  public Workstation() {
  }

  public Workstation(Builder builder) {
    this.ip = builder.getIp();
    this.name = builder.getName();
  }

  public String getIp() {
    return ip;
  }

  public String getName() {
    return name;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public void setName(String name) {
    this.name = name;
  }

}