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


package com.googlecode.aviator.runtime.function.math;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorNumber;


public class MathTanFunctionUnitTest extends BaseMathFunctionUnitTestForOneArgument {
  @Before
  public void setUp() {
    this.function = new MathTanFunction();
  }


  @Test
  public void testCall() {
    assertEquals(Math.tan(30), this.function.call(null, AviatorNumber.valueOf(30)).getValue(null));
    assertEquals(Math.tan(1020.999),
        this.function.call(null, AviatorNumber.valueOf(1020.999)).getValue(null));
    assertEquals(Math.tan(400),
        this.function.call(null, AviatorNumber.valueOf(400)).getValue(null));

    Map<String, Object> env = new HashMap<String, Object>();
    env.put("a", 10000);
    env.put("b", 9.0);

    assertEquals(Math.tan(10000), this.function.call(env, new AviatorJavaType("a")).getValue(null));
    assertEquals(Math.tan(9.0), this.function.call(env, new AviatorJavaType("b")).getValue(null));
  }

}
