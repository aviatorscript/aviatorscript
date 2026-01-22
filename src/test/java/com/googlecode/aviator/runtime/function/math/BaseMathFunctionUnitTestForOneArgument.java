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

import org.junit.Test;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorNumber;
import com.googlecode.aviator.runtime.type.AviatorString;


public abstract class BaseMathFunctionUnitTestForOneArgument {

  AviatorFunction function;


  @Test(expected = IllegalArgumentException.class)
  public void testZeroArgument() {
    function.call(null);
  }


  @Test(expected = IllegalArgumentException.class)
  public void test_TwoArugments() {
    function.call(null, AviatorNumber.valueOf(3.2), AviatorNumber.valueOf(3.2));
  }


  @Test(expected = NullPointerException.class)
  public void testNullPointer() {
    function.call(null, AviatorNil.NIL);
  }


  @Test(expected = ClassCastException.class)
  public void testClassCastError1() {
    function.call(null, AviatorBoolean.TRUE);
  }


  @Test(expected = ClassCastException.class)
  public void testClassCastError2() {
    function.call(null, new AviatorString("hello"));
  }
}
