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
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorString;


public abstract class BaseStringFunctionUnitTest {
  AviatorFunction function;


  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArguments_null() {
    this.function.call(null);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArguments_one() {
    this.function.call(null, new AviatorString("hello"));
  }


  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArguments_Three() {
    this.function.call(null, new AviatorString("hello"), new AviatorString("hello"),
        new AviatorString("hello"));
  }


  @Test(expected = ClassCastException.class)
  public void testClassCastError1() {
    this.function.call(null, AviatorBoolean.TRUE, new AviatorString("hello"));
  }


  @Test(expected = ClassCastException.class)
  public void testClassCastError2() {
    this.function.call(null, new AviatorString("hello"), AviatorLong.valueOf(3));
  }


  @Test(expected = NullPointerException.class)
  public void testNullPointerException1() {
    this.function.call(null, new AviatorString("hello"), AviatorNil.NIL);
  }


  @Test(expected = NullPointerException.class)
  public void testNullPointerException2() {
    this.function.call(null, AviatorNil.NIL, new AviatorString("hello"));
  }
}
