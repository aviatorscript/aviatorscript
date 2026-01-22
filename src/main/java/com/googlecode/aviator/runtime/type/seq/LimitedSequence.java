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
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.type.Collector;
import com.googlecode.aviator.runtime.type.Sequence;

public class LimitedSequence<T> extends AbstractSequence<T> {

  private final Sequence<T> seq;
  private final int maxLoopCount;


  public LimitedSequence(final Sequence<T> seq, final int maxLoopCount) {
    super();
    this.seq = seq;
    this.maxLoopCount = maxLoopCount;
  }

  @Override
  public Iterator<T> iterator() {
    final Iterator<T> rawIt = this.seq.iterator();
    return new Iterator<T>() {
      int c = 0;

      @Override
      public boolean hasNext() {
        return rawIt.hasNext();
      }

      @Override
      public T next() {
        if (++this.c > LimitedSequence.this.maxLoopCount) {
          throw new ExpressionRuntimeException(
              "Overflow max loop count: " + LimitedSequence.this.maxLoopCount);
        }
        return rawIt.next();
      }

      @Override
      public void remove() {
        rawIt.remove();
      }

    };
  }

  @Override
  public Collector newCollector(final int size) {
    return this.seq.newCollector(size);
  }

  @Override
  public int hintSize() {
    return this.seq.hintSize();
  }

}
