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

package com.googlecode.aviator.lexer.token;

import java.util.Map;
import com.googlecode.aviator.runtime.LambdaFunctionBootstrap;


/**
 * Delegate token,wrap a token with special syntax structure
 *
 * @author dennis
 *
 */
public class DelegateToken extends AbstractToken<Token<?>> {


  private static final long serialVersionUID = -1564600597069979843L;
  private final Token<?> token;
  private final DelegateTokenType delegateTokenType;
  private LambdaFunctionBootstrap lambdaFunctionBootstrap;



  public LambdaFunctionBootstrap getLambdaFunctionBootstrap() {
    return this.lambdaFunctionBootstrap;
  }


  public void setLambdaFunctionBootstrap(final LambdaFunctionBootstrap lambdaFunctionBootstrap) {
    this.lambdaFunctionBootstrap = lambdaFunctionBootstrap;
  }


  public static enum DelegateTokenType {
    And_Left, Join_Left, Ternary_Boolean, Ternary_Left, Array, Index_Start, //
    Method_Name, Method_Param, Lambda_New, //
    Ternay_End
  }


  public Token<?> getToken() {
    return this.token;
  }


  public DelegateTokenType getDelegateTokenType() {
    return this.delegateTokenType;
  }


  public DelegateToken(final Token<?> token, final DelegateTokenType type) {
    super(token != null ? token.getLexeme() : "", token != null ? token.getLineNo() : 0,
        token != null ? token.getStartIndex() : -1);
    this.token = token;
    this.delegateTokenType = type;
    if (token != null) {
      setMetaMap(token.getMetaMap());
    }
  }


  @Override
  public com.googlecode.aviator.lexer.token.Token.TokenType getType() {
    return TokenType.Delegate;
  }


  @Override
  public Token<?> getValue(final Map<String, Object> env) {
    return this.token;
  }

}
