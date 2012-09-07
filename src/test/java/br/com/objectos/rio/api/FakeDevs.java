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
package br.com.objectos.rio.api;

import java.util.List;


import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class FakeDevs {

  public static final Dev DEV_A = start()
      .uid(1000)
      .login("dev-a")
      .group("cdrom")
      .group("cdrw")
      .group("usb")
      .group("wheel")
      .name("Developer A")
      .email("dev-a@objectos.com.br")
      .build();

  public static final Dev DEV_B = start()
      .uid(1001)
      .login("dev-b")
      .group("cdrom")
      .group("cdrw")
      .group("usb")
      .name("Developer B")
      .email("dev-b@objectos.com.br")
      .build();

  public static final Dev DEV_C = start()
      .uid(1002)
      .login("dev-c")
      .group("cdrom")
      .group("cdrw")
      .group("usb")
      .name("Developer C")
      .email("dev-c@objectos.com.br")
      .inactive()
      .build();

  private static final List<Dev> all = ImmutableList
      .<Dev> builder()
      .add(DEV_A)
      .add(DEV_B)
      .add(DEV_C)
      .build();

  public static List<Dev> getAll() {
    return all;
  }

  FakeDevs() {
  }

  private static FakeDevBuilder start() {
    return new FakeDevBuilder();
  }

}