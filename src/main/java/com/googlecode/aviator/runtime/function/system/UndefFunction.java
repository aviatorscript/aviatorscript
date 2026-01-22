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
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorType;
import com.googlecode.aviator.utils.Env;

/**
 * undef(x) to forgot a variable that is defined in current scope.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class UndefFunction extends AbstractFunction {


  private static final long serialVersionUID = -1301889134837125717L;

  @Override
  public String getName() {
    return "undef";
  }

  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    if (arg1.getAviatorType() != AviatorType.JavaType) {
      throw new IllegalArgumentException(
          "Invalid argument type for undef: " + arg1.getAviatorType());
    }
    return FunctionUtils.wrapReturn(((Env) env).forgot(((AviatorJavaType) arg1).getName()));
  }

}
