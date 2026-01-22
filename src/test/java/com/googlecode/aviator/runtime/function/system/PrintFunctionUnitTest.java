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
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;


public class PrintFunctionUnitTest {
  private PrintFunction fun;
  PrintStream systemOut;


  @Before
  public void setUp() {
    this.fun = new PrintFunction();
    this.systemOut = System.out;
  }


  @After
  public void tearDown() {
    System.setOut(this.systemOut);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testCall_WithEmpyArguments() throws Exception {
    this.fun.call(null);
  }


  @Test
  public void testCall_WithOneArgument() throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    this.fun.call(null, new AviatorString("hello"));
    out.flush();
    out.close();
    byte[] data = out.toByteArray();
    assertEquals("hello", new String(data));

  }


  @Test
  public void testCall_WithTwoArgument() throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Map<String, Object> env = new HashMap<String, Object>();
    env.put("out", out);
    this.fun.call(env, new AviatorJavaType("out"), new AviatorString("hello"));
    out.flush();
    out.close();
    byte[] data = out.toByteArray();
    assertEquals("hello", new String(data));

  }


  @Test(expected = IllegalArgumentException.class)
  public void testCall_WithFourArgument() throws Exception {
    this.fun.call(null, AviatorRuntimeJavaType.valueOf(0), AviatorRuntimeJavaType.valueOf(0),
        AviatorRuntimeJavaType.valueOf(0), AviatorRuntimeJavaType.valueOf(0));

  }

}
