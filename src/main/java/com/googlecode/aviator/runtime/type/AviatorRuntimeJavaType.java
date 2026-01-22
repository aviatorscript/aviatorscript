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


package com.googlecode.aviator.runtime.type;

import java.util.Map;
import java.util.concurrent.Callable;
import com.googlecode.aviator.utils.Reflector;
import com.googlecode.aviator.utils.VarNameGenerator;


/**
 * Aviator runtime java type,used by when generate runtime result.
 *
 * @author dennis
 *
 */
public class AviatorRuntimeJavaType extends AviatorJavaType {


  private static final long serialVersionUID = 3107203976124904223L;

  public static final ThreadLocal<VarNameGenerator> TEMP_VAR_GEN =
      new ThreadLocal<VarNameGenerator>() {

        @Override
        protected VarNameGenerator initialValue() {
          return new VarNameGenerator();
        }

      };

  protected Object object;
  protected Callable<Object> callable;

  public static AviatorObject valueOf(final Object object) {
    if (object == null) {
      return AviatorNil.NIL;
    }
    if (object instanceof AviatorObject) {
      return (AviatorObject) object;
    }
    return new AviatorRuntimeJavaType(object);
  }

  /**
   * Deprecated since 5.0.0, please use {@link AviatorRuntimeJavaType#valueOf(Object)} instead.
   *
   * @deprecated
   * @param object
   */
  @Deprecated
  public AviatorRuntimeJavaType(final Object object) {
    super(null);
    this.object = object;
  }

  public Callable<Object> getCallable() {
    return this.callable;
  }

  public void setCallable(final Callable<Object> callable) {
    this.callable = callable;
  }

  public static String genName() {
    return TEMP_VAR_GEN.get().gen();
  }

  @Override
  public String getName() {
    if (this.name == null) {
      this.name = genName();
    }
    return this.name;
  }

  @Override
  public Object getValue(final Map<String, Object> env) {
    if (this.callable != null) {
      try {
        return this.callable.call();
      } catch (Exception e) {
        throw Reflector.sneakyThrow(e);
      }
    }
    return this.object;
  }

}
