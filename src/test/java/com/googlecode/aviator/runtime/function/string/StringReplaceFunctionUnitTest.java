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

import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorString;
import static org.junit.Assert.*;


public class StringReplaceFunctionUnitTest {

  @Test
  public void testReplaceFirst() {
    StringReplaceFirstFunction fun = new StringReplaceFirstFunction();

    assertEquals("string.replace_first", fun.getName());
    Object value =
        fun.call(null, new AviatorString("hello"), new AviatorString("l"), new AviatorString("a"))
            .getValue(null);
    assertEquals("healo", value);
    try {
      fun.call(null, null, new AviatorString("l"), new AviatorString("a")).getValue(null);
      fail();
    } catch (NullPointerException e) {
      // assertEquals("Could not replace with null string",
      // e.getMessage());
    }
  }


  @Test
  public void testReplaceAll() {
    StringReplaceAllFunction fun = new StringReplaceAllFunction();

    assertEquals("string.replace_all", fun.getName());
    Object value =
        fun.call(null, new AviatorString("hello"), new AviatorString("l"), new AviatorString("a"))
            .getValue(null);
    assertEquals("heaao", value);
    try {
      fun.call(null, null, new AviatorString("l"), new AviatorString("a")).getValue(null);
      fail();
    } catch (NullPointerException e) {
      // assertEquals("Could not replace with null string",
      // e.getMessage());
    }
  }

}
