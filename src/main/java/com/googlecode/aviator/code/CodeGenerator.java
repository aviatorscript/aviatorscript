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


package com.googlecode.aviator.code;

import com.googlecode.aviator.Expression;
import com.googlecode.aviator.lexer.token.Token;
import com.googlecode.aviator.parser.Parser;
import com.googlecode.aviator.runtime.FunctionParam;


/**
 * Code generator interface
 *
 * @author dennis
 *
 */
public interface CodeGenerator {

  public void onAssignment(Token<?> lookahead);

  public void setParser(Parser parser);

  public void onShiftRight(Token<?> lookahead);


  public void onShiftLeft(Token<?> lookahead);


  public void onUnsignedShiftRight(Token<?> lookahead);


  public void onBitOr(Token<?> lookahead);


  public void onBitAnd(Token<?> lookahead);


  public void onBitXor(Token<?> lookahead);


  public void onBitNot(Token<?> lookahead);


  public void onAdd(Token<?> lookahead);


  public void onSub(Token<?> lookahead);


  public void onMult(Token<?> lookahead);

  public void onExponent(Token<?> loohead);


  public void onDiv(Token<?> lookahead);


  public void onAndLeft(Token<?> lookahead);


  public void onAndRight(Token<?> alookahead);


  public void onTernaryBoolean(Token<?> lookahead);


  public void onTernaryLeft(Token<?> lookahead);


  public void onTernaryRight(Token<?> lookahead);

  public void onTernaryEnd(Token<?> lookahead);


  public void onJoinLeft(Token<?> lookahead);


  public void onJoinRight(Token<?> lookahead);


  public void onEq(Token<?> lookahead);


  public void onMatch(Token<?> lookahead);


  public void onNeq(Token<?> lookahead);


  public void onLt(Token<?> lookahead);


  public void onLe(Token<?> lookahead);


  public void onGt(Token<?> lookahead);


  public void onGe(Token<?> lookahead);


  public void onMod(Token<?> lookahead);


  public void onNot(Token<?> lookahead);


  public void onNeg(Token<?> lookahead);

  public Expression getResult(boolean unboxObject);

  public void onConstant(Token<?> lookahead);

  public void onMethodName(Token<?> lookahead);

  public void onMethodParameter(Token<?> lookahead);

  public void onMethodInvoke(Token<?> lookahead);

  public void onLambdaDefineStart(Token<?> lookahead);

  public void onLambdaArgument(Token<?> lookahead, FunctionParam param);

  public void onLambdaBodyStart(Token<?> lookahead);

  public void onLambdaBodyEnd(Token<?> lookahead);

  public void onArray(Token<?> lookahead);

  public void onArrayIndexStart(Token<?> token);

  public void onArrayIndexEnd(Token<?> lookahead);
}
