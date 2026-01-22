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

import org.springframework.util.StringUtils;
import com.googlecode.aviator.AviatorEvaluator;

public class JavaMethodFunctionsExample {

  public static void main(final String[] args) throws Exception {
    // Import string's instance methods as custom functions under namespace 's'.
    AviatorEvaluator.addInstanceFunctions("s", String.class);
    AviatorEvaluator.execute("println(s.indexOf('hello', 'l'))");
    AviatorEvaluator.execute("println(s.replaceAll('hello', 'l', 'x'))");

    // Import StringUtils static methods as custom functions under namespace 'sutil'.
    AviatorEvaluator.addStaticFunctions("sutil", StringUtils.class);
    System.out.println(AviatorEvaluator.execute("sutil.isEmpty('hello')"));
    System.out.println(AviatorEvaluator.execute("sutil.isEmpty('')"));
  }
}
