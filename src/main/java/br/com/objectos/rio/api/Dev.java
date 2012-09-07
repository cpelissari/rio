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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Dev {

  public static interface Builder extends br.com.objectos.comuns.base.Builder<Dev> {

    int getUid();
    String getLogin();
    List<String> getGroups();

    String getName();
    String getEmail();

    boolean isActive();

  }

  private int uid;
  private String login;
  private List<String> groups;

  private String name;
  private String email;

  private boolean active;

  public Dev() {
  }

  public Dev(Builder builder) {
    this.uid = builder.getUid();
    this.login = builder.getLogin();
    this.groups = builder.getGroups();
    this.name = builder.getName();
    this.email = builder.getEmail();
    this.active = builder.isActive();
  }

  public int getUid() {
    return uid;
  }

  public String getLogin() {
    return login;
  }

  public List<String> getGroups() {
    return groups;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public boolean isActive() {
    return active;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setGroups(List<String> groups) {
    this.groups = groups;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}