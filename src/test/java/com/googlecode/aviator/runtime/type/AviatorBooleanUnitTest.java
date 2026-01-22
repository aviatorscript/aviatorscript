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
import org.junit.Test;
import com.googlecode.aviator.exception.ExpressionRuntimeException;


public class AviatorBooleanUnitTest {

  @Test
  public void testAddString() {
    AviatorBoolean aviatorBoolean = AviatorBoolean.valueOf(Boolean.TRUE);
    AviatorString aviatorString = new AviatorString(" is true");
    assertEquals("true is true", aviatorBoolean.add(aviatorString, null).getValue(null));

  }


  @Test
  public void testAddJavaString() {
    AviatorBoolean aviatorBoolean = AviatorBoolean.valueOf(Boolean.TRUE);
    AviatorJavaType aviatorString = new AviatorJavaType("s");
    assertEquals("true is true",
        aviatorBoolean.add(aviatorString, createEnvWith("s", " is true")).getValue(null));

  }


  @Test
  public void testAddJavaChar() {
    AviatorBoolean aviatorBoolean = AviatorBoolean.valueOf(Boolean.TRUE);
    AviatorJavaType aviatorString = new AviatorJavaType("c");
    assertEquals("trueg",
        aviatorBoolean.add(aviatorString, createEnvWith("c", 'g')).getValue(null));

  }


  private Map<String, Object> createEnvWith(String name, Object obj) {
    Map<String, Object> env = new HashMap<String, Object>();
    env.put(name, obj);
    return env;
  }


  @Test(expected = ExpressionRuntimeException.class)
  public void testAddNumber() {
    AviatorBoolean aviatorBoolean = AviatorBoolean.valueOf(Boolean.TRUE);
    aviatorBoolean.add(AviatorNumber.valueOf(1), null);
  }


  @Test(expected = ExpressionRuntimeException.class)
  public void testAddJavaType() {
    AviatorBoolean aviatorBoolean = AviatorBoolean.valueOf(Boolean.TRUE);
    aviatorBoolean.add(new AviatorJavaType("a"), null);
  }


  @Test
  public void testCompareBoolean() {
    AviatorBoolean aviatorBoolean1 = AviatorBoolean.valueOf(Boolean.TRUE);
    AviatorBoolean aviatorBoolean2 = AviatorBoolean.valueOf(Boolean.TRUE);
    AviatorBoolean aviatorBoolean3 = AviatorBoolean.valueOf(Boolean.FALSE);
    AviatorBoolean aviatorBoolean4 = AviatorBoolean.valueOf(Boolean.FALSE);

    assertEquals(0, aviatorBoolean1.innerCompare(aviatorBoolean2, null));
    assertEquals(1, aviatorBoolean1.innerCompare(aviatorBoolean3, null));
    assertEquals(-1, aviatorBoolean3.innerCompare(aviatorBoolean2, null));
    assertEquals(0, aviatorBoolean3.innerCompare(aviatorBoolean4, null));

  }


  @Test
  public void testNot() {
    assertEquals(Boolean.TRUE, AviatorBoolean.FALSE.not(null).getValue(null));
    assertEquals(Boolean.FALSE, AviatorBoolean.TRUE.not(null).getValue(null));
  }


  @Test(expected = ExpressionRuntimeException.class)
  public void testNeg() {
    AviatorBoolean.TRUE.neg(null);
  }


  @Test
  public void testCompareJavaBoolean() {
    AviatorBoolean t = AviatorBoolean.valueOf(Boolean.TRUE);
    AviatorBoolean f = AviatorBoolean.valueOf(Boolean.FALSE);

    AviatorJavaType javaType = new AviatorJavaType("true");
    assertEquals(0, t.innerCompare(javaType, createEnvWith("true", Boolean.TRUE)));
    assertEquals(-1, f.innerCompare(javaType, createEnvWith("true", Boolean.TRUE)));
    // compre to null value
    assertEquals(1, t.innerCompare(new AviatorJavaType("a"), null));
    assertEquals(1, f.innerCompare(new AviatorJavaType("a"), null));
  }


  @Test(expected = ExpressionRuntimeException.class)
  public void testCompareNumber() {
    AviatorBoolean aviatorBoolean = AviatorBoolean.valueOf(Boolean.TRUE);
    aviatorBoolean.innerCompare(AviatorNumber.valueOf(1), null);
  }


  @Test(expected = ExpressionRuntimeException.class)
  public void testCompareJavaType() {
    AviatorBoolean aviatorBoolean = AviatorBoolean.valueOf(Boolean.TRUE);
    aviatorBoolean.innerCompare(new AviatorJavaType("a"), createEnvWith("a", 4.6));
  }
}
