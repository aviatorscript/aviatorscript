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


package com.googlecode.aviator.runtime.type;

import java.util.Map;


/**
 * Aviator double type
 *
 * @author dennis
 *
 */
public class AviatorDouble extends AviatorNumber {



  private static final long serialVersionUID = 829573884607069307L;


  public AviatorDouble(double d) {
    super(d);
  }


  AviatorDouble(Number number) {
    super(number);
  }


  public static AviatorDouble valueOf(double value) {
    return new AviatorDouble(value);
  }


  public static AviatorDouble valueOf(Double value) {
    return valueOf(value.doubleValue());
  }


  @Override
  public int innerCompare(Map<String, Object> env, AviatorNumber other) {
    return Double.compare(this.doubleValue, other.doubleValue());
  }


  @Override
  public AviatorObject neg(Map<String, Object> env) {
    return new AviatorDouble(-this.doubleValue);
  }


  @Override
  public AviatorObject innerDiv(Map<String, Object> env, AviatorNumber other) {
    return new AviatorDouble(this.doubleValue / other.doubleValue());
  }


  @Override
  public AviatorNumber innerAdd(Map<String, Object> env, AviatorNumber other) {
    return new AviatorDouble(this.doubleValue + other.doubleValue());
  }


  @Override
  public AviatorObject innerMod(Map<String, Object> env, AviatorNumber other) {
    return new AviatorDouble(this.doubleValue % other.doubleValue());
  }


  @Override
  public AviatorObject innerMult(Map<String, Object> env, AviatorNumber other) {
    return new AviatorDouble(this.doubleValue * other.doubleValue());
  }

  @Override
  public long longValue() {
    return (long) this.doubleValue;
  }


  @Override
  public double doubleValue() {
    return this.doubleValue;
  }

  @Override
  public Object getValue(Map<String, Object> env) {
    return this.doubleValue;
  }


  @Override
  public AviatorType getAviatorType() {
    return AviatorType.Double;
  }


  @Override
  public AviatorObject innerSub(Map<String, Object> env, AviatorNumber other) {
    return new AviatorDouble(this.doubleValue - other.doubleValue());
  }
}
