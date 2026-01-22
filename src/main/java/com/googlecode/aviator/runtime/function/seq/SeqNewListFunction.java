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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;

/**
 * seq.list function to new an array list.
 *
 * @since 4.1.2
 * @author dennis
 *
 */
public class SeqNewListFunction extends AbstractVariadicFunction {


  private static final long serialVersionUID = 2726529252281789461L;

  @Override
  public String getName() {
    return "seq.list";
  }

  @Override
  public AviatorObject variadicCall(final Map<String, Object> env, final AviatorObject... args) {
    List<Object> list = new ArrayList<>(args != null ? args.length : 10);
    if (args != null) {
      for (AviatorObject obj : args) {
        list.add(obj.getValue(env));
      }
    }

    return AviatorRuntimeJavaType.valueOf(list);
  }


}
