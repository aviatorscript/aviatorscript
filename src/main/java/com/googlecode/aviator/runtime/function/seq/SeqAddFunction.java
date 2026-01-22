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

import java.util.Collection;
import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.Collector;
import com.googlecode.aviator.utils.ArrayUtils;

/**
 * seq.add function to add an element into seq.
 *
 * @author dennis
 * @since 4.1.2
 *
 */
public class SeqAddFunction extends AbstractFunction {


  private static final long serialVersionUID = -4406740199823615336L;

  @Override
  public String getName() {
    return "seq.add";
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {

    Object coll = arg1.getValue(env);
    Object element = arg2.getValue(env);
    if (coll == null) {
      throw new NullPointerException("null seq");
    }
    Class<?> clazz = coll.getClass();

    if (Collection.class.isAssignableFrom(clazz)) {
      ((Collection) coll).add(element);
      return arg1;
    } else if (Map.class.isAssignableFrom(clazz) && element instanceof Map.Entry) {
      Map.Entry entry = (Map.Entry) element;
      ((Map) coll).put(entry.getKey(), entry.getValue());
      return arg1;
    } else if (Collector.class.isAssignableFrom(clazz)) {
      ((Collector) coll).add(element);
      return arg1;
    } else {
      throw new IllegalArgumentException("Can't add value: " + element + " into " + arg1.desc(env));
    }

  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2, final AviatorObject arg3) {

    Object coll = arg1.getValue(env);
    Object key = arg2.getValue(env);
    Object value = arg3.getValue(env);
    if (coll == null) {
      throw new NullPointerException("null seq");
    }
    Class<?> clazz = coll.getClass();

    if (Map.class.isAssignableFrom(clazz)) {

      ((Map) coll).put(key, value);

      return arg1;
    } else if (clazz.isArray()) {
      int index = ((Number) key).intValue();
      ArrayUtils.set(coll, index, value);
      return arg1;
    } else {
      throw new IllegalArgumentException(
          "Can't add key: " + key + " and value: " + value + " into " + arg1.desc(env));
    }

  }


}
