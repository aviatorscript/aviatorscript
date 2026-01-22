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



package com.googlecode.aviator.runtime.type;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;
import com.googlecode.aviator.exception.ExpressionRuntimeException;


public class AviatorNilUnitTest {
  // Any object is greater than nil except nil
  @Test
  public void testCompare() {
    assertEquals(0, AviatorNil.NIL.innerCompare(AviatorNil.NIL, null));

    Map<String, Object> env = new HashMap<String, Object>();
    env.put("a", null);
    env.put("i", 1);
    env.put("f", 3.14f);
    env.put("d", -100.0);
    env.put("ch", 'a');
    env.put("s", "hello");
    assertEquals(0, AviatorNil.NIL.innerCompare(AviatorNil.NIL, null));
    assertEquals(0, AviatorNil.NIL.innerCompare(new AviatorJavaType("a"), env));
    assertEquals(0, new AviatorJavaType("a").innerCompare(AviatorNil.NIL, env));

    assertEquals(1, AviatorNumber.valueOf(1).innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(AviatorNumber.valueOf(1), env));
    assertEquals(1, AviatorNumber.valueOf(-1000).innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(AviatorNumber.valueOf(-1000), env));
    assertEquals(1, AviatorBoolean.TRUE.innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(AviatorBoolean.TRUE, env));
    assertEquals(1, AviatorBoolean.FALSE.innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(AviatorBoolean.FALSE, env));
    assertEquals(1, new AviatorString("").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorString(""), env));
    assertEquals(1, new AviatorString(" ").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorString(" "), env));
    assertEquals(1, new AviatorString("hello").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorString("hello"), env));
    assertEquals(1, new AviatorString("-100").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorString("-100"), env));
    assertEquals(1, new AviatorPattern("\\d+").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorPattern("\\d+"), env));
    assertEquals(1, new AviatorPattern("[\\w_]+\\.[\\w_]").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorPattern("[\\w_]+\\.[\\w_]"), env));

    assertEquals(1, new AviatorJavaType("i").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorJavaType("i"), env));

    assertEquals(1, new AviatorJavaType("f").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorJavaType("f"), env));

    assertEquals(1, new AviatorJavaType("d").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorJavaType("d"), env));

    assertEquals(1, new AviatorJavaType("ch").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorJavaType("ch"), env));

    assertEquals(1, new AviatorJavaType("s").innerCompare(AviatorNil.NIL, env));
    assertEquals(-1, AviatorNil.NIL.innerCompare(new AviatorJavaType("s"), env));
  }


  @Test
  public void testAddString() {
    assertEquals("null", AviatorNil.NIL.add(new AviatorString(""), null).getValue(null));
    assertEquals("null hello",
        AviatorNil.NIL.add(new AviatorString(" hello"), null).getValue(null));

    try {
      AviatorNil.NIL.add(new AviatorJavaType("a"), null);
      Assert.fail();
    } catch (ExpressionRuntimeException e) {

    }
    Map<String, Object> env = new HashMap<String, Object>();
    env.put("a", " hello");
    assertEquals("null hello", AviatorNil.NIL.add(new AviatorJavaType("a"), env).getValue(env));
  }
}
