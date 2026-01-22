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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;


/**
 * string_to_date function
 * 
 * @author dennis(killme2008@gmail.com)
 * 
 */
public class String2DateFunction extends AbstractFunction {


  private static final long serialVersionUID = -1899407811376304410L;


  @Override
  public String getName() {
    return "string_to_date";
  }


  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
    String source = FunctionUtils.getStringValue(arg1, env);
    String format = FunctionUtils.getStringValue(arg2, env);
    SimpleDateFormat dateFormat = DateFormatCache.getOrCreateDateFormat(format);
    try {
      return AviatorRuntimeJavaType.valueOf(dateFormat.parse(source));
    } catch (ParseException e) {
      throw new ExpressionRuntimeException("Cast string to date failed", e);
    }
  }

}
