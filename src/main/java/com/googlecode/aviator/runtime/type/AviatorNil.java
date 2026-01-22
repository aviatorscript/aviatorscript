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
import com.googlecode.aviator.utils.TypeUtils;


/**
 * Aviator nil object
 *
 * @author dennis
 *
 */
public class AviatorNil extends AviatorObject {
  private static final long serialVersionUID = 5030890238879926682L;
  public static final AviatorNil NIL = new AviatorNil();


  private AviatorNil() {

  }


  @Override
  public AviatorObject add(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case String:
        return new AviatorString("null" + other.getValue(env));
      case JavaType:
        final Object otherValue = other.getValue(env);
        if (TypeUtils.isString(otherValue)) {
          return new AviatorString("null" + otherValue);
        } else {
          return super.add(other, env);
        }
      default:
        return super.add(other, env);
    }
  }


  @Override
  public int innerCompare(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case Nil:
        return 0;
      case JavaType:
        if (other.getValue(env) == null) {
          return 0;
        }
    }
    // Any object is greater than nil except nil
    return -1;
  }


  @Override
  public AviatorType getAviatorType() {
    return AviatorType.Nil;
  }


  @Override
  public Object getValue(final Map<String, Object> env) {
    return null;
  }

}
