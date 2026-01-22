/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 **/


package com.googlecode.aviator.example.module;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.annotation.Import;

/**
 * Custom java module example.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class JavaModuleExample {

  @Import(ns = "str")
  public static class StringModule {
    public static boolean isBlank(final String s) {
      return s == null || s.trim().length() == 0;
    }
  }

  public static void main(final String[] args) throws Exception {

    AviatorEvaluator.getInstance().addModule(StringModule.class);

    String script = "let str = require('str'); str.isBlank(s) ";

    System.out.println(AviatorEvaluator.execute(script, AviatorEvaluator.newEnv("s", "hello")));
    System.out.println(AviatorEvaluator.execute(script, AviatorEvaluator.newEnv("s", " ")));
    System.out.println(AviatorEvaluator.execute(script, AviatorEvaluator.newEnv("s", null)));
  }
}
