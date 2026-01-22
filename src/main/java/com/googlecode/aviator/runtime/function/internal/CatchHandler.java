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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorType;
import com.googlecode.aviator.utils.Env;
import com.googlecode.aviator.utils.Reflector;

/**
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class CatchHandler extends AviatorObject {
  /**
   *
   */
  private static final long serialVersionUID = 2718902412145274738L;
  private final AviatorFunction func;
  private final List<Class<?>> exceptionClasses;

  public CatchHandler(final Env env, final AviatorFunction func,
      final List<String> exceptionClassNames) {
    super();
    this.func = func;
    this.exceptionClasses = new ArrayList<>(exceptionClassNames.size());
    for (String exceptionClass : exceptionClassNames) {
      try {
        this.exceptionClasses.add(env.resolveClassSymbol(exceptionClass, false));
      } catch (Exception e) {
        throw Reflector.sneakyThrow(e);
      }
    }
  }

  public AviatorFunction getFunc() {
    return this.func;
  }

  public boolean isMatch(final Class<?> eClass) {
    for (Class<?> clazz : this.exceptionClasses) {
      if (clazz.isAssignableFrom(eClass)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int innerCompare(final AviatorObject other, final Map<String, Object> env) {
    throw new UnsupportedOperationException();
  }

  @Override
  public AviatorType getAviatorType() {
    return AviatorType.JavaType;
  }

  @Override
  public Object getValue(final Map<String, Object> env) {
    return this;
  }

}
