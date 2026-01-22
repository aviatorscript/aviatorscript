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

package com.googlecode.aviator.utils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Utilities to access/update array elements etc.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class ArrayUtils {
  private ArrayUtils() {}

  public static int getLength(final Object a) {
    if (a instanceof byte[]) {
      return ((byte[]) a).length;
    } else if (a instanceof short[]) {
      return ((short[]) a).length;
    } else if (a instanceof int[]) {
      return ((int[]) a).length;
    } else if (a instanceof long[]) {
      return ((long[]) a).length;
    } else if (a instanceof float[]) {
      return ((float[]) a).length;
    } else if (a instanceof double[]) {
      return ((double[]) a).length;
    } else if (a instanceof String[]) {
      return ((String[]) a).length;
    } else if (a instanceof BigDecimal[]) {
      return ((BigDecimal[]) a).length;
    } else if (a instanceof BigInteger[]) {
      return ((BigInteger[]) a).length;
    } else if (a instanceof Object[]) {
      return ((Object[]) a).length;
    }

    return Array.getLength(a);
  }

  public static Object get(final Object a, final int index) {
    if (a instanceof byte[]) {
      return ((byte[]) a)[index];
    } else if (a instanceof short[]) {
      return ((short[]) a)[index];
    } else if (a instanceof int[]) {
      return ((int[]) a)[index];
    } else if (a instanceof long[]) {
      return ((long[]) a)[index];
    } else if (a instanceof float[]) {
      return ((float[]) a)[index];
    } else if (a instanceof double[]) {
      return ((double[]) a)[index];
    } else if (a instanceof String[]) {
      return ((String[]) a)[index];
    } else if (a instanceof BigDecimal[]) {
      return ((BigDecimal[]) a)[index];
    } else if (a instanceof BigInteger[]) {
      return ((BigInteger[]) a)[index];
    } else if (a instanceof Object[]) {
      return ((Object[]) a)[index];
    }

    return Array.get(a, index);
  }

  public static void set(final Object a, final int index, final Object val) {
    if (a instanceof byte[]) {
      ((byte[]) a)[index] = (byte) val;
    } else if (a instanceof short[]) {
      ((short[]) a)[index] = (short) val;
    } else if (a instanceof int[]) {
      ((int[]) a)[index] = (int) val;
    } else if (a instanceof long[]) {
      ((long[]) a)[index] = (long) val;
    } else if (a instanceof float[]) {
      ((float[]) a)[index] = (float) val;
    } else if (a instanceof double[]) {
      ((double[]) a)[index] = (double) val;
    } else if (a instanceof String[]) {
      ((String[]) a)[index] = (String) val;
    } else if (a instanceof BigDecimal[]) {
      ((BigDecimal[]) a)[index] = (BigDecimal) val;
    } else if (a instanceof BigInteger[]) {
      ((BigInteger[]) a)[index] = (BigInteger) val;
    } else if (a instanceof Object[]) {
      ((Object[]) a)[index] = val;
    } else {
      Array.set(a, index, val);
    }
  }
}
