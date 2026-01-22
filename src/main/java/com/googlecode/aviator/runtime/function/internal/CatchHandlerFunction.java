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

package com.googlecode.aviator.runtime.function.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.utils.Env;

/**
 * __catch_handler(fun, exception) to create a {@link CatchHandler}.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class CatchHandlerFunction extends AbstractVariadicFunction {

  private CatchHandlerFunction() {

  }

  public static final CatchHandlerFunction INSTANCE = new CatchHandlerFunction();

  /**
   *
   */
  private static final long serialVersionUID = 7314510329619948965L;

  @Override
  public String getName() {
    return "__catch_handler";
  }

  @Override
  public AviatorObject variadicCall(final Map<String, Object> env, final AviatorObject... args) {
    assert (args.length > 0);
    List<String> exceptionClasses = new ArrayList<String>(args.length - 1);
    for (int i = 1; i < args.length; i++) {
      exceptionClasses.add(((AviatorJavaType) args[i]).getName());
    }

    return new CatchHandler((Env) env, (AviatorFunction) args[0], exceptionClasses);
  }
}
