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


package com.googlecode.aviator.runtime.function.custom;

import static com.googlecode.aviator.TestUtils.assertEquals;
import static org.junit.Assert.assertSame;
import java.util.HashMap;
import org.junit.BeforeClass;
import org.junit.Test;
import com.googlecode.aviator.AviatorEvaluator;


public class CustomFunctionUnitTest {

  @BeforeClass
  public static void setup() {
    AviatorEvaluator.addFunction(new GetFirstNonNullFunction());
  }


  @Test
  public void testGetFirstNonNullFunctionWith20Params() {
    testGetFirstNonNull(19);
  }


  private void testGetFirstNonNull(int n) {

    HashMap<String, Object> env = new HashMap<String, Object>();
    StringBuilder sb = new StringBuilder("getFirstNonNull(");
    boolean wasFirst = true;
    for (int i = 0; i < n; i++) {
      env.put("i" + i, null);
      if (wasFirst) {
        sb.append("i" + i);
        wasFirst = false;
      } else {
        sb.append(",i" + i);
      }
    }
    Object last = new Object();
    env.put("last", last);
    sb.append(",last)");
    assertSame(last, AviatorEvaluator.execute(sb.toString(), env));
  }


  @Test
  public void testGetFirstNonNullFunctionWith21Params() {
    testGetFirstNonNull(20);
  }


  @Test
  public void testGetFirstNonNullFunctionWith101Params() {
    testGetFirstNonNull(100);
  }


  @Test
  public void testGetFirstNonNullFunctionNestWithManyParams() {
    HashMap<String, Object> env = new HashMap<String, Object>();

    StringBuilder sb = new StringBuilder("getFirstNonNull(");
    boolean wasFirst = true;
    for (int i = 0; i < 30; i++) {
      env.put("i" + i, null);
      if (wasFirst) {
        sb.append("i" + i);
        wasFirst = false;
      } else {
        sb.append(",i" + i);
      }
    }

    sb.append(", getFirstNonNull(");
    wasFirst = true;
    for (int i = 0; i < 30; i++) {
      if (wasFirst) {
        sb.append("i" + i);
        wasFirst = false;
      } else {
        sb.append(",i" + i);
      }
    }
    Object last = new Object();
    env.put("last", last);
    sb.append(",last))");

    System.out.println(sb.toString());

    assertSame(last, AviatorEvaluator.execute(sb.toString(), env));
  }


  @Test
  public void testMyAddFunction() {
    assertEquals(10, AviatorEvaluator.execute("myadd(3,7)"));
    assertEquals(10, AviatorEvaluator.exec("myadd(a,b)", 6, 4));
  }

}
