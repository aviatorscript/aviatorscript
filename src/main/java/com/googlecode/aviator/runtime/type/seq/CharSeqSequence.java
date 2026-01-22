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
import com.googlecode.aviator.runtime.type.Collector;

/**
 * Sequence for CharSequence.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class CharSeqSequence extends AbstractSequence<String> {
  private final CharSequence cs;


  public CharSeqSequence(final CharSequence cs) {
    super();
    this.cs = cs;
  }

  @Override
  public int hintSize() {
    return this.cs.length();
  }



  @Override
  public Collector newCollector(final int size) {
    return new ListCollector(size, false);
  }



  @Override
  public Iterator<String> iterator() {
    return new Iterator<String>() {
      int i = 0;

      @Override
      public boolean hasNext() {
        return this.i < CharSeqSequence.this.cs.length();
      }

      @Override
      public String next() {
        return String.valueOf(CharSeqSequence.this.cs.charAt(this.i++));
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }

    };
  }

}
