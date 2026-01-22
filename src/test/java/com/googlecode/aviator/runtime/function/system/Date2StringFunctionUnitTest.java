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

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;


public class Date2StringFunctionUnitTest {

  private Date2StringFunction function = new Date2StringFunction();


  @Test
  public void testCall() {
    assertEquals("date_to_string", function.getName());
    Date date = new Date();
    assertEquals(DateFormatCache.getOrCreateDateFormat("yyyyMMdd").format(date),
        function.call(null, AviatorRuntimeJavaType.valueOf(date), new AviatorString("yyyyMMdd"))
            .getValue(null));

    assertEquals(DateFormatCache.getOrCreateDateFormat("yyyy--MM--dd").format(date),
        function.call(null, AviatorRuntimeJavaType.valueOf(date), new AviatorString("yyyy--MM--dd"))
            .getValue(null));

  }


  @Test(expected = ClassCastException.class)
  public void testCall_NotDate() {
    assertEquals("date_to_string", function.getName());
    function.call(null, AviatorRuntimeJavaType.valueOf(1), new AviatorString("yyyyMMdd"));
  }
}
