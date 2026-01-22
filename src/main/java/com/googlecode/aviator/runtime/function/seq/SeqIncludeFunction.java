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

import java.util.Map;
import java.util.Set;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;


/**
 * include(seq,obj) function to check if seq contains object
 *
 * @author dennis
 *
 */
public class SeqIncludeFunction extends AbstractFunction {


  private static final long serialVersionUID = 2484898649434036343L;


  @SuppressWarnings("rawtypes")
  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {
    Object first = arg1.getValue(env);
    if (first == null) {
      return AviatorBoolean.FALSE;
    }
    Class<?> clazz = first.getClass();
    boolean contains = false;
    if (Set.class.isAssignableFrom(clazz)) {
      contains = ((Set) first).contains(arg2.getValue(env));
    } else {
      try {
        for (Object obj : RuntimeUtils.seq(first, env)) {
          if (AviatorRuntimeJavaType.valueOf(obj).compareEq(arg2, env) == 0) {
            contains = true;
            break;
          }
        }
      } catch (ExpressionRuntimeException e) {
        throw e;
      } catch (Exception e) {
        RuntimeUtils.printStackTrace(env, e);
        return AviatorBoolean.FALSE;
      }
    }
    return AviatorBoolean.valueOf(contains);

  }


  @Override
  public String getName() {
    return "include";
  }

}
