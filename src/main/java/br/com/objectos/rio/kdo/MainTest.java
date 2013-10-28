package br.com.objectos.rio.kdo;

/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */

@Test
public class MainTest {

  public static void main(String[] args) {
    System.out.println("Teste");
  }
  /*
  private Executor executor;

  private String executedCommand;
  
  @BeforeMethod
  public void reset() {
    executedCommand = null;
  }

  public void should_execute_args_command() {

    String command = "git";

    executor.execute("rio", "kdo", "dots", "--", command);
    assertThat(executedCommand, equalTo(command));
  }

  private class FakeMainCommand extends EmptyMainCommand {

      private final String command;

      public FakeMainCommand(String command) {
        this.command = command;
      }

      @Override
      public void execute(Args args) {
        executedCommand = command;
      }

    }*/
}