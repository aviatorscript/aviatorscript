/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/


package com.googlecode.aviator.example;

import java.util.Map;
import com.googlecode.aviator.AviatorEvaluator;


public class TernaryOperatorExample {
  public static void main(final String[] args) {
    if (args.length < 1) {
      System.err.println("Usage: java TernaryOperatorExample [number]");
      System.exit(1);
    }
    int num = Integer.parseInt(args[0]);
    Map<String, Object> env = AviatorEvaluator.newEnv("a", num);
    String result = (String) AviatorEvaluator.execute("a>0? 'yes':'no'", env);
    System.out.println(result);
  }
}
