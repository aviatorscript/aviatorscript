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


package com.googlecode.aviator.runtime.function.string;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;
import static org.junit.Assert.*;


public class StringSplitJointFunctionUnitTest {

  @Test
  public void testSplitJoin() {
    StringSplitFunction splitFn = new StringSplitFunction();
    StringJoinFunction joinFn = new StringJoinFunction();

    assertEquals("string.split", splitFn.getName());
    assertEquals("string.join", joinFn.getName());

    String[] tmps = (String[]) splitFn
        .call(null, new AviatorString("a,b,c,d,e,f,g"), new AviatorString(",")).getValue(null);

    assertNotNull(tmps);
    assertEquals(7, tmps.length);
    assertArrayEquals(new String[] {"a", "b", "c", "d", "e", "f", "g"}, tmps);

    assertEquals("a b c d e f g", (String) joinFn
        .call(null, AviatorRuntimeJavaType.valueOf(tmps), new AviatorString(" ")).getValue(null));
    assertEquals("abcdefg",
        (String) joinFn.call(null, AviatorRuntimeJavaType.valueOf(tmps)).getValue(null));
  }


  @Test
  public void testJoinWithCollection() {
    StringJoinFunction joinFn = new StringJoinFunction();
    List<String> list = new ArrayList<String>();
    list.add("hello");
    list.add("world");
    list.add("aviator");
    assertEquals("hello world aviator", (String) joinFn
        .call(null, AviatorRuntimeJavaType.valueOf(list), new AviatorString(" ")).getValue(null));
  }

}
