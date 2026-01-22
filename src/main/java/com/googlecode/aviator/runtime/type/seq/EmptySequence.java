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

import java.util.Iterator;
import java.util.NoSuchElementException;
import com.googlecode.aviator.runtime.type.Collector;

/**
 * An empty sequence
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class EmptySequence extends AbstractSequence<Object> {

  public static EmptySequence INSTANCE = new EmptySequence();

  public static final class EmptyIterator implements Iterator<Object> {
    public static final EmptyIterator INSTANCE = new EmptyIterator();

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public Object next() {
      throw new NoSuchElementException();
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  private EmptySequence() {}

  @Override
  public Collector newCollector(final int size) {
    return new ListCollector(size, false);
  }

  @Override
  public int hintSize() {
    return 10;
  }

  @Override
  public Iterator<Object> iterator() {
    return EmptyIterator.INSTANCE;
  }

}
