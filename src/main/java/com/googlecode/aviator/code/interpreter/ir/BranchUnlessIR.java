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

package com.googlecode.aviator.code.interpreter.ir;

import com.googlecode.aviator.code.interpreter.IR;
import com.googlecode.aviator.code.interpreter.InterpretContext;
import com.googlecode.aviator.runtime.type.AviatorObject;

public class BranchUnlessIR implements IR, JumpIR {
  private static final long serialVersionUID = 262499564579405793L;
  private int pc;
  private final Label label;
  private final SourceInfo sourceInfo;


  public BranchUnlessIR(final Label label, final SourceInfo sourceInfo) {
    super();
    this.label = label;
    this.sourceInfo = sourceInfo;
  }

  public int getPc() {
    return this.pc;
  }

  @Override
  public void setPc(final int pc) {
    this.pc = pc;
  }

  @Override
  public Label getLabel() {
    return this.label;
  }

  @Override
  public void eval(final InterpretContext context) {
    AviatorObject top = context.peek();
    if (!top.booleanValue(context.getEnv())) {
      context.jumpTo(this.pc);
      context.dispatch(false);
    } else {
      context.dispatch();
    }
  }

  @Override
  public boolean mayBeCost() {
    return true;
  }

  @Override
  public String toString() {
    return "branch_unless " + this.pc + "  [" + this.label + "]      " + this.sourceInfo;
  }
}
