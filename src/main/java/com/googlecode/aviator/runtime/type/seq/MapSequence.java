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

package com.googlecode.aviator.runtime.type.seq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.googlecode.aviator.runtime.type.Collector;

/**
 * Sequence for map.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
@SuppressWarnings("rawtypes")
public class MapSequence extends AbstractSequence<Map.Entry> {
  private final Map map;

  public MapSequence(final Map map) {
    super();
    this.map = map;
  }

  @Override
  public int hintSize() {
    return this.map.size();
  }

  @Override
  public Collector newCollector(final int size) {
    if (size > 0) {
      return new ListCollector(size, false);
    } else {
      Map coll;
      try {
        coll = this.map.getClass().newInstance();
      } catch (Throwable t) {
        coll = new HashMap();
      }
      final Map container = coll;
      return new Collector() {

        @SuppressWarnings("unchecked")
        @Override
        public void add(final Object e) {
          Entry entry = (Entry) e;
          container.put(entry.getKey(), entry.getValue());
        }

        @Override
        public Object getRawContainer() {
          return container;
        }

      };
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public Iterator<Map.Entry> iterator() {
    return this.map.entrySet().iterator();
  }

}
