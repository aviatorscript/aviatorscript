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


package com.googlecode.aviator.lexer.token;

import java.util.Map;


/**
 * Operator token
 *
 * @author dennis
 *
 */
public class OperatorToken extends AbstractToken<OperatorType> {


  private static final long serialVersionUID = -7479302090612995384L;
  private final OperatorType operatorType;

  public OperatorType getOperatorType() {
    return this.operatorType;
  }


  public OperatorToken(final Token<?> lookahead, final OperatorType operatorType) {
    super(operatorType.getToken(), lookahead != null ? lookahead.getLineNo() : 0,
        lookahead != null ? lookahead.getStartIndex() : -1);
    setMetaMap(lookahead != null ? lookahead.getMetaMap() : null);
    this.operatorType = operatorType;
  }


  @Override
  public com.googlecode.aviator.lexer.token.Token.TokenType getType() {
    return TokenType.Operator;
  }


  @Override
  public OperatorType getValue(final Map<String, Object> env) {
    return this.operatorType;
  }

}
