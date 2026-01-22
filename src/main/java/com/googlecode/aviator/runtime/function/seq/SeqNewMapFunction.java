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

import java.util.HashMap;
import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;

/**
 * seq.map function to new a hash map.
 *
 * @since 4.1.2
 * @author dennis
 *
 */
public class SeqNewMapFunction extends AbstractVariadicFunction {


  private static final long serialVersionUID = -2581715177871593829L;

  @Override
  public String getName() {
    return "seq.map";
  }

  @Override
  public AviatorObject variadicCall(final Map<String, Object> env, final AviatorObject... args) {

    if (args != null && args.length % 2 != 0) {
      throw new IllegalArgumentException("Expect arguments in even number as key/value pairs.");
    }

    Map<Object, Object> map = new HashMap<>(args != null ? args.length / 2 : 10);
    if (args != null) {
      for (int i = 0; i < args.length;) {
        map.put(args[i].getValue(env), args[i + 1].getValue(env));
        i += 2;
      }
    }

    return AviatorRuntimeJavaType.valueOf(map);
  }

}
