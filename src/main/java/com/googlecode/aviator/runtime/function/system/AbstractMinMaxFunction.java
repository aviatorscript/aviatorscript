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
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * Abstract base class for system min/max function.
 *
 * @author dennis
 *
 */
public abstract class AbstractMinMaxFunction extends AbstractVariadicFunction {

  private static final long serialVersionUID = -2554658421948407347L;

  static enum Op {
    Min, Max
  }



  @Override
  public AviatorObject variadicCall(final Map<String, Object> env, final AviatorObject... args) {

    if (args == null || args.length == 0) {
      return AviatorNil.NIL;
    }

    boolean wasFirst = true;
    AviatorObject result = AviatorNil.NIL;
    for (AviatorObject obj : args) {
      result = compareObjects(env, result, obj, wasFirst);
      if (wasFirst) {
        wasFirst = false;
      }
      if (getOp() == Op.Min && result.isNull(env)) {
        break;
      }
    }

    return result;
  }


  protected abstract Op getOp();



  private AviatorObject compareObjects(final Map<String, Object> env, AviatorObject result,
      final AviatorObject obj, final boolean wasFirst) {
    if (obj.isNull(env)) {
      switch (getOp()) {
        case Min:
          return obj;
        case Max:
          return result;
      }
    }
    if (wasFirst || compare(env, result, obj)) {
      result = obj;
    }
    return result;
  }

  private boolean compare(final Map<String, Object> env, final AviatorObject result,
      final AviatorObject obj) {
    int c = obj.compare(result, env);
    switch (getOp()) {
      case Min:
        return c < 0;
      case Max:
        return c > 0;
    }
    return false;
  }
}
