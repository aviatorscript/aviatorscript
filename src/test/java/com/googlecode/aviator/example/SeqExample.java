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


public class SeqExample {

  public static void main(final String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < 10; i++) {
      a[i] = i;
    }

    Map<String, Object> env = AviatorEvaluator.newEnv("a", a);

    System.out.println(AviatorEvaluator.execute("a[1] + 100", env));
    System.out.println(AviatorEvaluator.execute("'a[1]=' + a[1]", env));
    System.out.println(AviatorEvaluator.execute("count(a)", env));
    System.out.println(AviatorEvaluator.execute("reduce(a,+,0)", env));
    System.out.println(AviatorEvaluator.execute("seq.every(a,seq.gt(0))", env));
    System.out
        .println(AviatorEvaluator.execute("seq.every(a,seq.and(seq.ge(0), seq.lt(10)))", env));
    System.out
        .println(AviatorEvaluator.execute("seq.not_any(a,seq.and(seq.ge(0), seq.lt(10)))", env));
    System.out
        .println(AviatorEvaluator.execute("seq.not_any(a,seq.and(seq.lt(0), seq.ge(10)))", env));
    System.out.println(AviatorEvaluator.execute("seq.some(a,seq.eq(3))", env));
    System.out.println(AviatorEvaluator.execute("seq.some(a, lambda(x) -> x > 10 end)", env));
  }
}
