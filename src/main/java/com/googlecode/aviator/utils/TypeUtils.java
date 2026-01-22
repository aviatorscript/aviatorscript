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


package com.googlecode.aviator.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import com.googlecode.aviator.runtime.RuntimeUtils;


/**
 * Java type to aviator type utilities
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class TypeUtils {

  public static final boolean isBigInt(final Object value) {
    return value instanceof BigInteger;
  }


  public static final boolean isDecimal(final Object value) {
    return value instanceof BigDecimal;
  }


  public static final boolean isLong(final Object value) {
    return value instanceof Integer || value instanceof Long || value instanceof Byte
        || value instanceof Short;
  }


  public static final boolean isDouble(final Object value) {
    return value instanceof Float || value instanceof Double;

  }


  public static final boolean isString(final Object value) {
    return value instanceof String || value instanceof Character;
  }

  public static long NEWTON_METHOD_REPEATS = 10000;


  public static int comapreLong(final long x, final long y) {
    if (x > y) {
      return 1;
    } else if (x < y) {
      return -1;
    } else {
      return 0;
    }
  }


  /**
   * newton method to get natural logarithm
   *
   * @param x
   * @return
   */
  public static BigDecimal ln(final Map<String, Object> env, BigDecimal x) {
    if (x.equals(BigDecimal.ONE)) {
      return BigDecimal.ZERO;
    }

    x = x.subtract(BigDecimal.ONE);
    BigDecimal ret = new BigDecimal(NEWTON_METHOD_REPEATS + 1);
    MathContext mathContext = RuntimeUtils.getMathContext(env);
    for (long i = NEWTON_METHOD_REPEATS; i >= 0; i--) {
      BigDecimal N = new BigDecimal(i / 2 + 1).pow(2);
      N = N.multiply(x, mathContext);
      ret = N.divide(ret, mathContext);

      N = new BigDecimal(i + 1);
      ret = ret.add(N, mathContext);

    }

    ret = x.divide(ret, mathContext);
    return ret;
  }

  public static final Map<String, Class<?>> PRIMITIVE_TYPES = new HashMap<>();


  static {
    TypeUtils.PRIMITIVE_TYPES.put("int", Integer.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("long", Long.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("double", Double.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("float", Float.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("bool", Boolean.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("char", Character.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("byte", Byte.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("void", Void.TYPE);
    TypeUtils.PRIMITIVE_TYPES.put("short", Short.TYPE);
  }

}
