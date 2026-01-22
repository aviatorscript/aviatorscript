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


package com.googlecode.aviator.runtime.function.system;

import java.util.Map;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.op.OperationRuntime;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * Binary function,includes +,-,*,/,%,!
 *
 * @author dennis
 *
 */
public class BinaryFunction extends AbstractFunction {

  private static final long serialVersionUID = -7543895978170666671L;
  private final OperatorType opType;


  public BinaryFunction(final OperatorType opType) {
    super();
    this.opType = opType;
  }


  @Override
  public String getName() {
    return this.opType.getToken();
  }


  public OperatorType getOpType() {
    return this.opType;
  }


  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {
    return OperationRuntime.eval(arg1, arg2, env, this.opType);
  }


  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    AviatorObject left = arg1;
    switch (this.opType) {
      case BIT_AND:
      case BIT_OR:
      case BIT_XOR:
      case ADD:
      case SUB:
      case MULT:
      case Exponent:
      case DIV:
      case MOD:
        return throwArity(1);
      case NOT:
      case NEG:
        return OperationRuntime.eval(left, null, env, this.opType);
      default:
        throw new ExpressionRuntimeException("Invalid binary operator");

    }
  }

}
