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


package com.googlecode.aviator;
/**
 *
 * Called when function not found, return the invocation result.
 *
 * @author dennis(killme2008@gmail.com)
 * @since 4.2.5
 *
 */

import java.io.Serializable;
import java.util.Map;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * Function not found hook interface. The
 * {@link FunctionMissing#onFunctionMissing(String, Map, AviatorObject...)} method will be called
 * when function not found, return the invocation result.
 *
 * @see AviatorEvaluatorInstance#setFunctionMissing(FunctionMissing)
 * @see AviatorEvaluator#setFunctionMissing(FunctionMissing)
 * @author dennis zhuang(killme2008@gmail.com)
 * @since 4.2.5
 *
 */
public interface FunctionMissing extends Serializable {
  /**
   * Called when function not found, return the invocation result.
   *
   * @param name function name
   * @param env invocation env
   * @param args invocation arguments.
   * @return The invocation result.
   */
  AviatorObject onFunctionMissing(String name, Map<String, Object> env, AviatorObject... args);
}
