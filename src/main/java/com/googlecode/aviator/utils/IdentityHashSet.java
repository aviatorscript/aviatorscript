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



import java.util.AbstractSet;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Identity hash set based on IdentityHashMap.
 *
 * @author dennis(killme2008@gmail.com)
 *
 * @param <E>
 */
public class IdentityHashSet<E> extends AbstractSet<E> {
  private final Map<E, Boolean> delegate = new IdentityHashMap<E, Boolean>();

  public IdentityHashSet() {}

  public IdentityHashSet(final Collection<E> c) {
    addAll(c);
  }

  @Override
  public int size() {
    return this.delegate.size();
  }

  @Override
  public boolean contains(final Object o) {
    return this.delegate.containsKey(o);
  }

  @Override
  public Iterator<E> iterator() {
    return this.delegate.keySet().iterator();
  }

  @Override
  public boolean add(final E arg0) {
    return this.delegate.put(arg0, Boolean.TRUE) == null;
  }

  @Override
  public boolean remove(final Object o) {
    return this.delegate.remove(o) != null;
  }

  @Override
  public void clear() {
    this.delegate.clear();
  }
}
