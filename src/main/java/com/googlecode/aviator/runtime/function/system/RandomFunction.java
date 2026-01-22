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

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * rand() function to generate random double value
 * 
 * @author dennis
 * 
 */
public class RandomFunction extends AbstractFunction {


  private static final long serialVersionUID = -8635075532485359687L;
  private static ThreadLocal<Random> randomLocal = new ThreadLocal<Random>() {

    @Override
    protected Random initialValue() {
      return new SecureRandom();
    }

  };


  @Override
  public AviatorObject call(Map<String, Object> env) {
    return AviatorDouble.valueOf(randomLocal.get().nextDouble());
  }


  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg) {
    return AviatorLong
        .valueOf(randomLocal.get().nextInt(FunctionUtils.getNumberValue(arg, env).intValue()));
  }


  @Override
  public String getName() {
    return "rand";
  }
}
