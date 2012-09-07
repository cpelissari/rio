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

import java.util.List;

import br.com.objectos.rio.api.model.Workstation;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class FakeWorkstations {

  public static final Workstation WORKSTATION_001 = start()
      .ip("10.0.0.101")
      .name("estacao001")
      .build();

  public static final Workstation WORKSTATION_002 = start()
      .ip("10.0.0.102")
      .name("estacao002")
      .build();

  public static final Workstation WORKSTATION_003 = start()
      .ip("10.0.0.103")
      .name("estacao003")
      .build();

  private static final List<Workstation> all = ImmutableList
      .<Workstation> builder()
      .add(WORKSTATION_001)
      .add(WORKSTATION_002)
      .add(WORKSTATION_003)
      .build();

  public static List<Workstation> getAll() {
    return all;
  }

  FakeWorkstations() {
  }

  private static FakeWorkstationBuilder start() {
    return new FakeWorkstationBuilder();
  }

}