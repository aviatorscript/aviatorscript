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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Map;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;


public class BigNumberExample {

  public static void main(final String[] args) {
    Object rt = AviatorEvaluator.execute("9223372036854775807100.356M * 2");
    System.out.println(rt + "  " + rt.getClass());

    rt = AviatorEvaluator.execute("92233720368547758074+1000");
    System.out.println(rt + "  " + rt.getClass());

    BigInteger a = new BigInteger(String.valueOf(Long.MAX_VALUE) + String.valueOf(Long.MAX_VALUE));
    BigDecimal b = new BigDecimal("3.2");
    BigDecimal c = new BigDecimal("9999.99999");

    Map<String, Object> env = AviatorEvaluator.newEnv("a", a, "b", b, "c", c);

    rt = AviatorEvaluator.execute("a+10000000000000000000", env);
    System.out.println(rt + "  " + rt.getClass());

    rt = AviatorEvaluator.execute("b+c*2", env);
    System.out.println(rt + "  " + rt.getClass());

    rt = AviatorEvaluator.execute("a*b/c", env);
    System.out.println(rt + "  " + rt.getClass());

    // set math context
    AviatorEvaluator.setOption(Options.MATH_CONTEXT, MathContext.DECIMAL64);
    rt = AviatorEvaluator.execute("a*b/c", env);
    System.out.println(rt + "  " + rt.getClass());
  }
}
