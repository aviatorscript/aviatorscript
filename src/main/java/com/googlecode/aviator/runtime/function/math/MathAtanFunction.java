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


package com.googlecode.aviator.runtime.function.math;

import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * math.atan(d) function
 *
 * @author dennis
 *
 */
public class MathAtanFunction extends AbstractFunction {


  private static final long serialVersionUID = -4187660146211829531L;

  private MathAtanFunction() {

  }

  public static final MathAtanFunction INSTANCE = new MathAtanFunction();

  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    Number num = FunctionUtils.getNumberValue(arg1, env);
    return new AviatorDouble(Math.atan(num.doubleValue()));

  }


  @Override
  public String getName() {
    return "math.atan";
  }

}
