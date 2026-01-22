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
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * Constant function to return the argument itself.
 *
 * @author dennis(killme2008@gmail.com)
 * @since 4.2.5
 *
 */
public class ConstantFunction extends AbstractVariadicFunction {


  private static final long serialVersionUID = -2077433391081175967L;
  private final String name;
  private final AviatorObject result;



  public ConstantFunction(final String name, final AviatorObject result) {
    super();
    this.name = name;
    this.result = result;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public AviatorObject variadicCall(final Map<String, Object> env, final AviatorObject... args) {
    return this.result;
  }

}
