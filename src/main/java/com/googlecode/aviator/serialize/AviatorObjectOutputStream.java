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

package com.googlecode.aviator.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.googlecode.aviator.ClassExpression;
import com.googlecode.aviator.runtime.type.Range;

/**
 * A special ObjectOutputStream that will write the generated script class byte array.
 * 
 * @author dennis
 * @since 5.3.4
 *
 */
public class AviatorObjectOutputStream extends ObjectOutputStream {

  private Map<String, byte[]> classBytesCache = new HashMap<String, byte[]>();

  public AviatorObjectOutputStream(OutputStream out) throws IOException {
    super(out);
    this.enableReplaceObject(true);
  }


  @Override
  protected Object replaceObject(Object obj) throws IOException {
    if (obj instanceof ClassExpression) {
      this.classBytesCache.put(obj.getClass().getName(), ((ClassExpression) obj).getClassBytes());
    }

    return super.replaceObject(obj);
  }

  @Override
  protected void annotateClass(Class<?> cl) throws IOException {
    if (ClassExpression.class.isAssignableFrom(cl) && cl != ClassExpression.class) {
      byte[] classBytes = this.classBytesCache.get(cl.getName());
      if (classBytes == null) {
        throw new IllegalArgumentException("Class bytes not found: " + cl.getName()
            + ", forgot to enable Options.SERIALIZABLE before compiling the script?");
      }
      this.writeInt(classBytes.length);
      this.write(classBytes);

    }
  }

}
