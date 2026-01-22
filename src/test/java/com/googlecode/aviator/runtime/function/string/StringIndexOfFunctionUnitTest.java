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


package com.googlecode.aviator.runtime.function.string;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;


public class StringIndexOfFunctionUnitTest extends BaseStringFunctionUnitTest {

  @Before
  public void setUp() {
    this.function = new StringIndexOfFunction();
  }


  @Test
  public void testCall() {
    Map<String, Object> env = new HashMap<String, Object>();
    env.put("s1", "hello");
    env.put("s2", "llo");
    env.put("ch", 'l');

    assertEquals(1L, this.function.call(null, new AviatorString("hello"), new AviatorString("ell"))
        .getValue(null));
    assertEquals(2L, this.function.call(env, new AviatorString("hello"), new AviatorJavaType("s2"))
        .getValue(env));
    assertEquals(2L, this.function.call(env, new AviatorString("hello"), new AviatorJavaType("ch"))
        .getValue(env));
    assertEquals(2L, this.function.call(env, new AviatorJavaType("s1"), new AviatorJavaType("s2"))
        .getValue(env));
    assertEquals(2L, this.function.call(env, new AviatorJavaType("s1"), new AviatorJavaType("ch"))
        .getValue(env));
    assertEquals(2L,
        this.function.call(env, new AviatorJavaType("s1"), new AviatorString("llo")).getValue(env));
  }

}
