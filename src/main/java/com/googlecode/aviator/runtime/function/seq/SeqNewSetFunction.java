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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;

/**
 * seq.set function to new a hash set.
 *
 * @since 4.1.2
 * @author dennis
 *
 */
public class SeqNewSetFunction extends AbstractVariadicFunction {


  private static final long serialVersionUID = -8247803628833006273L;

  @Override
  public String getName() {
    return "seq.set";
  }

  @Override
  public AviatorObject variadicCall(final Map<String, Object> env, final AviatorObject... args) {
    Set<Object> set = new HashSet<>(args != null ? args.length : 10);

    if (args != null) {
      for (AviatorObject obj : args) {
        set.add(obj.getValue(env));
      }
    }

    return AviatorRuntimeJavaType.valueOf(set);
  }


}
