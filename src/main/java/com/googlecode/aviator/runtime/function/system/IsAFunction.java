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


package com.googlecode.aviator.runtime.function.system;

import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorType;
import com.googlecode.aviator.utils.Env;
import com.googlecode.aviator.utils.Reflector;
import com.googlecode.aviator.utils.TypeUtils;


/**
 * is_a(x, clazz) returns true when x is an intance of the class.
 *
 * @author dennis
 *
 */
public class IsAFunction extends AbstractFunction {

  private static final long serialVersionUID = -7543895978170666671L;

  private IsAFunction() {}

  public static final IsAFunction INSTANCE = new IsAFunction();



  @Override
  public String getName() {
    return "is_a";
  }



  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {
    Object obj = arg1.getValue(env);

    if (obj == null) {
      return AviatorBoolean.FALSE;
    }


    if (arg2.getAviatorType() != AviatorType.JavaType) {
      throw new IllegalArgumentException("Invalid class type: " + arg2.desc(env));
    }
    try {
      Class<?> clazz = null;
      final String name = ((AviatorJavaType) arg2).getName();
      if (TypeUtils.PRIMITIVE_TYPES.containsKey(name)) {
        clazz = TypeUtils.PRIMITIVE_TYPES.get(name);
      } else {
        clazz = ((Env) env).resolveClassSymbol(name, false);
      }
      return AviatorBoolean.valueOf(clazz.isInstance(obj));
    } catch (ClassNotFoundException e) {
      throw Reflector.sneakyThrow(e);
    }
  }

}
