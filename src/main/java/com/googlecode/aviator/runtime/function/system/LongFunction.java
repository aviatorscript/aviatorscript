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

package com.googlecode.aviator.runtime.function.system;

import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * Cast value to long
 *
 * @author dennis
 * @Date 2011-5-18
 * @since 1.1.1
 *
 */
public class LongFunction extends AbstractFunction {


  private static final long serialVersionUID = 820173052464302490L;


  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
    switch (arg1.getAviatorType()) {
      case Boolean:
        return AviatorLong.valueOf(arg1.booleanValue(env) ? 1 : 0);
      case JavaType:
        Object obj = arg1.getValue(env);
        if (obj instanceof Number) {
          return AviatorLong.valueOf(((Number) obj).longValue());
        } else if (obj instanceof String) {
          return AviatorLong.valueOf(Long.valueOf((String) obj));
        } else if (obj instanceof Character) {
          return AviatorLong.valueOf(Long.valueOf(String.valueOf(obj)));
        } else {
          throw new ClassCastException(
              "Could not cast " + (obj != null ? obj.getClass().getName() : "null")
                  + " to long, AviatorObject is " + arg1);
        }
      case String:
        return AviatorLong.valueOf(Long.valueOf((String) arg1.getValue(env)));
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return AviatorLong.valueOf(((Number) arg1.getValue(env)).longValue());
      default:
        throw new ClassCastException("Could not cast " + arg1 + " to long");
    }
  }


  @Override
  public String getName() {
    return "long";
  }

}
