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
import java.util.Collection;
import java.util.Iterator;
import com.googlecode.aviator.runtime.type.Collector;

/**
 * Sequence for iterable.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class IterableSequence extends AbstractSequence<Object> {
  private final Iterable<Object> iterable;


  public IterableSequence(final Iterable<Object> iterable) {
    super();
    this.iterable = iterable;
  }

  @Override
  public int hintSize() {
    if (this.iterable instanceof Collection) {
      return ((Collection) this.iterable).size();
    }
    return 10;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Collector newCollector(final int size) {
    Collection coll;
    try {
      coll = (Collection) this.iterable.getClass().newInstance();
    } catch (Throwable t) {
      coll = new ArrayList(size > 0 ? size : 10);
    }
    final Collection container = coll;
    return new Collector() {

      @SuppressWarnings("unchecked")
      @Override
      public void add(final Object e) {
        container.add(e);
      }

      @Override
      public Object getRawContainer() {
        return container;
      }

    };
  }


  @Override
  public Iterator<Object> iterator() {
    return this.iterable.iterator();
  }

}
