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

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;

public class JavaReflectionFunctionMissingExample {
  public static void main(final String[] args) {
    // Enable function missing based on java instance methods reflection.
    AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
    // Calling String#indexOf by reflection
    System.out.println(AviatorEvaluator.execute("indexOf('hello world', 'w')"));
    // Calling Long#floatValue by reflection
    System.out.println(AviatorEvaluator.execute("floatValue(3)"));
    // Calling BigDecimal#add
    System.out.println(AviatorEvaluator.execute("add(3M, 4M)"));
  }
}
