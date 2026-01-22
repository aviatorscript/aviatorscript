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


package com.googlecode.aviator.runtime.function.seq;

import java.util.Collection;
import java.util.Map;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.Range;
import com.googlecode.aviator.utils.ArrayUtils;


/**
 * count(seq) to get seq's size
 *
 * @author dennis
 *
 */
public class SeqCountFunction extends AbstractFunction {


  private static final long serialVersionUID = 4640528586873392060L;


  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    Object value = arg1.getValue(env);
    if (value == null) {
      return AviatorLong.valueOf(0);
    }
    Class<?> clazz = value.getClass();

    int size = -1;
    if (Collection.class.isAssignableFrom(clazz)) {
      Collection<?> col = (Collection<?>) value;
      size = col.size();
    } else if (Map.class.isAssignableFrom(clazz)) {
      size = ((Map) value).size();
    } else if (CharSequence.class.isAssignableFrom(clazz)) {
      size = ((CharSequence) value).length();
    } else if (clazz.isArray()) {
      size = ArrayUtils.getLength(value);
    } else if (Range.class.isAssignableFrom(clazz)) {
      size = ((Range) value).size();
    } else {
      size = 0;
      for (Object e : RuntimeUtils.seq(value, env)) {
        size++;
      }
    }
    return AviatorLong.valueOf(size);
  }


  @Override
  public String getName() {
    return "count";
  }

}
