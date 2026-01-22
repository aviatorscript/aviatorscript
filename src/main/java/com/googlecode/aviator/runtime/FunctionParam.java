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

import java.io.Serializable;

/**
 * Function param
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class FunctionParam implements Serializable {
  private static final long serialVersionUID = 2500321752781875680L;
  private final int index;
  private final String name;
  private final boolean isVariadic;



  public FunctionParam(final int index, final String name, final boolean isVariadic) {
    super();
    this.index = index;
    this.name = name;
    this.isVariadic = isVariadic;
  }

  public int getIndex() {
    return this.index;
  }

  public String getName() {
    return this.name;
  }

  public boolean isVariadic() {
    return this.isVariadic;
  }

  @Override
  public String toString() {
    return "FunctionParam [index=" + this.index + ", name=" + this.name + ", isVariadic="
        + this.isVariadic + "]";
  }


}
