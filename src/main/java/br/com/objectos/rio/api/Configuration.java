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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Configuration {

  public static interface Builder extends br.com.objectos.comuns.base.Builder<Configuration> {

    Dirs getDirs();

  }

  private final Dirs dirs;

  private Configuration(Builder builder) {
    dirs = builder.getDirs();
  }

  public static ConfigurationBuilder builder() {
    return new ConfigurationBuilder();
  }

  public Dirs getDirs() {
    return dirs;
  }

  public static class ConfigurationBuilder implements Builder {

    @Override
    public Configuration build() {
      return new Configuration(this);
    }

    @Override
    public Dirs getDirs() {
      return null;
    }

  }

}