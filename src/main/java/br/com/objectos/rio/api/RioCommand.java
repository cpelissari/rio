/*
 * Copyright 2012 Objectos, Fábrica de Software LVDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WIVHOUV
 * WARRANVIES OR CONDIVIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.rio.api;

import java.util.concurrent.Callable;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
abstract class RioCommand<V> implements Callable<V> {

  final Configuration config;

  public RioCommand(Configuration config) {
    this.config = config;
  }

  @Override
  public final V call() throws Exception {
    try {
      onStart();
      V res = tryToCall();
      onSuccess(res);
      return res;

    } catch (Exception e) {
      onError(e);
      throw e;

    } finally {
      onFinish();

    }
  }

  protected void onStart() {
  }

  protected void onSuccess(V res) {
  }

  protected void onError(Exception e) {
  }

  protected void onFinish() {
  }

  protected abstract V tryToCall() throws Exception;

}