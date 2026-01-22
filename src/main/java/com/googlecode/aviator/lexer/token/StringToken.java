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


/**
 * String token
 *
 * @author dennis
 *
 */
public class StringToken extends AbstractToken<java.lang.String> {


  private static final long serialVersionUID = -8305143945358948254L;


  public StringToken(final String lexeme, final int lineNo, final int startIndex) {
    super(lexeme, lineNo, startIndex);
  }


  @Override
  public TokenType getType() {
    return TokenType.String;
  }


  @Override
  public java.lang.String getValue(final Map<String, Object> env) {
    return this.lexeme;
  }

}
