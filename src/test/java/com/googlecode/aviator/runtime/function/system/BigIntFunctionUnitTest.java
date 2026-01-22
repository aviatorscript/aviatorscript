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


package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.type.AviatorJavaType;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;


public class BigIntFunctionUnitTest {
  @Test(expected = ClassCastException.class)
  public void testCall_WithJavaTypeNullArgument() {
    BigIntFunction bigIntFunction = new BigIntFunction();
    AviatorJavaType aviatorJavaType = new AviatorJavaType("var");
    bigIntFunction.call(null, aviatorJavaType);
  }

  @Test(expected = ClassCastException.class)
  public void testCall_WithJavaTypeNotSupportArgument() {
    BigIntFunction bigIntFunction = new BigIntFunction();
    AviatorJavaType aviatorJavaType = new AviatorJavaType("var");
    Map<String, Object> env = new HashMap<>();
    env.put("var", true);

    bigIntFunction.call(env, aviatorJavaType);
  }
}
