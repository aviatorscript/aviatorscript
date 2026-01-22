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


package com.googlecode.aviator.runtime.function.seq;

import static com.googlecode.aviator.TestUtils.assertEquals;
import java.util.HashSet;
import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;


public class SeqCountFunctionUnitTest {

  @Test
  public void testCount_Array() {
    AviatorObject[] args = new AviatorObject[1];
    args[0] = AviatorRuntimeJavaType.valueOf(new String[10]);
    SeqCountFunction fun = new SeqCountFunction();
    AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf(new String[10]));
    assertEquals(10, result.getValue(null));
  }


  @Test
  public void testCount_EmptyArray() {

    SeqCountFunction fun = new SeqCountFunction();
    AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf(new String[0]));
    assertEquals(0, result.getValue(null));
  }


  @Test
  public void testCount_Collection() {
    final HashSet<Integer> set = new HashSet<Integer>();
    set.add(1);
    set.add(2);

    SeqCountFunction fun = new SeqCountFunction();
    AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf(set));
    assertEquals(2, result.getValue(null));
  }


  @Test
  public void testCount_String() {
    SeqCountFunction fun = new SeqCountFunction();
    AviatorObject result = fun.call(null, AviatorRuntimeJavaType.valueOf("hello"));
    assertEquals(5, result.getValue(null));
  }

}
