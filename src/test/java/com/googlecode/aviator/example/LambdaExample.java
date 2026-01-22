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


package com.googlecode.aviator.example;

import java.util.HashMap;
import java.util.Map;
import com.googlecode.aviator.AviatorEvaluator;

public class LambdaExample {

  public static void main(String[] args) {

    String exp = "a=1; b = lambda(x) -> a+ x end ; a=4 ; b(5)";
    System.out.println(AviatorEvaluator.execute(exp)); // output 6


    Map<String, Object> env = new HashMap<String, Object>();
    env.put("x", 1);
    env.put("y", 2);
    env.put("z", 3);

    AviatorEvaluator.defineFunction("test",
        "lambda(x) -> lambda(y) -> lambda(z) -> x + y + z end end end");
    System.out.println(AviatorEvaluator.execute("test(4)(5)(6)", env)); // output 15

    env.put("a", 4);
    System.out.println(AviatorEvaluator.execute("test(4)(5)(6) + a", env)); // output 19
  }
}
