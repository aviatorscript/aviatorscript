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
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * now() function to invoke System.currentTimeMillis()
 * 
 * @author dennis
 * 
 */
public class NowFunction extends AbstractFunction {


  private static final long serialVersionUID = 4288316673236996427L;


  @Override
  public AviatorObject call(Map<String, Object> env) {
    return AviatorLong.valueOf(System.currentTimeMillis());
  }


  @Override
  public String getName() {
    return "now";
  }

}
