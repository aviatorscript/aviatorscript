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
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;

/**
 * tuple(x,y,z, ...) function to return an object array.
 *
 * @author dennis
 * @since 4.0.0
 *
 */
public class TupleFunction extends AbstractVariadicFunction {


  private static final long serialVersionUID = -7377110880312266008L;

  @Override
  public String getName() {
    return "tuple";
  }

  @Override
  public AviatorObject variadicCall(Map<String, Object> env, AviatorObject... args) {
    Object[] tuple = new Object[args.length];
    for (int i = 0; i < args.length; i++) {
      tuple[i] = args[i].getValue(env);
    }
    return AviatorRuntimeJavaType.valueOf(tuple);
  }

}
