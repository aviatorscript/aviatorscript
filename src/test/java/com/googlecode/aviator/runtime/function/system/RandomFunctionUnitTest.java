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


package com.googlecode.aviator.runtime.function.system;

import static org.junit.Assert.*;
import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;


public class RandomFunctionUnitTest {

  @Test
  public void testCall() {
    RandomFunction rand = new RandomFunction();
    AviatorObject result = rand.call(null);
    assertTrue(result instanceof AviatorDouble);
    assertFalse(result.getValue(null).equals(rand.call(null)));
  }


  public void testCallWithOneArg() {
    RandomFunction rand = new RandomFunction();
    AviatorObject result = rand.call(null, AviatorRuntimeJavaType.valueOf(1));
    assertTrue(((Integer) result.getValue(null)) < 1);
    assertTrue(((Integer) result.getValue(null)) >= 0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testCallIllegalArgument() {
    RandomFunction rand = new RandomFunction();
    AviatorObject result =
        rand.call(null, AviatorRuntimeJavaType.valueOf(1), AviatorRuntimeJavaType.valueOf(2));
  }
}
