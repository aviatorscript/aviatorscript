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

import java.util.ArrayList;
import java.util.List;
import com.googlecode.aviator.runtime.type.Collector;

public class ListCollector implements Collector {
  private static final int INIT_CAP = 10;
  @SuppressWarnings("rawtypes")
  List list;
  boolean returnArray;

  public ListCollector() {
    this(INIT_CAP, false);
  }

  public ListCollector(final boolean returnArray) {
    this(INIT_CAP, returnArray);
  }

  public ListCollector(final int size, final boolean returnArray) {
    this.list = new ArrayList<>(size > 0 ? size : INIT_CAP);
    this.returnArray = returnArray;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void add(final Object e) {
    this.list.add(e);
  }

  @Override
  public Object getRawContainer() {
    if (this.returnArray) {
      return this.list.toArray();
    } else {
      return this.list;
    }
  }
}
