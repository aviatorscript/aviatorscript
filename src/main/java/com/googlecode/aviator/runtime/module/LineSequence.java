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

package com.googlecode.aviator.runtime.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import com.googlecode.aviator.runtime.type.Collector;
import com.googlecode.aviator.runtime.type.Sequence;
import com.googlecode.aviator.runtime.type.seq.ListCollector;
import com.googlecode.aviator.utils.Reflector;

/**
 * Cast reader into a sequence of text lines in file.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
class LineSequence implements Sequence<String> {
  private final BufferedReader reader;

  public LineSequence(final BufferedReader reader) {
    super();
    this.reader = reader;
  }

  @Override
  public Iterator<String> iterator() {
    return new Iterator<String>() {
      String line;
      boolean eof;

      @Override
      public String next() {
        if (this.eof) {
          throw new NoSuchElementException();
        }
        return this.line;
      }

      private void readLine() {
        try {
          this.line = LineSequence.this.reader.readLine();
        } catch (IOException e) {
          throw Reflector.sneakyThrow(e);
        }
      }

      @Override
      public boolean hasNext() {
        if (this.eof) {
          return false;
        } else {
          readLine();
          this.eof = (this.line == null);
          return !this.eof;
        }
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }

    };
  }

  @Override
  public Collector newCollector(final int size) {
    return new ListCollector(size, false);
  }

  @Override
  public int hintSize() {
    return 0;
  }
}
