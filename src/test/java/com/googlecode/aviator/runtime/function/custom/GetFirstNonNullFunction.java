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


package com.googlecode.aviator.runtime.function.custom;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.Map;


/**
 * From user's issue report https://github.com/killme2008/aviator/issues/12
 * 
 * @author dennis
 *
 */
public class GetFirstNonNullFunction extends AbstractVariadicFunction {

  public AviatorObject variadicCall(Map<String, Object> env, AviatorObject... args) {
    if (args != null) {
      for (AviatorObject arg : args) {
        if (arg.getValue(env) != null) {
          return arg;
        }
      }
    }
    return new AviatorString(null);
  }


  @Override
  public String getName() {
    return "getFirstNonNull";
  }

}
