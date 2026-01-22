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

import java.util.Map;

/**
 * Processing env before or after executing expression.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public interface EnvProcessor {
  /**
   * This method will be called before executing the expression.
   *
   * @param env the env object
   * @param script the script object
   */
  void beforeExecute(Map<String, Object> env, Expression script);

  /**
   * This method will be called after executing the expression.
   *
   * @param env the env object
   * @param script the script object
   */
  void afterExecute(Map<String, Object> env, Expression script);
}
