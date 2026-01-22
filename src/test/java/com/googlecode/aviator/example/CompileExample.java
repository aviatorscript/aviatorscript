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
import com.googlecode.aviator.Expression;

public class CompileExample {
  public static void main(String[] args) {
    String expression = "a-(b-c)>100";
    // 编译表达式
    Expression compiledExp = AviatorEvaluator.compile(expression);

    Map<String, Object> env = new HashMap<String, Object>();
    env.put("a", 100.3);
    env.put("b", 45);
    env.put("c", -199.100);

    // 执行表达式
    Boolean result = (Boolean) compiledExp.execute(env);
    System.out.println(result);
  }
}
