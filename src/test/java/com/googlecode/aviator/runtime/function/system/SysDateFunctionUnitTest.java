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
import java.util.Date;
import org.junit.Test;
import com.googlecode.aviator.runtime.function.system.SysDateFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;


public class SysDateFunctionUnitTest {
  @Test
  public void testCall() {
    SysDateFunction fun = new SysDateFunction();

    AviatorObject result = fun.call(null);
    assertNotNull(result);
    assertTrue(result.getValue(null) instanceof Date);
  }


  @Test(expected = IllegalArgumentException.class)
  public void hasArugment() {
    SysDateFunction fun = new SysDateFunction();
    fun.call(null, AviatorBoolean.TRUE);

  }
}
