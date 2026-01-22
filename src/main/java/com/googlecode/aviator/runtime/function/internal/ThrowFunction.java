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

package com.googlecode.aviator.runtime.function.internal;

import java.util.Map;
import com.googlecode.aviator.exception.StandardError;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.utils.Reflector;

/**
 * __throw(e) to throw an exception.
 *
 * @author boyan(boyan@antfin.com)
 *
 */
public class ThrowFunction extends AbstractFunction {

  private static final long serialVersionUID = -8464670257920503718L;

  private ThrowFunction() {}

  public static final ThrowFunction INSTANCE = new ThrowFunction();

  @Override
  public String getName() {
    return "__throw";
  }

  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    Object val = arg1.getValue(env);
    if (val instanceof Throwable) {
      throw Reflector.sneakyThrow((Throwable) val);
    } else {
      throw Reflector.sneakyThrow(new StandardError(val == null ? null : val.toString()));
    }
  }

}
