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


package com.googlecode.aviator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import com.googlecode.aviator.parser.VariableMeta;
import com.googlecode.aviator.runtime.RuntimeUtils;


/**
 * A literal expression with a fixed result
 *
 * @author dennis
 *
 */
public class LiteralExpression extends BaseExpression {

  private static final long serialVersionUID = 7320801048592600557L;
  private Object result;

  public LiteralExpression(final AviatorEvaluatorInstance instance, final Object result,
      final List<VariableMeta> vars) {
    super(instance, vars, null);
    this.result = result;
  }

  @Override
  public Object executeDirectly(final Map<String, Object> env) {
    if (RuntimeUtils.isTracedEval(env)) {
      RuntimeUtils.printlnTrace(env, "Tracing: " + getExpression());
      RuntimeUtils.printlnTrace(env, "Result : " + getExpression());
    }
    return this.result;
  }

  @Override
  public String toString() {
    return "LiteralExpression [result=" + this.result + "]";
  }

  private void readObject(ObjectInputStream input) throws ClassNotFoundException, IOException {
    super.customReadObject(input);
    this.result = input.readObject();
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    super.customWriteObject(output);
    output.writeObject(this.result);
  }
}
