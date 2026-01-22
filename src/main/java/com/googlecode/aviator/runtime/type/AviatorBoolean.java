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


package com.googlecode.aviator.runtime.type;

import java.util.Map;
import com.googlecode.aviator.exception.CompareNotSupportedException;
import com.googlecode.aviator.utils.TypeUtils;


/**
 * Aviator boolean type
 *
 * @author dennis
 *
 */
public class AviatorBoolean extends AviatorObject {

  /**
   *
   */
  private static final long serialVersionUID = -685795150869373183L;

  Boolean value;

  public static final AviatorBoolean TRUE = new AviatorBoolean(Boolean.TRUE);

  public static final AviatorBoolean FALSE = new AviatorBoolean(Boolean.FALSE);


  @Override
  public AviatorObject not(final Map<String, Object> env) {
    return this.value.booleanValue() ? FALSE : TRUE;
  }


  @Override
  public final boolean booleanValue(final Map<String, Object> env) {
    return this.value.booleanValue();
  }

  public boolean getBooleanValue() {
    return this.value;
  }

  @Override
  public AviatorObject add(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case String:
        return new AviatorString(this.value.toString() + ((AviatorString) other).getLexeme(env));
      case JavaType:
        AviatorJavaType javaType = (AviatorJavaType) other;
        final Object otherJavaValue = javaType.getValue(env);
        if (TypeUtils.isString(otherJavaValue)) {
          return new AviatorString(this.value.toString() + otherJavaValue.toString());
        } else {
          return super.add(other, env);
        }
      default:
        return super.add(other, env);
    }

  }


  @Override
  public AviatorType getAviatorType() {
    return AviatorType.Boolean;
  }


  @Override
  public final Object getValue(final Map<String, Object> env) {
    return this.value;
  }


  private AviatorBoolean(final Boolean value) {
    super();
    this.value = value;
  }


  public static AviatorBoolean valueOf(final boolean b) {
    return b ? AviatorBoolean.TRUE : AviatorBoolean.FALSE;
  }


  @Override
  public int innerCompare(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case Boolean:
        AviatorBoolean otherBoolean = (AviatorBoolean) other;
        return this.value.compareTo(otherBoolean.value);
      case JavaType:
        AviatorJavaType javaType = (AviatorJavaType) other;
        final Object otherValue = javaType.getValue(env);
        if (otherValue == null) {
          return 1;
        }
        if (otherValue instanceof Boolean) {
          return this.value.compareTo((Boolean) otherValue);
        } else {
          throw new CompareNotSupportedException(
              "Could not compare " + desc(env) + " with " + other.desc(env));
        }
      case Nil:
        return 1;
      default:
        throw new CompareNotSupportedException(
            "Could not compare " + desc(env) + " with " + other.desc(env));
    }

  }

}
