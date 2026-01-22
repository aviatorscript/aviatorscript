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
import com.googlecode.aviator.runtime.type.Sequence;

/**
 * Impl {@link Object#toString()} for sub-classes sequence.
 *
 * @author dennis(killme2008@gmail.com)
 *
 * @param <T>
 */
public abstract class AbstractSequence<T> implements Sequence<T> {

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());

    sb.append("[");
    boolean wasFirst = true;

    Iterator<T> it = iterator();
    while (it.hasNext()) {
      T e = it.next();

      if (wasFirst) {
        sb.append(e);
        wasFirst = false;
      } else {
        sb.append(", ").append(e);
      }
    }
    sb.append("]");

    return sb.toString();

  }


}
