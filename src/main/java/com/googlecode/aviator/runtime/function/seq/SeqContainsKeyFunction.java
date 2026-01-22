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

import java.util.List;
import java.util.Map;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.utils.ArrayUtils;


/**
 * seq.contains_key(map,key) function to check if seq(should be map) contains the key.
 *
 * @author dennis
 *
 */
public class SeqContainsKeyFunction extends AbstractFunction {


  private static final long serialVersionUID = 1543232112837279691L;


  @SuppressWarnings("rawtypes")
  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {
    Object first = arg1.getValue(env);
    if (first == null) {
      return AviatorBoolean.FALSE;
    }
    Class<?> clazz = first.getClass();
    if (Map.class.isAssignableFrom(clazz)) {
      Map seq = (Map) first;
      try {
        return AviatorBoolean.valueOf(seq.containsKey(arg2.getValue(env)));
      } catch (ExpressionRuntimeException e) {
        throw e;
      } catch (Exception e) {
        RuntimeUtils.printStackTrace(env, e);
        return AviatorBoolean.FALSE;
      }
    } else if (clazz.isArray()) {
      int index = FunctionUtils.getNumberValue(arg2, env).intValue();
      return AviatorBoolean.valueOf(index >= 0 && index < ArrayUtils.getLength(first));
    } else if (List.class.isAssignableFrom(clazz)) {
      int index = FunctionUtils.getNumberValue(arg2, env).intValue();
      return AviatorBoolean.valueOf(index >= 0 && index < ((List) first).size());
    } else {
      throw new IllegalArgumentException(arg1.desc(env) + " is not a map or array.");
    }
  }


  @Override
  public String getName() {
    return "seq.contains_key";
  }

}
