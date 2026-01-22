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

package com.googlecode.aviator.code.interpreter.ir;

import com.googlecode.aviator.code.interpreter.IR;
import com.googlecode.aviator.code.interpreter.InterpretContext;

public class AssertTypeIR implements IR {

  private static final long serialVersionUID = -856359371027702741L;

  public static enum AssertTypes {
    Number, String, Bool,
  }

  private final AssertTypes type;

  public AssertTypeIR(final AssertTypes type) {
    super();
    this.type = type;
  }

  @Override
  public void eval(final InterpretContext context) {
    switch (this.type) {
      case Bool:
        context.peek().booleanValue(context.getEnv());
        break;
      case Number:
        context.peek().numberValue(context.getEnv());
        break;
      case String:
        context.peek().stringValue(context.getEnv());
        break;
    }
    context.dispatch();
  }

  @Override
  public String toString() {
    return "assert " + this.type.name().toLowerCase();
  }

}
