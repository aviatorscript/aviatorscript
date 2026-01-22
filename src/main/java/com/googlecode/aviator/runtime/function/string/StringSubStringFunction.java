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


package com.googlecode.aviator.runtime.function.string;

import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;


/**
 * string.substring(s1,s2) function
 * 
 * @author dennis
 * 
 */
public class StringSubStringFunction extends AbstractFunction {

  private static final long serialVersionUID = -5815382413034383204L;


  @Override
  public String getName() {
    return "string.substring";
  }


  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2,
      AviatorObject arg3) {

    String target = FunctionUtils.getStringValue(arg1, env);
    Number beginIndex = FunctionUtils.getNumberValue(arg2, env);
    Number endIndex = FunctionUtils.getNumberValue(arg3, env);
    return new AviatorString(target.substring(beginIndex.intValue(), endIndex.intValue()));

  }


  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
    String target = FunctionUtils.getStringValue(arg1, env);
    Number beginIndex = FunctionUtils.getNumberValue(arg2, env);

    return new AviatorString(target.substring(beginIndex.intValue()));

  }

}
