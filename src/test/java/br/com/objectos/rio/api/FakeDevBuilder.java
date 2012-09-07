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

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class FakeDevBuilder implements Dev.Builder {

  private int uid;
  private String login;
  private final List<String> groups = newArrayList();

  private String name;
  private String email;

  private boolean active = true;

  @Override
  public Dev build() {
    return new Dev(this);
  }

  public FakeDevBuilder uid(int uid) {
    this.uid = uid;
    return this;
  }

  public FakeDevBuilder login(String login) {
    this.login = login;
    return this;
  }

  public FakeDevBuilder group(String group) {
    this.groups.add(group);
    return this;
  }

  public FakeDevBuilder name(String name) {
    this.name = name;
    return this;
  }

  public FakeDevBuilder email(String email) {
    this.email = email;
    return this;
  }

  public FakeDevBuilder inactive() {
    this.active = false;
    return this;
  }

  @Override
  public int getUid() {
    return uid;
  }

  @Override
  public String getLogin() {
    return login;
  }

  @Override
  public List<String> getGroups() {
    return groups;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public boolean isActive() {
    return active;
  }

}