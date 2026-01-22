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
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * Internal reducer-break function for 'for-loop' structure.
 *
 * @since 5.0.0
 * @author dennis(killme2008@gmail.com)
 *
 */
public class ReducerBreakFunction extends AbstractFunction {

  private ReducerBreakFunction() {

  }

  public static final ReducerBreakFunction INSTANCE = new ReducerBreakFunction();

  private static final long serialVersionUID = -542526309712482544L;

  @Override
  public String getName() {
    return "__reducer_break";
  }

  @Override
  public AviatorObject call(final Map<String, Object> env) {
    return ReducerResult.withBreak(AviatorNil.NIL);
  }

  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    return ReducerResult.withBreak(AviatorNil.NIL);
  }
}
