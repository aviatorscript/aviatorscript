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

package com.googlecode.aviator.runtime.type.seq;

import com.googlecode.aviator.runtime.type.Collector;

public class ArrayCollector implements Collector {
  Object[] array;
  int i = 0;

  public ArrayCollector(final int size) {
    this.array = new Object[size];
  }

  @Override
  public void add(final Object e) {
    this.array[this.i++] = e;
  }

  @Override
  public Object getRawContainer() {
    return this.array;
  }
}
