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

import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;


/**
 * Cast value to string
 *
 * @author dennis
 * @Date 2011-5-18
 * @since 1.1.1
 *
 */
public class StrFunction extends AbstractFunction {


  private static final long serialVersionUID = 8649875989830820633L;

  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
    final Object value = arg1.getValue(env);
    return new AviatorString(value == null ? "null" : value.toString());
  }

  @Override
  public String getName() {
    return "str";
  }

}
