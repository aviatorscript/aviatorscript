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

package com.googlecode.aviator.runtime;

/**
 * A function argument.
 *
 * @since 4.2.0
 * @author dennis(killme2008@gmail.com)
 *
 */
public class FunctionArgument {
  private final int index;
  private final String expression;

  public FunctionArgument(final int index, final String name) {
    super();
    this.index = index;
    this.expression = name;
  }

  /**
   * Returns the parameter index in function,starts from zero.
   *
   * @return
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * Returns the parameter expression.
   *
   * @return
   */
  public String getExpression() {
    return this.expression;
  }

  @Override
  public String toString() {
    return "FunctionArgument [index=" + this.index + ", expression=" + this.expression + "]";
  }

  public static FunctionArgument from(final int index, final String name) {
    return new FunctionArgument(index, name);
  }
}
