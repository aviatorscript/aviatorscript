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

import java.io.IOException;
import java.util.Map;
import com.googlecode.aviator.exception.LoadScriptFailureException;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorType;
import com.googlecode.aviator.utils.Constants;

/**
 * load('script.av') to load a script and retrieve it's exports. It will compile and execute the
 * script at every time.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class LoadFunction extends AbstractFunction {


  private static final long serialVersionUID = -6860446850416005514L;

  private LoadFunction() {

  }

  public static final LoadFunction INSTANCE = new LoadFunction();

  @Override
  public String getName() {
    return Constants.LOAD_FN;
  }

  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    if (arg1.getAviatorType() != AviatorType.String) {
      throw new IllegalArgumentException(
          "Invalid argument type for load: " + arg1.getAviatorType());
    }

    try {
      return AviatorRuntimeJavaType
          .valueOf(RuntimeUtils.getInstance(env).loadScript((String) arg1.getValue(env)));
    } catch (IOException e) {
      throw new LoadScriptFailureException("Fail to load script from: " + arg1.getValue(env), e);
    }
  }

}
