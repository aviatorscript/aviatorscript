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

public class GotoIR implements IR, JumpIR {
  private static final long serialVersionUID = 5095135626036497287L;
  private int pc;
  private final Label label;
  private final SourceInfo sourceInfo;


  public GotoIR(final Label label, final SourceInfo sourceInfo) {
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
  public boolean mayBeCost() {
    return true;
  }

  @Override
  public void eval(final InterpretContext context) {
    context.jumpTo(this.pc);
    context.dispatch(false);
  }

  @Override
  public String toString() {
    return "goto " + this.pc + "  [" + this.label + "]      " + this.sourceInfo;
  }

}
