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

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
@Guice(modules = { RioTestModule.class })
public class DevTest {

  @Inject
  private Provider<Config> configProvider;

  public void write() throws IOException {
    List<Dev> all = FakeDevs.getAll();
    Devs devs = new Devs(all);

    String expect = EtcFiles.readLines("/var/lib/objectos/rio/dev");
    System.out.println(expect);

    Config config = configProvider.get();
    String res = config.toString(devs);
    System.out.println(res);

    assertThat(res, equalTo(expect));
  }

  public void read() throws IOException {
    List<Dev> all = FakeDevs.getAll();
    List<String> expected = transform(all, new DevToString());

    String data = EtcFiles.readLines("/var/lib/objectos/rio/dev");

    Config config = configProvider.get();
    List<Dev> devs = config.loadAll(data, Dev.class);
    List<String> res = transform(devs, new DevToString());

    assertThat(res, equalTo(expected));
  }

  private static class DevToString implements Function<Dev, String> {
    @Override
    public String apply(Dev input) {
      return Objects.toStringHelper(input)
          .addValue(input.getUid())
          .addValue(input.getLogin())
          .addValue(input.getGroups())
          .addValue(input.getName())
          .addValue(input.getEmail())
          .addValue(input.isActive())
          .toString();
    }
  }

}