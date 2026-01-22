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


package com.googlecode.aviator;

import java.util.List;
import java.util.Map;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.lexer.SymbolTable;
import com.googlecode.aviator.parser.VariableMeta;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.utils.Env;
import com.googlecode.aviator.utils.Reflector;

/**
 * Compiled expression,all generated class inherit this class
 *
 * @author dennis
 *
 */
public abstract class ClassExpression extends BaseExpression {

  private static final long serialVersionUID = -1335572034070560078L;

  protected transient byte[] classBytes;

  public byte[] getClassBytes() {
    return classBytes;
  }

  public void setClassBytes(byte[] classBytes) {
    this.classBytes = classBytes;
  }

  public ClassExpression(final AviatorEvaluatorInstance instance, final List<VariableMeta> vars,
      final SymbolTable symbolTable) {
    super(instance, vars, symbolTable);
  }

  @Override
  public Object executeDirectly(final Map<String, Object> env) {
    try {
      Object result = execute0((Env) env);
      if (RuntimeUtils.isTracedEval(env)) {
        RuntimeUtils.printlnTrace(env, "Result : " + result);
      }
      return result;
    } catch (ExpressionRuntimeException e) {
      throw e;
    } catch (Throwable t) {
      throw Reflector.sneakyThrow(t);
    }
  }

  public abstract Object execute0(Env env);

  /**
   * Get generated java class
   *
   * @return
   */
  public Class<?> getJavaClass() {
    return this.getClass();
  }
}
