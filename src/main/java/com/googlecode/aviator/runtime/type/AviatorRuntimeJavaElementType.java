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

package com.googlecode.aviator.runtime.type;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.utils.ArrayUtils;
import com.googlecode.aviator.utils.Reflector;

public class AviatorRuntimeJavaElementType extends AviatorRuntimeJavaType {


  private static final long serialVersionUID = -955529214730255727L;
  private final Object index;
  private final Object container;

  private final ContainerType containerType;

  public static enum ContainerType {
    List, Array, Map
  }

  public AviatorRuntimeJavaElementType(final ContainerType containerType, final Object container,
      final Object index, final Callable<Object> callable) {
    super(null);
    setCallable(callable);
    this.container = container;
    this.index = index;
    this.containerType = containerType;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public AviatorObject setValue(final AviatorObject value, final Map<String, Object> env) {
    Object val = value.getValue(env);
    switch (this.containerType) {
      case Array:
        ArrayUtils.set(this.container, (int) this.index,
            Reflector.boxArg(this.container.getClass().getComponentType(), val));
        break;
      case List:
        ((List) this.container).set((int) this.index, val);
        break;
      case Map:
        ((Map) this.container).put(this.index, val);
        break;
      default:
        throw new ExpressionRuntimeException("Unknown container type: " + this.containerType);
    }
    return AviatorRuntimeJavaType.valueOf(val);
  }
}
