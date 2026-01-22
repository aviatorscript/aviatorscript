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
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;


public class NowFunctionUnitTest {

  @Test
  public void testCall() {
    NowFunction now = new NowFunction();
    AviatorLong aviatorLong = (AviatorLong) now.call(null);

    assertEquals(System.currentTimeMillis(), (Long) aviatorLong.getValue(null), 5);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testCall_WithOneArgument() {
    NowFunction now = new NowFunction();
    now.call(null, AviatorRuntimeJavaType.valueOf(1));
  }

}
