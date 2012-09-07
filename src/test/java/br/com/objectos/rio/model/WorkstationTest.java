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

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import br.com.objectos.comuns.etc.Config;
import br.com.objectos.comuns.etc.EtcFiles;
import br.com.objectos.rio.RioTestModule;
import br.com.objectos.rio.api.model.Workstation;
import br.com.objectos.rio.api.model.Workstations;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class WorkstationTest {

  @Inject
  private Provider<Config> configProvider;

  public void write() throws IOException {
    List<Workstation> all = FakeWorkstations.getAll();
    Workstations devs = new Workstations(all);

    String expect = EtcFiles.readLines("/var/lib/objectos/rio/workstation");
    System.out.println(expect);

    Config config = configProvider.get();
    String res = config.toString(devs);
    System.out.println(res);

    assertThat(res, equalTo(expect));
  }

  public void read() throws IOException {
    List<Workstation> all = FakeWorkstations.getAll();
    List<String> expected = transform(all, new WorkstationToString());

    String data = EtcFiles.readLines("/var/lib/objectos/rio/workstation");

    Config config = configProvider.get();
    List<Workstation> devs = config.loadAll(data, Workstation.class);
    List<String> res = transform(devs, new WorkstationToString());

    assertThat(res, equalTo(expected));
  }

  private static class WorkstationToString implements Function<Workstation, String> {
    @Override
    public String apply(Workstation input) {
      return Objects.toStringHelper(input)
          .addValue(input.getIp())
          .addValue(input.getName())
          .toString();
    }
  }

}
