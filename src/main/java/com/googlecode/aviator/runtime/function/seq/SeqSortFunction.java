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


package com.googlecode.aviator.runtime.function.seq;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.utils.ArrayUtils;


/**
 * sort(list, [comparator]) function to sort a java.util.List or array,return a sorted duplicate
 * object
 *
 * @author dennis
 *
 */
public class SeqSortFunction extends AbstractFunction {


  private static final long serialVersionUID = 8105967959099656098L;


  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {

    Object first = arg1.getValue(env);
    if (first == null) {
      return AviatorNil.NIL;
    }
    Class<?> clazz = first.getClass();

    if (List.class.isAssignableFrom(clazz)) {
      List<?> list = (List<?>) first;
      Object[] a = list.toArray();
      Arrays.sort(a);
      return AviatorRuntimeJavaType.valueOf(Arrays.asList(a));
    } else if (clazz.isArray()) {
      int length = ArrayUtils.getLength(first);
      Object[] dup = (Object[]) Array.newInstance(first.getClass().getComponentType(), length);
      for (int i = 0; i < length; i++) {
        dup[i] = ArrayUtils.get(first, i);
      }
      // System.arraycopy(array, 0, dup, 0, dup.length);
      Arrays.sort(dup);
      return AviatorRuntimeJavaType.valueOf(dup);
    } else {
      throw new IllegalArgumentException(arg1.desc(env) + " is not an array or list.");
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {

    Object first = arg1.getValue(env);
    Comparator comparator = (Comparator) arg2.getValue(env);
    if (first == null) {
      return AviatorNil.NIL;
    }
    if (comparator == null) {
      throw new IllegalArgumentException("null comparator");
    }
    Class<?> clazz = first.getClass();

    if (List.class.isAssignableFrom(clazz)) {
      List<?> list = (List<?>) first;
      Object[] a = list.toArray();
      Arrays.sort(a, comparator);
      return AviatorRuntimeJavaType.valueOf(Arrays.asList(a));
    } else if (clazz.isArray()) {
      int length = ArrayUtils.getLength(first);
      Object[] dup = (Object[]) Array.newInstance(first.getClass().getComponentType(), length);
      for (int i = 0; i < length; i++) {
        dup[i] = ArrayUtils.get(first, i);
      }
      // System.arraycopy(array, 0, dup, 0, dup.length);
      Arrays.sort(dup, comparator);
      return AviatorRuntimeJavaType.valueOf(dup);
    } else {
      throw new IllegalArgumentException(arg1.desc(env) + " is not an array or list.");
    }
  }


  @Override
  public String getName() {
    return "sort";
  }

}
