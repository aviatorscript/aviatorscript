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

package com.googlecode.aviator.utils;

import java.util.LinkedHashMap;


/**
 * LRU map based on LinkedHashMap
 *
 * @author apple
 *
 * @param <K>
 * @param <V>
 */
public class LRUMap<K, V> extends LinkedHashMap<K, V> {
  static final long serialVersionUID = -1L;

  private final int maxCapacity;


  public LRUMap(final int maxCapacity) {
    super(16, 0.75f, true);
    if (maxCapacity <= 0) {
      throw new IllegalArgumentException("Invalid maxCapacity: " + maxCapacity);
    }
    this.maxCapacity = maxCapacity;

  }


  @Override
  public V remove(final Object key) {
    return super.remove(key);
  }


  @Override
  public int size() {
    return super.size();
  }


  @Override
  public V put(final K k, final V v) {
    return super.put(k, v);
  }


  @Override
  public V get(final Object k) {
    return super.get(k);
  }


  @Override
  protected boolean removeEldestEntry(final java.util.Map.Entry<K, V> eldest) {
    return this.size() > this.maxCapacity;
  }

}
